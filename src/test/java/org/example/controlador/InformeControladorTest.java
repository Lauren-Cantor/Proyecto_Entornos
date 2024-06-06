package org.example.controlador;

import org.example.modelo.Informe;
import org.example.repositorio.InformeAccesoBaseDatos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InformeControladorTest {

    @Mock
    private InformeAccesoBaseDatos informeAccesoBaseDatosMock;

    @Test
    public void testGenerarInforme() {
        InformeControlador informeControlador = new InformeControlador(informeAccesoBaseDatosMock);
        informeControlador.generarInforme("Informe1", "Tipo1");
        verify(informeAccesoBaseDatosMock).guardar(any(Informe.class));
    }

    @Test
    public void testObtenerInforme() {
        InformeControlador informeControlador = new InformeControlador(informeAccesoBaseDatosMock);
        Long id = 1L;
        informeControlador.obtenerInforme(id);
        verify(informeAccesoBaseDatosMock).obtener(id);
    }

    @Test
    public void testActualizarInforme() {
        InformeControlador informeControlador = new InformeControlador(informeAccesoBaseDatosMock);
        Informe informe = new Informe("Informe1", "Tipo1");
        informeControlador.actualizarInforme(informe);
        verify(informeAccesoBaseDatosMock).actualizar(informe);
    }

    @Test
    public void testEliminarInformeExistente() {
        InformeControlador informeControlador = new InformeControlador(informeAccesoBaseDatosMock);
        Long id = 1L;
        when(informeAccesoBaseDatosMock.obtener(id)).thenReturn(new Informe("Informe1", "Tipo1"));
        informeControlador.eliminarInforme(id);
        verify(informeAccesoBaseDatosMock).eliminar(any(Informe.class));
    }

    @Test
    public void testEliminarInformeNoExistente() {
        InformeControlador informeControlador = new InformeControlador(informeAccesoBaseDatosMock);
        Long id = 1L;
        when(informeAccesoBaseDatosMock.obtener(id)).thenReturn(null);
        informeControlador.eliminarInforme(id);
        verify(informeAccesoBaseDatosMock, never()).eliminar(any(Informe.class));
    }
}