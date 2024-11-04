package br.com.amanda.gestao.controller;

import br.com.amanda.gestao.model.entities.Funcionario;
import br.com.amanda.gestao.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;






@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> pesquisarFuncionario(@PathVariable long id) {
        try {
            Funcionario funcionario = funcionarioService.pesquisarFuncionario(id);
            return ResponseEntity.ok(funcionario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // @GetMapping
    // public ResponseEntity<List<Funcionario>> listarFuncionarios() {
    // try {
    // List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
    // return ResponseEntity.ok(funcionarios);
    // } catch (Exception e) {
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    // }
    // }

    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
            return ResponseEntity.ok(funcionarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> criarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            funcionarioService.criarFuncionario(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarFuncionario(@PathVariable long id, @RequestBody Funcionario funcionario) {
        try {
            funcionario.setId(id);
            funcionarioService.editarFuncionario(funcionario);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable long id) {
        try {
            Funcionario funcionario = funcionarioService.pesquisarFuncionario(id);
            if (funcionario != null) {
                funcionarioService.excluirFuncionario(funcionario);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
