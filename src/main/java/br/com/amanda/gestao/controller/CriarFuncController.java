package br.com.amanda.gestao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CriarFuncController {
    @GetMapping("/criarFunc")
    public String criarFuncionario() {
        return "criarFunc";
    }
}
