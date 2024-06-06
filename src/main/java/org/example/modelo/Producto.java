package org.example.modelo;

import java.util.Date;

public class Producto {
    private Long id;
    private String nombre;
    private String categoria;
    private Date fechaVencimiento;
    private String numeroLote;
    private String numeroSerie;
    private Proveedor proveedor;

    public Producto(Long id, String nombre, String categoria, Date fechaVencimiento, String numeroLote, String numeroSerie, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.numeroLote = numeroLote;
        this.numeroSerie = numeroSerie;
        this.proveedor = proveedor;
    }

    public Producto(String nombre, String categoria, Date fechaVencimiento, String numeroLote, String numeroSerie, Proveedor proveedor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.numeroLote = numeroLote;
        this.numeroSerie = numeroSerie;
        this.proveedor = proveedor;
    }
}
