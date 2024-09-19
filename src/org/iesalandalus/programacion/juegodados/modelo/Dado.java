package org.iesalandalus.programacion.juegodados.modelo;

import java.util.Random;

public class Dado {
    private static final int NUM_CARAS = 6;
    private static final Random GENERADOR = new Random();

    private Dado() {
    }

    public static int lanzar() {
        int resultadoLanzamiento;
        resultadoLanzamiento = GENERADOR.nextInt(NUM_CARAS) + 1;
        return resultadoLanzamiento;
    }
}
