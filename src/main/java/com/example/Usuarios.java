package com.example;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.ArrayList;

public class Usuarios {
    ArrayList<Usuario> usuarios = new ArrayList();

    public Usuarios() {}

    public boolean registrar(String correoElectronico, String contrasena) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(4, 1024 * 1024, 8, contrasena);
        if(!correoElectronicoExiste(correoElectronico)) {
            usuarios.add(new Usuario(correoElectronico, hash));
            return true;
        }

        return false;
    }

    public int acceso(String correoElectronico, String contrasena) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(!correoElectronicoExiste(correoElectronico))
            return -1;

        for (int i=0; i<usuarios.size(); i++) {
            if(usuarios.get(i).getCorreoElectronico().equalsIgnoreCase(correoElectronico)) {
                if(argon2.verify(usuarios.get(i).getContrasena(), contrasena))
                    return 1;
            }
        }

        return -2;
    }

    public boolean correoElectronicoExiste(String correoElectronico) {
        for(int i=0; i<usuarios.size(); i++) {
            if(usuarios.get(i).getCorreoElectronico().equalsIgnoreCase(correoElectronico))
                return true;
        }

        return false;
    }

}
