package com.example.trabalho.model.bd;

import com.example.trabalho.model.Funcionario;
import com.example.trabalho.model.Solicitacao;

import java.util.List;

public interface FuncionarioDAO {

    public Funcionario pesquisarFuncionario(long id) throws Exception;
    public List<Funcionario> listarFuncionarios() throws Exception;
    // public void criarFuncionario(Funcionario funcionario) throws Exception;
    public void editarFuncionario(Funcionario funcionario) throws Exception;
    public void excluirFuncionario(Funcionario funcionario) throws Exception;
    void salvarFuncionario(Funcionario funcionario) throws Exception;
}
