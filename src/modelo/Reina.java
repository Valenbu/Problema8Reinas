package modelo;

// Clase que representa la posición de una reina
public class Reina {
    private int fila;
    private int columna;

    public Reina(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int mobtenerFila() {
        return fila;
    }

    public int mobtenerColumna() {
        return columna;
    }
}
