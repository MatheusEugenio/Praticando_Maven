package org.example;

import org.example.controllerCad.ControllerCadastro;
import org.example.entitys.Usuario;
import org.example.service.CadastroService;

public class Main {
    public static void main(String[] args) {

        CadastroService cadService = new CadastroService();
        ControllerCadastro controllerCad = new ControllerCadastro(cadService);

        Usuario user1 = new Usuario("sebastian", "sebastianSebas12@gmail.com", "sebas123", "12343122101");
        Usuario user2 = new Usuario("pacheco", "pachecox86@gmail.com", "checo12", "12312342343");
        Usuario user3 = new Usuario("rafael", "rafelsoares23@gmail.com", "rafaSoas34", "12423423091");
        Usuario user4 = new Usuario("vitor", "vitor123@gmail.com", "vitorGaules99", "52425234291");

        try {
            controllerCad.cadastrarUsuario(user1);
            controllerCad.cadastrarUsuario(user2);
            controllerCad.cadastrarUsuario(user3);
            controllerCad.cadastrarUsuario(user4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        controllerCad.listarUsuarios();

        controllerCad.excluirUsuario(user2);

        controllerCad.listarUsuarios();

        controllerCad.removerTodos();

        controllerCad.listarUsuarios();
    }
}
