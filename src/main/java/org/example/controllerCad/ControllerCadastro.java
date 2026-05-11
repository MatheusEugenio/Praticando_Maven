package org.example.controllerCad;

import org.example.entitys.Usuario;
import org.example.service.CadastroService;

import java.util.Optional;
import java.util.Set;

public class ControllerCadastro {

    private final CadastroService cadastroService;

    public ControllerCadastro(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    public void cadastrarUsuario(Usuario usuario){
        System.out.println("CADASTRO:\n");

        if (usuario == null){
            System.out.println("Não é possível efeutar a operação, pois o usuário é nulo!");
            return;
        }

        if (cadastroService.cadastrar(usuario) == null) {
            System.out.println("Erro ao cadastrar! Algum campo do usuário é inválido");
            return;
        }

        System.out.println("Cadastrado realizado com sucesso!");
        System.out.println("=========================");
    }

    public void excluirUsuario(Usuario usuario){
        System.out.println("EXCLUSÃO:\n");

        if (usuario == null){
            System.out.println("Impossível excluir usuário nulo!");
            return;
        }

        if (!cadastroService.removerUsuario(usuario)){
            System.out.println("Usuário não encontrado para relizar exclusão!");
            return;
        }

        System.out.println("Usuário excluído com sucesso!");
        System.out.println("=========================");
    }

    public void removerTodos() {
        System.out.println("EXCLUSÃO:\n");

        if (cadastroService.removerTodos().isEmpty()){
            System.out.println("A lista já está vazia!");
            return;
        }

        System.out.println("Usuários excluídos com sucesso!");
        System.out.println("=========================");
    }

    public void listarUsuarios(){
        System.out.println("LISTAGEM DE USUÁRIOS:\n");

        Set<Usuario> listaDeUsers =  cadastroService.listar();

        if (listaDeUsers == null){
            System.out.println("Lista vazia.");
            System.out.println("=============================");
            return;
        }

        listaDeUsers.forEach(System.out::println);

        System.out.println("=============================");
    }


}
