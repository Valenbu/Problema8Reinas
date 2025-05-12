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
    public void ejecutar(int fila, int columna) {
        modelo.mresolverDesde(fila, columna); // Resolver el problema con la reina en la posición dada
        vista.mmostrarTodas(modelo.mobtenerSoluciones()); // Mostrar todas las soluciones encontradas
    }
}
