package com.example.trabalho.model.bd;

import com.example.trabalho.model.Solicitacao;

import java.util.List;

public interface SolicitacaoDAO {
    public List<Solicitacao> listarSolicitacoes() throws Exception;
    public void criarSolicitacao(Solicitacao solicitacao) throws Exception;
    public void deletarSolicitacao(Solicitacao solicitacao) throws Exception;

    void incluirSolicitacao(long cod, Solicitacao solicitacao) throws Exception;

    public Solicitacao buscarSolicitacao(long cod) throws Exception;

}
