package org.example.modelo;

public class Proveedor {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    public Proveedor() {
    }

    public Proveedor(Long id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Proveedor(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
}
