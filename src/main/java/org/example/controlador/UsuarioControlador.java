package org.example.controlador;

import org.example.modelo.Usuario;
import org.example.repositorio.UsuarioAccesoBaseDatos;

public class UsuarioControlador {
    private UsuarioAccesoBaseDatos usuarioAccesoBaseDatos;

    public UsuarioControlador(UsuarioAccesoBaseDatos usuarioAccesoBaseDatos) {
        this.usuarioAccesoBaseDatos = usuarioAccesoBaseDatos;
    }

    public Usuario crearUsuario(Usuario usuario){
        Usuario usuario1 = new Usuario(
                "Lauren",
                "Cantor",
                "lauren@gmail.com",
                "empleado");
        return usuarioAccesoBaseDatos.guardar(usuario1);
    }
}
