package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private int tamano = 8;  // Tamaño del tablero (8x8)
    private List<List<Reina>> soluciones;  // Lista de soluciones encontradas

    public Tablero() {
        soluciones = new ArrayList<>();
    }

    // Comienza a buscar soluciones desde una fila y columna específicas
    public void mresolverDesde(int filaInicial, int columnaInicial) {
        soluciones.clear();  // Limpiamos soluciones anteriores
        List<Reina> reinas = new ArrayList<>();
        reinas.add(new Reina(filaInicial, columnaInicial));  // Colocamos la primera reina fija

        // Crear lista de filas restantes (0 a 7, sin filaInicial)
        List<Integer> filasParaColocar = new ArrayList<>();
        for (int i = 0; i < tamano; i++) {
            if (i != filaInicial) {
                filasParaColocar.add(i);
            }
        }

        // Iniciar backtracking con índice 0 en las filas restantes
        mbacktrackFilas(filasParaColocar, 0, reinas);
    }

    // Backtracking que coloca reinas en la lista de filas dada por filasParaColocar
    private void mbacktrackFilas(List<Integer> filasParaColocar, int indiceFila, List<Reina> reinasActuales) {
        // Si hemos colocado 8 reinas, guardamos la solución
        if (reinasActuales.size() == tamano) {
            soluciones.add(new ArrayList<>(reinasActuales));
            return;
        }

        // Si ya cubrimos todas las filas restantes, terminamos
        if (indiceFila >= filasParaColocar.size()) {
            return;
        }

        int fila = filasParaColocar.get(indiceFila);

        for (int col = 0; col < tamano; col++) {
            if (mesSeguro(fila, col, reinasActuales)) {
                reinasActuales.add(new Reina(fila, col));
                mbacktrackFilas(filasParaColocar, indiceFila + 1, reinasActuales);
                reinasActuales.remove(reinasActuales.size() - 1);
            }
        }
    }

    // Verifica si es seguro colocar una reina en fila,col dada las reinas ya colocadas
    private boolean mesSeguro(int fila, int col, List<Reina> reinas) {
        for (Reina r : reinas) {
            int rf = r.mobtenerFila();
            int rc = r.mobtenerColumna();
            if (rc == col || Math.abs(rf - fila) == Math.abs(rc - col)) {
                return false;  // Conflicto en columna o diagonal
            }
        }
        return true;
    }

    // Devuelve todas las soluciones encontradas
    public List<List<Reina>> mobtenerSoluciones() {
        return soluciones;
    }

    public int mobtenerTamano() {
        return tamano;
    }
}
