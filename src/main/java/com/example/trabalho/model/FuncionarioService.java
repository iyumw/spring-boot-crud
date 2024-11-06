package com.example.trabalho.model;
import org.springframework.transaction.annotation.Transactional;
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
        System.out.println(lista);
        return lista;
    }

    public Funcionario pesquisarFuncionario(long id){
        Funcionario func;
        
        try {
            func = funcionarioDAO.pesquisarFuncionario(id);
        } catch (Exception e) {
            System.err.printf("Erro ao pesquisar funcionario % d", id);
            System.err.println(e.getMessage());
            func = null;
        }
        return func;
    }

    // public boolean salvarFuncionario(long id, Funcionario funcionario){
    //     boolean sucesso = false;

    //     try {
    //         Funcionario encontrado = funcionarioDAO.pesquisarFuncionario(id);

    //         if(encontrado == null){
    //             funcionarioDAO.salvarFuncionario(funcionario);
    //             sucesso = true;
    //         } else {
    //             sucesso = false;
    //         }
    //     } catch (Exception e) {
    //         System.err.printf("Erro ao incluir/alterar o funcionário %d", id);
    //         System.err.println(e.getMessage());
    //     }
    //     return sucesso;
    // }
    public void salvarFuncionario(Funcionario funcionario) {
        try
        {funcionarioDAO.salvarFuncionario(funcionario);}
        catch (Exception e) {
                     System.err.printf("Erro ao incluir/alterar o funcionário %d");
                     System.err.println(e.getMessage());
                 }
    }
//}
    // public boolean excluirFuncionario(long id){
    //     boolean sucesso = false;

    //     try {
    //         Funcionario encontrado = funcionarioDAO.pesquisarFuncionario(id);
    //         if(encontrado == null){
    //             funcionarioDAO.excluirFuncionario(encontrado);
    //             sucesso = true;
    //         } else {
    //             System.err.printf("Funcionário %d não pode ser excluído, pois não foi encontrado" + id);
    //         }
    //     } catch (Exception e) {
    //         System.err.printf("Erro ao excluir o funcionário %d", id);
    //         System.err.println(e.getMessage());
    //     }
    //     return sucesso;
    // }

    public boolean excluirFuncionario(long id) {
        boolean sucesso = false;
    
        try {
            Funcionario encontrado = funcionarioDAO.pesquisarFuncionario(id);
            if (encontrado != null) {
                funcionarioDAO.excluirFuncionario(encontrado);
                sucesso = true;
            } else {
                System.err.printf("Funcionário %d não pode ser excluído, pois não foi encontrado\n", id);
            }
        } catch (Exception e) {
            System.err.printf("Erro ao excluir o funcionário %d: %s\n", id, e.getMessage());
        }
        return sucesso;
    }

    // @Transactional
    // public void criarFuncionario(Funcionario funcionario) throws Exception {
    //     funcionarioDAO.criarFuncionario(funcionario);
    // }
    
}
