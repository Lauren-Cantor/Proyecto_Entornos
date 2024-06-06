package org.example.controlador;

import org.example.modelo.Inventario;
import org.example.repositorio.InventarioAccesoBaseDatos;

public class InventarioControlador {
    InventarioAccesoBaseDatos inventarioAccesoBaseDatos;

    public InventarioControlador(InventarioAccesoBaseDatos inventarioAccesoBaseDatos) {
        this.inventarioAccesoBaseDatos = inventarioAccesoBaseDatos;
    }

    public Inventario   actualizarInventario(){
        return inventarioAccesoBaseDatos.actualizar();
    }
}
