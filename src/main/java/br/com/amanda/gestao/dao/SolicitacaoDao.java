package br.com.amanda.gestao.dao;

import br.com.amanda.gestao.model.entities.Solicitacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class SolicitacaoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Solicitacao pesquisarSolicitacao(long id) throws Exception {
        try {
            return entityManager.find(Solicitacao.class, id);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar solicitação com ID: " + id, e);
        }
    }

    public List<Solicitacao> listarSolicitacoes() throws Exception {
        try {
            return entityManager.createQuery("FROM Solicitacao", Solicitacao.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Erro ao listar solicitações", e);
        }
    }

    public void criarSolicitacao(Solicitacao solicitacao) throws Exception {
        try {
            entityManager.persist(solicitacao);
        } catch (Exception e) {
            throw new Exception("Erro ao criar solicitação", e);
        }
    }

    public void editarSolicitacao(Solicitacao solicitacao) throws Exception {
        try {
            entityManager.merge(solicitacao);
        } catch (Exception e) {
            throw new Exception("Erro ao editar solicitação", e);
        }
    }

    public void excluirSolicitacao(Solicitacao solicitacao) throws Exception {
        try {
            Solicitacao managedSolicitacao = entityManager.contains(solicitacao) ? solicitacao : entityManager.merge(solicitacao);
            entityManager.remove(managedSolicitacao);
        } catch (Exception e) {
            throw new Exception("Erro ao excluir solicitação", e);
        }
    }
}
