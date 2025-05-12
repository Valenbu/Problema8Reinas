import controlador.ControladorReinas;
import modelo.Tablero;
import vista.VistaTablero;

import java.util.Scanner;

// Clase principal del programa: punto de entrada
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Problema de las 8 reinas - Proyecto MVC");

        // Solicitar fila y columna inicial al usuario
        System.out.print("Ingrese fila inicial (0-7): ");
        int fila = scanner.nextInt();

        System.out.print("Ingrese columna inicial (0-7): ");
        int columna = scanner.nextInt();

        // Validación de límites
        if (fila < 0 || fila > 7 || columna < 0 || columna > 7) {
            System.out.println("Posición inválida. Debe estar entre 0 y 7.");
            return;
        }

        // Crear componentes MVC
        Tablero modelo = new Tablero();
        VistaTablero vista = new VistaTablero(8); // Tamaño del tablero es 8x8
        ControladorReinas controlador = new ControladorReinas(modelo, vista);

        // Ejecutar la lógica con la posición inicial proporcionada por el usuario
        controlador.resolverProblemaDeReinas(fila, columna);
    }
}