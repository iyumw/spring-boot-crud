package com.example.trabalho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String titulo;
    private String assunto;
    private String[] anexo;
    private Date dataEnvio;

    public Solicitacao() {


    }

    public void validarSolicitacao(){

   }

    public void visualizarSolicitacao(){

   }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public String[] getAnexo() {
        return anexo;
    }
    public void setAnexo(String[] anexo) {
        this.anexo = anexo;
    }
    public Date getDataEnvio() {
        return dataEnvio;
    }
    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

}
