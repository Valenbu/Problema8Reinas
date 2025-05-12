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

    // Ejecuta el algoritmo de las 8 reinas con la posición inicial especificada
    public void resolverProblemaDeReinas(int fila, int columna) {
        modelo.mcolocarPrimeraReina(fila, columna);
        modelo.mresolverDesde(fila + 1, columna);  // Inicia desde la siguiente fila
        vista.mmostrarTodas(modelo.mobtenerSoluciones());  // Muestra todas las soluciones encontradas
    }
}