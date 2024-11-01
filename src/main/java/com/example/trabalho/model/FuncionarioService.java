package com.example.trabalho.model;

import com.example.trabalho.model.bd.FuncionarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FuncionarioService {
    @Autowired
    @Qualifier("Hibernate")
    private FuncionarioDAO funcionarioDAO;

    public List<Funcionario> listarFuncionarios(){
        List<Funcionario> lista = null;

        try {
            lista = funcionarioDAO.listarFuncionarios();
        } catch (Exception e){
            System.err.println("Erro ao listar funcionarios: " + e.getMessage());
        }
        return lista;
    }

    public Funcionario pesquisarFuncionario(long id){
        Funcionario funcionario = null;
        try {
            funcionarioDAO.pesquisarFuncionario(id);
        } catch (Exception e) {
            System.err.printf("Erro ao pesquisar funcionario % d", id);
            System.err.println(e.getMessage());
        }
        return funcionario;
    }

    public boolean salvarFuncionario(long id, Funcionario funcionario){
        boolean sucesso = false;

        try {
            Funcionario encontrado = funcionarioDAO.pesquisarFuncionario(id);

            if(encontrado == null){
                funcionarioDAO.criarFuncionario(funcionario);
                sucesso = true;
            } else {
                encontrado.setNome(funcionario.getNome());
                funcionarioDAO.editarFuncionario(encontrado);
                sucesso = true;
            }
        } catch (Exception e) {
            System.err.printf("Erro ao incluir/alterar o funcionário %d", id);
            System.err.println(e.getMessage());
        }
        return sucesso;
    }

    public boolean excluirFuncionario(long id){
        boolean sucesso = false;

        try {
            Funcionario encontrado = funcionarioDAO.pesquisarFuncionario(id);
            if(encontrado == null){
                funcionarioDAO.excluirFuncionario(encontrado);
                sucesso = true;
            } else {
                System.err.printf("Funcionário %d não pode ser excluído, pois não foi encontrado" + id);
            }
        } catch (Exception e) {
            System.err.printf("Erro ao excluir o funcionário %d", id);
            System.err.println(e.getMessage());
        }
        return sucesso;
    }
}
