package org.example.modelo;

import java.util.Date;

public class Inventario {
    private Integer codigo;
    private String Nombre;
    private Date fecha_ingreso;
    private Date fecha_caducidad;
    private String laboratorio;
    private Double precio;

    public Inventario(Integer codigo, String nombre, Date fecha_ingreso, Date fecha_caducidad, String laboratorio) {
        this.codigo = codigo;
        Nombre = nombre;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_caducidad = fecha_caducidad;
        this.laboratorio = laboratorio;
    }
}
