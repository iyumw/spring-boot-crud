package com.example.trabalho.model;

import com.example.trabalho.model.bd.SolicitacaoDAO;
import com.example.trabalho.model.bd.FuncionarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitacaoService {
    @Autowired
    private SolicitacaoDAO solicitacaoDAO;
    @Autowired
    private FuncionarioDAO funcionarioDAO;

    public List<Solicitacao> listarSolicitacoes() {
        List<Solicitacao> lista = null;

        try {
            lista = solicitacaoDAO.listarSolicitacoes();
        } catch (Exception e) {
            System.err.printf("Falha ao listar solicitações" + e.getMessage());
        }
        return lista;
    }

    public boolean incluirSolicitacao(long cod, Solicitacao solicitacao) {
        boolean sucesso = false;

        try {
            Solicitacao encontrada = solicitacaoDAO.buscarSolicitacao(cod);
            if (encontrada == null) {
                solicitacaoDAO.criarSolicitacao(solicitacao);
                for (Funcionario f : solicitacao.getGrupoFunc()) {
                    f.setSolicitacao(solicitacao);
                    funcionarioDAO.editarFuncionario(f);
                }
                sucesso = true;
            } else {
                encontrada.setCod(solicitacao.getCod());
                encontrada.setTitulo(solicitacao.getTitulo());
                encontrada.setAssunto(solicitacao.getAssunto());
                encontrada.setGrupoFunc(encontrada.getGrupoFunc());

                for (Funcionario f : encontrada.getGrupoFunc()) {
                    f.setSolicitacao(encontrada);
                    funcionarioDAO.editarFuncionario(f);
                }
                sucesso = true;
            }
        } catch (Exception e) {
            System.err.printf("Erro ao incluir solicitação %d.",
                    cod);
            System.err.println(e.getMessage());
        }
        return sucesso;
    }

    public boolean excluirSolicitacao(long cod) {
        boolean sucesso = false;

        try {
            Solicitacao encontrada = solicitacaoDAO.buscarSolicitacao(cod);
            if (encontrada != null) {
                solicitacaoDAO.deletarSolicitacao(encontrada);
                sucesso = true;
            } else {
                System.err.printf("Solicitação %d não pôde ser excluída, pois não foi encontrada", cod);
            }
        } catch (Exception e) {
            System.err.printf("Falha ao deletar a solicitação %d.", cod);
            System.err.println(e.getMessage());
        }
        return sucesso;
    }

    public Solicitacao buscarSolicitacao(long cod) {
        Solicitacao solicitacao = null;
        
        try {
            solicitacao = solicitacaoDAO.buscarSolicitacao(cod);
        } catch (Exception e) {
            System.err.printf("Erro ao pesquisar solicitação %d", cod);
            System.err.println(e.getMessage());
        }
        return solicitacao;
    }
}
