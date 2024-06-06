package org.example.controlador;

import org.example.modelo.Informe;
import org.example.repositorio.InformeAccesoBaseDatos;

public class InformeControlador {
    private InformeAccesoBaseDatos informeAccesoBaseDatos;

    public InformeControlador(InformeAccesoBaseDatos informeAccesoBaseDatos) {
        this.informeAccesoBaseDatos = informeAccesoBaseDatos;
    }

    public void generarInforme(String nombre, String tipo) {
        informeAccesoBaseDatos.guardar(new Informe(nombre, tipo));
    }

    public Informe obtenerInforme(Long id) {
        return informeAccesoBaseDatos.obtener(id);
    }

    public void actualizarInforme(Informe informe) {
        informeAccesoBaseDatos.actualizar(informe);
    }

    public void eliminarInforme(Long id) {
        Informe informe = informeAccesoBaseDatos.obtener(id);
        if (informe != null) {
            informeAccesoBaseDatos.eliminar(informe);
        } else {
            System.out.println("El informe con ID " + id + " no existe.");
        }
    }
}
