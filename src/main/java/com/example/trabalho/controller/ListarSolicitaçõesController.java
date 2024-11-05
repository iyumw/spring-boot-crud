package com.example.trabalho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListarSolicitaçõesController {
    @GetMapping("/solicitacoes")
    public String criarFuncionario() {
        return "solicitacoes";
    }
}
