package com.example.trabalho.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.trabalho.model.bd.FuncionarioDAO;


@Service
public class FuncionarioService {
    @Autowired
    @Qualifier("Hibernate")
    private FuncionarioDAO funcionarioDAO;

    private List<Funcionario> funcionarios = new ArrayList<>();

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
    // public void salvarFuncionario(Funcionario funcionario) {
    //     try
    //     {funcionarioDAO.salvarFuncionario(funcionario);}
    //     catch (Exception e) {
    //                  System.err.printf("Erro ao incluir/alterar o funcionário %d");
    //                  System.err.println(e.getMessage());
    //              }
    // }
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

    // public void criarFuncionario(Funcionario funcionario) throws Exception {
    //     try {
    //         entityManager.persist(funcionario);
    //     } catch (Exception e) {
    //         throw new Exception("Erro ao criar funcionário", e);
    //     }
    // }

    // Método para criar um novo funcionário, recebendo o ID do usuário
    @PostMapping("/funcionarios")
    public Funcionario criarFuncionario(Funcionario funcionario) {
        for (Funcionario f : funcionarios) {
            if (f.getId().equals(funcionario.getId())) {
                throw new RuntimeException("Já existe um funcionário com o ID " + funcionario.getId() + ".");
            }
        }
        
        funcionarios.add(funcionario);
        return funcionario;
    }

    public Funcionario editarFuncionario(Long id, Funcionario dadosAtualizados) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                funcionario.setNome(dadosAtualizados.getNome()); // Atualiza o nome
                return funcionario;
            }
        }
        throw new RuntimeException("Funcionário com ID " + id + " não encontrado.");
    }
    
    // public Funcionario editarFuncionario(Long id, @Valid Funcionario dadosAtualizados) {
    //     try {
    //         Optional<Funcionario> funcionarioExistente = funcionarios.stream().filter(funcionario -> funcionario.getId().equals(id)).findFirst();

    //         if (funcionarioExistente.isPresent()) {
    //             Funcionario funcionario = funcionarioExistente.get();
    //             funcionario.setNome(dadosAtualizados.getNome()); // Atualiza o nome
    //             return funcionario;
    //         } else {
    //             throw new RuntimeException("Funcionário com ID " + id + " não encontrado.");
    //         }
    //     } catch (Exception e) {
    //         throw new RuntimeException("Erro ao editar funcionário: " + e.getMessage());
    //     }
    // }

    
}
