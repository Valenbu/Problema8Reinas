package vista;

import modelo.Reina;
import java.util.List;

// Vista: muestra el tablero en consola con las soluciones
public class VistaTablero {

    private int tamanoTablero;

    // Constructor: establece el tamaño del tablero (por defecto 8)
    public VistaTablero(int tamanoTablero) {
        this.tamanoTablero = tamanoTablero;
    }

    // Muestra una solución específica
    public void mostrarSolucion(List<Reina> reinas, int index) {
        System.out.println("Solución #" + (index + 1));
        
        // Crear una matriz de 8x8 vacía
        char[][] tablero = new char[tamanoTablero][tamanoTablero];

        // Inicializar el tablero con puntos
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                tablero[i][j] = '.';  // Casilla vacía
            }
        }

        // Colocar las reinas en el tablero
        for (Reina reina : reinas) {
            int fila = reina.mobtenerFila();
            int columna = reina.mobtenerColumna();
            tablero[fila][columna] = '♛';  // Representar la reina con '♛'
        }

        // Imprimir el tablero
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                System.out.print(" " + tablero[i][j] + " ");  // Mostrar cada casilla
            }
            System.out.println();  // Salto de línea después de cada fila
        }
        System.out.println();  // Salto de línea entre soluciones
    }

    // Muestra todas las soluciones encontradas
    public void mmostrarTodas(List<List<Reina>> soluciones) {
        System.out.println("Total de soluciones encontradas: " + soluciones.size());
        for (int i = 0; i < soluciones.size(); i++) {
            mostrarSolucion(soluciones.get(i), i);
        }
    }
}