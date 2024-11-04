package br.com.amanda.gestao.service;

import br.com.amanda.gestao.dao.FuncionarioDao;
import br.com.amanda.gestao.model.entities.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioDao funcionarioDao;

    @Transactional(readOnly = true)
    public Funcionario pesquisarFuncionario(long id) throws Exception {
        return funcionarioDao.pesquisarFuncionario(id);
    }

    @Transactional(readOnly = true)
    public List<Funcionario> listarFuncionarios() throws Exception {
        return funcionarioDao.listarFuncionarios();
    }

    @Transactional
    public void criarFuncionario(Funcionario funcionario) throws Exception {
        funcionarioDao.criarFuncionario(funcionario);
    }

    @Transactional
    public void editarFuncionario(Funcionario funcionario) throws Exception {
        funcionarioDao.editarFuncionario(funcionario);
    }

    @Transactional
    public void excluirFuncionario(Funcionario funcionario) throws Exception {
        funcionarioDao.excluirFuncionario(funcionario);
    }
}