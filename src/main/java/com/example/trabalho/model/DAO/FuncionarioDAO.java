package com.example.trabalho.model.DAO;

import com.example.trabalho.model.Funcionario;


import java.util.List;

public interface FuncionarioDAO {

    public Funcionario pesquisarFuncionario(long id) throws Exception;
    public List<Funcionario> listarFuncionarios() throws Exception;
    public void criarFuncionario(Funcionario funcionario) throws Exception;
    public void editarFuncionario(Funcionario funcionario) throws Exception;
    public void excluirFuncionario(Funcionario funcionario) throws Exception;
    //void salvarFuncionario(Funcionario funcionario) throws Exception;
}
