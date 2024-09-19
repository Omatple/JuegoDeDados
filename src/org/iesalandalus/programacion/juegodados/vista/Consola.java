package org.iesalandalus.programacion.juegodados.vista;

import org.iesalandalus.programacion.juegodados.modelo.JuegoDados;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Arrays;

public class Consola {
    private Consola() {
    }

    public static int leerNumeroJugadores() {
        int numeroJugadores;
        System.out.print("Escriba el numero de jugadores que van a participar en el juego: ");
        numeroJugadores = Entrada.entero();
        return numeroJugadores;
    }

    public static String leerNombreJugador(int numeroJugador) {
        String nombreJugador;
        do {
            System.out.print("Escriba el nombre del " + numeroJugador + "º jugador: ");
            nombreJugador = Entrada.cadena();
        } while (nombreJugador.isEmpty());
        return nombreJugador;
    }

    public static void mostrarResultados(JuegoDados juegoDados) {
        System.out.println("Los jugadores del 'Juego De Dados' son:\n" + juegoDados.toString() + "\nLa puntuacion ganadora(la mas alta) es: " + juegoDados.getPuntuacionGanadora() + "\nEl o los ganadores de este juego con la puntuacion maxima han sido: " + Arrays.toString(juegoDados.getGanadores()));
    }
}
