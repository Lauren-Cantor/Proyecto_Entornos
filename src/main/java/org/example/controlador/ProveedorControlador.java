package org.example.controlador;

import org.example.modelo.Proveedor;
import org.example.repositorio.ProveedorAccesoBaseDatos;

public class ProveedorControlador {
    private ProveedorAccesoBaseDatos proveedorAccesoBaseDatos;

    public ProveedorControlador(ProveedorAccesoBaseDatos proveedorAccesoBaseDatos) {
        this.proveedorAccesoBaseDatos = proveedorAccesoBaseDatos;
    }

    public void agregarProveedor(String nombre, String direccion, String telefono, String email) {
        proveedorAccesoBaseDatos.guardar(new Proveedor(nombre, direccion, telefono, email)); // Suponiendo que el constructor de Proveedor toma nombre, direccion, telefono y email como parámetros
    }

    public Proveedor obtenerProveedor(Long id) {
        return proveedorAccesoBaseDatos.obtener(id);
    }

    public void actualizarProveedor(Proveedor proveedor) {
        proveedorAccesoBaseDatos.actualizar(proveedor);
    }

    public void eliminarProveedor(Long id) {
        Proveedor proveedor = proveedorAccesoBaseDatos.obtener(id);
        if (proveedor != null) {
            proveedorAccesoBaseDatos.eliminar(proveedor);
        } else {
            System.out.println("El proveedor con ID " + id + " no existe.");
        }
    }
}
