package modelo;

import java.util.ArrayList;
import java.util.List;

// Modelo: representa el tablero y contiene el algoritmo de solución
public class Tablero {
    private int[][] tablero;
    private int tamano = 8;
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
        reinas.add(new Reina(filaInicial - 1, columnaInicial));
        mbacktrack(filaInicial, reinas);
    }

    // Algoritmo de backtracking para colocar reinas
    private void mbacktrack(int fila, List<Reina> reinasActuales) {
        if (reinasActuales.size() == tamano) {
            soluciones.add(new ArrayList<>(reinasActuales));
            return;
        }

        for (int col = 0; col < tamano; col++) {
            if (mesSeguro(fila, col, reinasActuales)) {
                reinasActuales.add(new Reina(fila, col));
                mbacktrack(fila + 1, reinasActuales);
                reinasActuales.remove(reinasActuales.size() - 1);
            }
        }
    }

    // Verifica si es seguro colocar una reina en fila, columna
    private boolean mesSeguro(int fila, int col, List<Reina> reinas) {
        for (Reina r : reinas) {
            int rf = r.mobtenerFila();
            int rc = r.mobtenerColumna();
            if (rc == col || rf == fila || Math.abs(rf - fila) == Math.abs(rc - col)) {
                return false;
            }
        }
        return true;
    }

    // Devuelve la lista de soluciones encontradas
    public List<List<Reina>> mobtenerSoluciones() {
        return soluciones;
    }

    public int mobtenerTamano() {
        return tamano;
    }
}