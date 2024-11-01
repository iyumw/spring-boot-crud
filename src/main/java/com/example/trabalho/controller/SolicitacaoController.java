package com.example.trabalho.controller;

import com.example.trabalho.model.Funcionario;
import com.example.trabalho.model.FuncionarioService;
import com.example.trabalho.model.Solicitacao;
import com.example.trabalho.model.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SolicitacaoController {
    @Autowired
    private SolicitacaoService solicitacaoService;
    @Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping("/listarSolic")
    @ResponseBody
    public String listarSolicitacao() {
        String retorno = "";

        List<Solicitacao> solicitacoes = solicitacaoService.listarSolicitacoes();

        for (Solicitacao solicitacao : solicitacoes) {
            retorno += " => " + solicitacao.toString();
        }
        return retorno;
    }

    @RequestMapping("/pesquisarSolic")
    @ResponseBody
    public String pesquisarSolicitacao(@RequestParam(value = "codigo") long cod) {
        String retorno = "";

        Solicitacao solicitacao = solicitacaoService.buscarSolicitacao(cod);
        retorno += " => " + solicitacao.toString();

        return retorno;
    }

    @RequestMapping("/salvarSolic")
    @ResponseBody
    public String salvarSolicitacoes(@RequestParam Map<String, String> parametros) throws ParseException {
        String retorno = "";
        long cod = Long.parseLong(parametros.get("codigo"));
        String titulo = parametros.get("titulo");
        String assunto  = parametros.get("assunto");
        List<Funcionario> grupoFunc = new ArrayList<Funcionario>();

        boolean ok = solicitacaoService.incluirSolicitacao(cod, new Solicitacao(titulo, assunto, grupoFunc));
        retorno += "=> Solicitação salva: " + ok;

        return retorno;
    }

    @RequestMapping("/excluirSolic")
    @ResponseBody
    public String excluirSolicitacao(@RequestParam(value = "codigo") long cod) {
        String retorno = "";

        boolean ok = solicitacaoService.excluirSolicitacao(cod);
        retorno += " => Solicitação excluída: " + ok;

        return retorno;
    }
}
