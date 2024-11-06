package com.example.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.trabalho.model.Funcionario;
import com.example.trabalho.model.FuncionarioService;

@Controller
public class CriarFuncController {
    @Autowired
    private FuncionarioService funcionarioService;
    
    @PostMapping("/criarFunc")
    public String criarFuncionario(@RequestParam("nome") String nome) {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nome);
            funcionarioService.criarFuncionario(funcionario);
            return "redirect:/listarFunc"; // Redireciona para a página de listagem após adicionar
        } catch (Exception e) {
            e.printStackTrace(); // Exibe a exceção no console para depuração
            return "error"; // Retorna uma página de erro ou uma mensagem de erro
        }
    }

    @GetMapping("/criarFunc")
    public String criarFuncionario() {
        return "criarFunc";
    }
}
