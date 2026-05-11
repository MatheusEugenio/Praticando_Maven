package org.example.service;

import br.com.caelum.stella.validation.CPFValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.example.entitys.Usuario;
import org.example.exceptions.InvalidCpfExcpetion;
import org.example.exceptions.InvalidEmailException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CadastroService {

    private final Set<Usuario> usuarios;
    private final EmailValidator emailValidator = EmailValidator.getInstance();
    private final CPFValidator cpfValidator;

    public CadastroService() {
        this.usuarios = new HashSet<>();
        this.cpfValidator = new CPFValidator();
    }

    public Usuario cadastrar(Usuario user) {

        if (!emailValidator.isValid(user.email())){
            throw new InvalidEmailException("Erro: email do usuário \""+user.name()+"\" é inválido!");
        }

        if (user.password() == null){
            return null;
        }

        boolean valido = cpfValidator.isEligible(user.cpf());

        if (!valido){
            throw new InvalidCpfExcpetion("Erro: CPF do usuário \""+user.email()+"\" é invalido!");
        }

        if (!this.usuarios.add(user)){
            System.out.println("Usuário "+user.name() + " já cadastrado!");
        }
        return user;
    }

    public Set<Usuario> listar(){

        if (usuarios.isEmpty()){
            return null;
        }

        return usuarios;
    }

    public boolean removerUsuario(Usuario user){

        if (!usuarios.remove(user)) {
            return false;
        }

        return true;
    }

    public Optional<Set<Usuario>> removerTodos() {

        if (usuarios.isEmpty()){
            return Optional.empty();
        }

        usuarios.clear();
        return Optional.of(usuarios);
    }



}
