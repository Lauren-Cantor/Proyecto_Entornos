package org.example.controlador;

import org.example.modelo.Inventario;
import org.example.repositorio.InventarioAccesoBaseDatos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventarioControladorTest {

    @Mock
    private InventarioAccesoBaseDatos InventarioAccesoBaseDatos;

    @Test
    public void actualizarInventario_DeberiaActualizarCorrectamente() {
        Inventario inventarioSimulado = new Inventario(1, "Paracetamol", new Date(), new Date(), "Laboratorio XYZ");

        when(InventarioAccesoBaseDatos.actualizar()).thenReturn(inventarioSimulado);

        InventarioControlador inventarioControlador = new InventarioControlador(InventarioAccesoBaseDatos);

        Inventario inventarioActualizado = inventarioControlador.actualizarInventario();

        assertEquals(inventarioSimulado, inventarioActualizado, "El inventario actualizado no coincide con el inventario simulado");
    }

}