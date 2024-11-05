package com.example.trabalho.model.bd;

import com.example.trabalho.model.Solicitacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Repository
@Transactional
public class SolicitacaoDAOImpl implements SolicitacaoDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Solicitacao> listarSolicitacoes() throws SQLException {
        return entityManager.createQuery("from Solicitacao", Solicitacao.class).getResultList();    }

    @Override
    public void incluirSolicitacao(long cod, Solicitacao solicitacao) throws Exception {
    entityManager.persist(solicitacao);
    }

    @Override
    public Solicitacao buscarSolicitacao(long cod) throws Exception {
    return entityManager.find(Solicitacao.class, cod);
    }

    @Override
    public void criarSolicitacao(Solicitacao solicitacao) throws Exception {
        entityManager.persist(solicitacao);
    }

    @Override
    public void deletarSolicitacao(Solicitacao solicitacao) throws Exception {
    entityManager.remove(solicitacao);
    }
}
