package org.example.modelo;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String Apellido;
    private String Correo;
    private String Rol;

    public Usuario(String nombre, String apellido, String correo,String rol) {
        this.nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(Apellido, usuario.Apellido) && Objects.equals(Correo, usuario.Correo) && Objects.equals(Rol, usuario.Rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, Apellido, Correo, Rol);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Correo='" + Correo + '\'' +
                ", Rol='" + Rol + '\'' +
                '}';
    }
}
