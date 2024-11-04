package br.com.amanda.gestao.dao;

import br.com.amanda.gestao.model.entities.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository("Hibernate")
public class FuncionarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Funcionario pesquisarFuncionario(long id) throws Exception {
        try {
            return entityManager.find(Funcionario.class, id);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar funcionário com ID: " + id, e);
        }
    }

    public List<Funcionario> listarFuncionarios() throws Exception {
        try {
            return entityManager.createQuery("FROM Funcionario", Funcionario.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Erro ao listar funcionários", e);
        }
    }

    public void criarFuncionario(Funcionario funcionario) throws Exception {
        try {
            entityManager.persist(funcionario);
        } catch (Exception e) {
            throw new Exception("Erro ao criar funcionário", e);
        }
    }

    public void editarFuncionario(Funcionario funcionario) throws Exception {
        try {
            entityManager.merge(funcionario);
        } catch (Exception e) {
            throw new Exception("Erro ao editar funcionário", e);
        }
    }

    public void excluirFuncionario(Funcionario funcionario) throws Exception {
        try {
            Funcionario managedFuncionario = entityManager.contains(funcionario) ? funcionario : entityManager.merge(funcionario);
            entityManager.remove(managedFuncionario);
        } catch (Exception e) {
            throw new Exception("Erro ao excluir funcionário", e);
        }
    }
}