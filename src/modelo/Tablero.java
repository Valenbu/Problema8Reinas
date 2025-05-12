package modelo;

import java.util.ArrayList;
import java.util.List;

// Clase que representa el tablero de ajedrez y maneja las soluciones del problema de las 8 reinas
public class Tablero {
    private int tamano = 8;  // Tablero de 8x8
    private int[][] tablero;
    private List<List<Reina>> soluciones;

    public Tablero() {
        tablero = new int[tamano][tamano];
        soluciones = new ArrayList<>();
    }

    // Coloca la reina inicial en el tablero
    public void mcolocarPrimeraReina(int fila, int columna) {
        tablero[fila][columna] = 1;
    }

    // Comienza a buscar soluciones desde una fila específica
    public void mresolverDesde(int filaInicial, int columnaInicial) {
        List<Reina> reinas = new ArrayList<>();
        reinas.add(new Reina(filaInicial, columnaInicial)); // Agregamos la reina inicial
        mbacktrack(filaInicial + 1, reinas); // Iniciar desde la siguiente fila
    }

    // Algoritmo de backtracking para colocar reinas
    private void mbacktrack(int fila, List<Reina> reinasActuales) {
        if (reinasActuales.size() == tamano) {
            soluciones.add(new ArrayList<>(reinasActuales));  // Si encontramos una solución, la guardamos
            return;
        }

        for (int col = 0; col < tamano; col++) {
            if (mesSeguro(fila, col, reinasActuales)) {
                reinasActuales.add(new Reina(fila, col));  // Coloca una reina en la fila actual y columna
                mbacktrack(fila + 1, reinasActuales);  // Llama recursivamente a la siguiente fila
                reinasActuales.remove(reinasActuales.size() - 1);  // Deshace la acción
            }
        }
    }

    // Verifica si es seguro colocar una reina en la fila y columna dados
    private boolean mesSeguro(int fila, int col, List<Reina> reinas) {
        for (Reina r : reinas) {
            int rf = r.mobtenerFila();
            int rc = r.mobtenerColumna();
            if (rc == col || rf == fila || Math.abs(rf - fila) == Math.abs(rc - col)) {
                return false;  // Si hay otra reina en la misma columna o diagonal, no es seguro
            }
        }
        return true;
    }

    // Devuelve la lista de soluciones encontradas
    public List<List<Reina>> mobtenerSoluciones() {
        return soluciones;
    }

    // Devuelve el tamaño del tablero
    public int mobtenerTamano() {
        return tamano;
    }
}