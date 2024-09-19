package org.iesalandalus.programacion.juegodados;

import org.iesalandalus.programacion.juegodados.modelo.JuegoDados;
import org.iesalandalus.programacion.juegodados.vista.Consola;

public class Main {
    public static void main(String[] args) {
        int numeroJugadores;
        JuegoDados juegoDados;
        System.out.println("Juego de dados.");
        System.out.println("---------------");
        System.out.println("");
        while (true) {
            try {
                numeroJugadores = Consola.leerNumeroJugadores();
                juegoDados = crearJuego(numeroJugadores);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("El numero de jugadores no es valido. Intentelo de nuevo: ");
            }
        }
        crearJugadores(numeroJugadores, juegoDados);
        System.out.println("---------------------------------");
        juegoDados.jugar();
        Consola.mostrarResultados(juegoDados);
        System.out.println("---------------------------------");
    }

    private static JuegoDados crearJuego(int numeroJugadores) {
        return new JuegoDados(numeroJugadores);
    }

    private static void crearJugadores(int numeroJugadores, JuegoDados juegoDados) {
        String nombreJugador;
        for (int i = 0; i < numeroJugadores; i++) {
            nombreJugador = Consola.leerNombreJugador((i + 1));
            juegoDados.setJugador(i, nombreJugador);
        }
    }
}