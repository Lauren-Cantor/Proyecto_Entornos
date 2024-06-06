package org.example.controlador;

import org.example.modelo.Producto;
import org.example.modelo.Proveedor;
import org.example.repositorio.ProductoAccesoBaseDatos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductoControladorTest {
    @Mock
    private ProductoAccesoBaseDatos productoAccesoBaseDatosMock;

    @Test
    public void testAgregarProducto() {
        ProductoControlador productoControlador = new ProductoControlador(productoAccesoBaseDatosMock);
        productoControlador.agregarProducto("NombreProducto", "Categoria", new Date(), "123", "456", new Proveedor());

        verify(productoAccesoBaseDatosMock).guardar(any(Producto.class));
    }

    @Test
    public void testObtenerProducto() {
        Producto producto = new Producto("NombreProducto", "Categoria", new Date(), "123", "456", new Proveedor());
        when(productoAccesoBaseDatosMock.obtener(1L)).thenReturn(producto);

        ProductoControlador productoControlador = new ProductoControlador(productoAccesoBaseDatosMock);
        Producto resultado = productoControlador.obtenerProducto(1L);

        assertEquals(producto, resultado);
    }

    @Test
    public void testActualizarProducto() {
        Producto producto = new Producto("NombreProducto", "Categoria", new Date(), "123", "456", new Proveedor());

        ProductoControlador productoControlador = new ProductoControlador(productoAccesoBaseDatosMock);
        productoControlador.actualizarProducto(producto);

        verify(productoAccesoBaseDatosMock).actualizar(producto);
    }

    @Test
    public void testEliminarProductoExistente() {
        Producto producto = new Producto("NombreProducto", "Categoria", new Date(), "123", "456", new Proveedor());
        when(productoAccesoBaseDatosMock.obtener(1L)).thenReturn(producto);

        ProductoControlador productoControlador = new ProductoControlador(productoAccesoBaseDatosMock);
        productoControlador.eliminarProducto(1L);

        verify(productoAccesoBaseDatosMock).eliminar(producto);
    }

    @Test
    public void testEliminarProductoNoExistente() {
        when(productoAccesoBaseDatosMock.obtener(1L)).thenReturn(null);

        ProductoControlador productoControlador = new ProductoControlador(productoAccesoBaseDatosMock);
        productoControlador.eliminarProducto(1L);

        verify(productoAccesoBaseDatosMock, never()).eliminar(any(Producto.class));
    }
}
