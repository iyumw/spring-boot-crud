package com.example.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.trabalho.model.Funcionario;
import com.example.trabalho.model.FuncionarioService;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    /*
     * @RequestMapping("/listarFunc")
     * 
     * @ResponseBody
     * public String listarFuncionario() {
     * String retorno = "";
     * 
     * List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
     * for (Funcionario funcionario : funcionarios) {
     * retorno += " => " + funcionario.toString() + "\n";
     * }
     * return retorno;
     * }
     */

    @RequestMapping("/listarFunc")
    public ModelAndView listarFuncionario() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios(); // Obtém a lista de funcionários

        ModelAndView modelAndView = new ModelAndView("index.html"); // Nome do template HTML
        modelAndView.addObject("funcionarios", funcionarios); // Adiciona a lista ao modelo
        return modelAndView; // Retorna o ModelAndView
    }

    @RequestMapping("pesquisarFunc/{id}")
    @ResponseBody
    public Funcionario pesquisarFuncionario(@PathVariable("id") long id) {
        Funcionario funcionario = funcionarioService.pesquisarFuncionario(id);
        return funcionario;
    }

    

    // @PostMapping("/criarFunc")
    // public String criarFuncionario(@RequestParam("nome") String nome) {
    // try {
    //     Funcionario funcionario = new Funcionario();
    //     funcionario.setNome(nome);
    //     funcionarioService.criarFuncionario(funcionario);
    //     return "redirect:/listarFunc";
    // } catch (Exception e) {
    //     e.printStackTrace(); // Exibe a exceção no console para depuração
    //         return "error";
    // }
    // }   

    @PutMapping("/{id}")
public ResponseEntity<Funcionario> editarFuncionario(@PathVariable long id, @RequestBody Funcionario funcionario) {
  try {
    // Busca o funcionário pelo ID informado na URL
    Funcionario funcionarioExistente = funcionarioService.pesquisarFuncionario(id);

    // Verifica se o funcionário foi encontrado
    if (funcionarioExistente == null) {
      return ResponseEntity.notFound().build(); // Retorna 404 Not Found
    }

    // Atualiza os dados do funcionário existente com os dados do objeto recebido
    funcionarioExistente.setNome(funcionario.getNome()); // Exemplo de atualização de um campo
    // Atualize outros campos conforme sua necessidade

    // Salva o funcionário atualizado no banco de dados
    funcionarioService.editarFuncionario(funcionarioExistente.getId(), funcionarioExistente);

    return ResponseEntity.ok(funcionario); // Retorna 200 OK
  } catch (Exception e) {
    // Trata a exceção caso ocorra algum erro durante a atualização
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retorna 500 Internal Server Error
  }
}

    //  @PutMapping("/{id}")
    // public ResponseEntity<Void> editarFuncionario(@PathVariable long id, @RequestBody Funcionario funcionario) {
    //     try {
    //         funcionario.setId(id);
    //         funcionarioService.editarFuncionario(id, funcionario);
    //         return ResponseEntity.ok().build();
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }

    // @PostMapping("/salvarFunc")
    // public ResponseEntity<Void> salvarFuncionario(@RequestParam Funcionario funcionario) {
    //     funcionarioService.salvarFuncionario(funcionario);
    //     return ResponseEntity.ok().build();
    // }

    // @RequestMapping("/salvarFunc")
    // @ResponseBody
    // public String salvarFuncionario(@RequestParam Map<String, String> parametros)
    // throws ParseException {
    // String retorno = "";

    // long id = Long.parseLong(parametros.get("identificacao"));
    // String nome = parametros.get("nome");
    // boolean ok = funcionarioService.salvarFuncionario(id, new Funcionario(nome,
    // id));
    // retorno += "=> Funcionário salvo: " + ok;

    // return retorno;
    // }

    // @PostMapping
    // public ResponseEntity<Void> criarFuncionario(@RequestParam String nome) {
    // try {
    // Funcionario funcionario = new Funcionario();
    // funcionario.setNome(nome);
    // funcionarioService.criarFuncionario(funcionario);
    // return ResponseEntity.status(HttpStatus.CREATED).build();
    // } catch (Exception e) {
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    // }
    // }

    // @RequestMapping("/excluirFunc")
    @RequestMapping(value = "/excluirFunc", method = RequestMethod.DELETE)
    @ResponseBody
    public String excluirFuncionario(@RequestParam(value = "identificacao") long id) {
        String retorno = "";

        boolean ok = funcionarioService.excluirFuncionario(id);
        retorno += " => Funcionário excluído: " + ok;

        return retorno;
    }

}
