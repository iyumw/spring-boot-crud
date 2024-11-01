package com.example.trabalho.model.bd;

import com.example.trabalho.model.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("Hibernate")
public class FuncionarioDAOImpl implements FuncionarioDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Funcionario pesquisarFuncionario(long id) throws Exception {
        return null;
    }

    @Override
    public List<Funcionario> listarFuncionarios() throws Exception {
        return
        entityManager.createQuery("from Funcionario", Funcionario.class).getResultList();
    }

    @Override
    public void criarFuncionario(Funcionario funcionario) throws Exception {
        entityManager.persist(funcionario);
    }

    @Override
    public void editarFuncionario(Funcionario funcionario) throws Exception {
        entityManager.merge(funcionario);
    }

    @Override
    public void excluirFuncionario(Funcionario funcionario) throws Exception {
    entityManager.remove(funcionario);
    }

}
