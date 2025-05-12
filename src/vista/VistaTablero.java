package vista;

import modelo.Reina;
import java.util.List;

// Vista: muestra el tablero en consola con las soluciones
public class VistaTablero {

    // Muestra una solución específica
    public void mostrarSolucion(List<Reina> reinas, int index) {
        System.out.println("Solución #" + (index + 1));
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                boolean hayReina = false;
                for (Reina r : reinas) {
                    if (r.mobtenerFila() == fila && r.mobtenerColumna() == col) {
                        hayReina = true;
                        break;
                    }
                }
                System.out.print(hayReina ? " ♛ " : " . ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Muestra todas las soluciones encontradas
    public void mmostrarTodas(List<List<Reina>> soluciones) {
        System.out.println("Total de soluciones encontradas: " + soluciones.size());
        for (int i = 0; i < soluciones.size(); i++) {
            mostrarSolucion(soluciones.get(i), i);
        }
    }
}