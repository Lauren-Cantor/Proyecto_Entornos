package org.example.controlador;

import org.example.modelo.Proveedor;
import org.example.repositorio.ProveedorAccesoBaseDatos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProveedorControladorTest {

    @Mock
    private ProveedorAccesoBaseDatos proveedorAccesoBaseDatosMock;

    @Test
    public void testAgregarProveedor() {
        ProveedorControlador proveedorControlador = new ProveedorControlador(proveedorAccesoBaseDatosMock);
        proveedorControlador.agregarProveedor("Proveedor1", "Direccion1", "123456789", "proveedor1@example.com");

        verify(proveedorAccesoBaseDatosMock).guardar(any(Proveedor.class));
    }

    @Test
    public void testObtenerProveedor() {
        Proveedor proveedor = new Proveedor("Proveedor1", "Direccion1", "123456789", "proveedor1@example.com");
        when(proveedorAccesoBaseDatosMock.obtener(1L)).thenReturn(proveedor);

        ProveedorControlador proveedorControlador = new ProveedorControlador(proveedorAccesoBaseDatosMock);
        Proveedor resultado = proveedorControlador.obtenerProveedor(1L);

        assertNotNull(resultado);
        assertEquals(proveedor, resultado);
    }

    @Test
    public void testActualizarProveedor() {
        Proveedor proveedor = new Proveedor("Proveedor1", "Direccion1", "123456789", "proveedor1@example.com");

        ProveedorControlador proveedorControlador = new ProveedorControlador(proveedorAccesoBaseDatosMock);
        proveedorControlador.actualizarProveedor(proveedor);

        verify(proveedorAccesoBaseDatosMock).guardar(proveedor);
    }

    @Test
    public void testEliminarProveedorExistente() {
        Proveedor proveedor = new Proveedor("Proveedor1", "Direccion1", "123456789", "proveedor1@example.com");
        when(proveedorAccesoBaseDatosMock.obtener(1L)).thenReturn(proveedor);

        ProveedorControlador proveedorControlador = new ProveedorControlador(proveedorAccesoBaseDatosMock);
        proveedorControlador.eliminarProveedor(1L);

        verify(proveedorAccesoBaseDatosMock).eliminar(proveedor);
    }

    @Test
    public void testEliminarProveedorNoExistente() {
        when(proveedorAccesoBaseDatosMock.obtener(1L)).thenReturn(null);

        ProveedorControlador proveedorControlador = new ProveedorControlador(proveedorAccesoBaseDatosMock);
        proveedorControlador.eliminarProveedor(1L);

        verify(proveedorAccesoBaseDatosMock, never()).eliminar(any(Proveedor.class));
    }
}
