package org.example.modelo;

import java.util.Date;

public class Informe {
    private Long id;
    private String nombre;
    private Date fechaCreacion;
    private String tipo;

    public Informe(Long id, String nombre, Date fechaCreacion, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.tipo = tipo;
    }

    public Informe(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
}
