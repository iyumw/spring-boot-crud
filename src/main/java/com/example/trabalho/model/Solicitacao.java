package com.example.trabalho.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private String titulo;
    private String assunto;


    @OneToMany(mappedBy = "solicitacao")
    private List<Funcionario> grupoFunc = new ArrayList<Funcionario>();

    public Solicitacao() {}

    public Solicitacao(String titulo, String assunto, List<Funcionario> grupoFunc) {
        this.titulo = titulo;
        this.assunto = assunto;
        this.grupoFunc = grupoFunc;
    }

    public Long getCod() {
        return cod;
    }
    public void setCod(Long cod) {
        this.cod = cod;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAssunto() {
        return assunto;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public List<Funcionario> getGrupoFunc() {
        return grupoFunc;
    }

    public void setGrupoFunc(List<Funcionario> grupoFunc) {
        this.grupoFunc = grupoFunc;
    }

    @Override
    public String toString() {
        return "Solicitação [codigo=" + cod + ", titulo=" + titulo + ", assunto=" + assunto + ", número de funcionários=" + grupoFunc.size() + "]";
    }

}


