package org.iesalandalus.programacion.juegodados.modelo;

import java.util.Arrays;
import java.util.Objects;

public record Jugador(int[] puntuaciones, String nombre) {
    private static final int NUM_TIRADAS = 5;

    public Jugador(String nombre) {
        this(new int[NUM_TIRADAS], nombre);
        validarNombre(nombre);
    }

    public String getNombre() {
        return this.nombre;
    }

    private void validarNombre(String nombre) {
        Objects.requireNonNull(nombre, "El nombre del jugador no puede ser nulo.");
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del jugador no puede estar vacio.");
        }
    }

    public void jugar() {
        for (int i = 0; i < NUM_TIRADAS; i++) {
            puntuaciones[i] = Dado.lanzar();
        }
    }

    public int getPuntuacionTotal() {
        int contadorPuntuacionTotal = 0;
        for (int i = 0; i < NUM_TIRADAS; i++) {
            contadorPuntuacionTotal += puntuaciones[i];
        }
        return contadorPuntuacionTotal;
    }

    @Override
    public String toString() {
        return "\n"+ nombre + " ha conseguido las siguientes puntuaciones = " + Arrays.toString(puntuaciones) + " que suman una puntuacion total de " + getPuntuacionTotal();
    }
}
