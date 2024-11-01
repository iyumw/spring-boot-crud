package com.example.trabalho.controller;

import com.example.trabalho.model.Funcionario;
import com.example.trabalho.model.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;
import java.text.ParseException;

import java.util.List;

@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping("/listarFunc")
    @ResponseBody
    public String listarFuncionario() {
        String retorno = "";

        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            retorno += " => " + funcionario.toString() + "\n";
        }
        return retorno;
    }

    @RequestMapping("/pesquisarFunc")
    @ResponseBody
    public String pesquisarFuncionario(@RequestParam(value = "identificação") long id) {
        String retorno = "";

        Funcionario funcionario = funcionarioService.pesquisarFuncionario(id);
        retorno += " => "+ funcionario.toString();

        return retorno;
    }

    @RequestMapping("/salvarFunc")
    @ResponseBody
    public String salvarFuncionario(@RequestParam Map<String, String> parametros) throws ParseException {
        String retorno = "";

        long id = Long.parseLong(parametros.get("identificação"));
        String nome = parametros.get("nome");
        boolean ok = funcionarioService.salvarFuncionario(id, new Funcionario(nome, id));
        retorno += "=> Funcionário salvo: "+ ok;

        return retorno;
    }

    @RequestMapping("/excluirFunc")
    @ResponseBody
    public String excluirFuncionario(@RequestParam(value = "identificação") long id) {
        String retorno = "";

        boolean ok = funcionarioService.excluirFuncionario(id);
        retorno += " => Funcionário excluído: "+ ok;

        return retorno;
    }


}
