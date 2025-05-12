package controlador;

import modelo.Tablero;
import vista.VistaTablero;

// Controlador que maneja la lógica entre modelo y vista
public class ControladorReinas {
    private Tablero modelo;
    private VistaTablero vista;

    public ControladorReinas(Tablero modelo, VistaTablero vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void mejecutar(int fila, int columna) {
        modelo.mcolocarPrimeraReina(fila, columna);
        modelo.mresolverDesde(fila + 1, columna);
        vista.mmostrarTodas(modelo.mobtenerSoluciones());
    }
}