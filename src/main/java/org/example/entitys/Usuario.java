package org.example.entitys;

public record Usuario(String name, String email, String password, String cpf) {

    @Override
    public String toString() {
        return "    - "+name.substring(0,1).toUpperCase()+ name.substring(1).toLowerCase() + " email: "+email+" cpf: "+cpf;
    }
}
