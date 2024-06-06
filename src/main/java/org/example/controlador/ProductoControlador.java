package org.example.controlador;

import org.example.modelo.Producto;
import org.example.modelo.Proveedor;
import org.example.repositorio.ProductoAccesoBaseDatos;

import java.util.Date;

public class ProductoControlador {
    private ProductoAccesoBaseDatos productoAccesoBaseDatos;

    public ProductoControlador(ProductoAccesoBaseDatos productoAccesoBaseDatos) {
        this.productoAccesoBaseDatos = productoAccesoBaseDatos;
    }

    public void agregarProducto(String nombre, String categoria, Date fechaVencimiento, String numeroLote, String numeroSerie, Proveedor proveedor) {
        productoAccesoBaseDatos.guardar(new Producto(nombre, categoria, fechaVencimiento, numeroLote, numeroSerie, proveedor));
    }

    public Producto obtenerProducto(Long id) {
        return productoAccesoBaseDatos.obtener(id);
    }

    public void actualizarProducto(Producto producto) {
        productoAccesoBaseDatos.actualizar(producto);
    }

    public void eliminarProducto(Long id) {
        Producto producto = productoAccesoBaseDatos.obtener(id);
        if (producto != null) {
            productoAccesoBaseDatos.eliminar(producto);
        } else {
            System.out.println("El producto con ID " + id + " no existe.");
        }
    }
}
