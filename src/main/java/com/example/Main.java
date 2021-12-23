package com.example;

public class Main {
    public static void main(String[] args) {
        Usuarios usuarios = new Usuarios();
        if(usuarios.registrar("mail@mail.com", "UsuarioNumero1"))
            System.out.println("Registrado correctamente");
        else
            System.out.println("Correo electrónico repetido");

        if(usuarios.registrar("mail2@mail.com", "UsuarioNumero2"))
            System.out.println("Registrado correctamente");
        else
            System.out.println("Correo electrónico repetido");

        if(usuarios.registrar("mail3@mail.com", "UsuarioNumero3"))
            System.out.println("Registrado correctamente");
        else
            System.out.println("Correo electrónico repetido");

        if(usuarios.registrar("mail2@mail.com", "UsuarioRepetido"))
            System.out.println("Registrado correctamente");
        else
            System.out.println("Correo electrónico repetido");

        System.out.println(usuarios.acceso("mail@mail.com", "UsuarioNumero1"));
        System.out.println(usuarios.acceso("mail2@mail.com", "ContrasenaIncorrecta"));
        System.out.println(usuarios.acceso("mail3@mail.com", "UsuarioNumero3"));
        System.out.println(usuarios.acceso("mailErroneo@mail.com", "EsteDevuelveMenosUno"));
    }
}
