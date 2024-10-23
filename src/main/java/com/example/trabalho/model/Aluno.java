package com.example.trabalho.model;

import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private String RA;

    public Aluno() {

    }

    public Aluno(String nome, String RA) {
        this.nome = nome;
        this.RA = RA;
    }

    public void fazerLogin() {

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRA() {
        return RA;
    }
    public void setRA(String RA) {
        this.RA = RA;
    }
}
