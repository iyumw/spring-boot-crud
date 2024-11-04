package br.com.amanda.gestao.controller;

import br.com.amanda.gestao.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.amanda.gestao.model.entities.Solicitacao;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> pesquisarSolicitacao(@PathVariable long id) {
        try {
            Solicitacao solicitacao = solicitacaoService.pesquisarSolicitacao(id);
            return ResponseEntity.ok(solicitacao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Pode incluir uma mensagem de erro mais detalhada
        }
    }

    @GetMapping
    public ResponseEntity<List<Solicitacao>> listarSolicitacoes() {
        try {
            List<Solicitacao> solicitacoes = solicitacaoService.listarSolicitacoes();
            return ResponseEntity.ok(solicitacoes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> criarSolicitacao(@RequestBody Solicitacao solicitacao) {
        try {
            solicitacaoService.criarSolicitacao(solicitacao);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarSolicitacao(@PathVariable long id, @RequestBody Solicitacao solicitacao) {
        try {
            solicitacao.setId(id); // Assegura que o ID da solicitação está correto
            solicitacaoService.editarSolicitacao(solicitacao);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSolicitacao(@PathVariable long id) {
        try {
            Solicitacao solicitacao = solicitacaoService.pesquisarSolicitacao(id);
            if (solicitacao != null) {
                solicitacaoService.excluirSolicitacao(solicitacao);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
