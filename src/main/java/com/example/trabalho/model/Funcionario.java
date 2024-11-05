package com.example.trabalho.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "solicitacao")
    private Solicitacao solicitacao;

    public Funcionario() {

    }

    public Funcionario(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }

    public Funcionario(String nome, long id) {
        this.nome = nome;
        this.id = id;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Solicitacao getSolicitacao() {
        return solicitacao;
    }
    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }
    public String toString(){
        return "Funcionario [id=" + id + ", nome=" + nome + ", solicitacoes=" + getSolicitacao() + "]";
    }
}
