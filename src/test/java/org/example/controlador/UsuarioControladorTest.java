package org.example.controlador;

import org.example.modelo.Usuario;
import org.example.repositorio.UsuarioAccesoBaseDatos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UsuarioControladorTest {

    @Mock
    UsuarioAccesoBaseDatos usuarioAccesoBaseDatos;

    @Test
    void crearUsuario() {
        Usuario usuarioEntrada = new Usuario(
                "Lauren",
                "Cantor",
                "lauren@gmail.com",
                "empleado");

        Usuario usuarioEsperado = new Usuario(
                "Lauren",
                "Cantor",
                "lauren@gmail.com",
                "empleado");

        Usuario usuarioRespuesta = null;
        Mockito.when(usuarioAccesoBaseDatos.guardar(any(Usuario.class)))
                .thenReturn(new Usuario(
                "Lauren",
                "Cantor",
                "lauren@gmail.com",
                "Administrador"));
        UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioAccesoBaseDatos);

        usuarioRespuesta = usuarioControlador.crearUsuario(usuarioEntrada);

        Assertions.assertEquals(usuarioEsperado, usuarioRespuesta, "El usuario creado no coincide con el usuario esperado");
    }
}