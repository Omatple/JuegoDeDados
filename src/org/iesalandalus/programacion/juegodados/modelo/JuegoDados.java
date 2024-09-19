package org.iesalandalus.programacion.juegodados.modelo;

import java.util.Arrays;
import java.util.Objects;

public record JuegoDados(Jugador[] jugadores) {
    private static final int MIN_JUGADORES = 2;
    private static final int MAX_JUGADORES = 10;

    public JuegoDados(int numeroJugadores) {
        this(new Jugador[numeroJugadores]);
        comprobarNumeroJugadores(numeroJugadores);
    }

    private void comprobarNumeroJugadores(int numeroJugadores) {
        if (numeroJugadores < MIN_JUGADORES || numeroJugadores > MAX_JUGADORES) {
            throw new IllegalArgumentException("El numero de jugadores no es valido. Recuerda los limites(" + MIN_JUGADORES + " - " + MAX_JUGADORES + ").");
        }
    }

    private void comprobarNumeroJugador(int numeroJugador) {
        if (numeroJugador < 0 || numeroJugador > jugadores.length) {
            throw new IllegalArgumentException("El numero del jugador no es valido.");
        }
    }

    private void comprobarJugadores() {
        for (int i = 0; i < jugadores.length; i++) {
            Objects.requireNonNull(jugadores[i], "Ningun jugador puede ser nulo, no es un valor valido");
        }
    }

    public void setJugador(int numeroJugador, String nombre) {
        comprobarNumeroJugador(numeroJugador);
        jugadores[numeroJugador] = new Jugador(nombre);
    }

    public void jugar() {
        comprobarJugadores();
        for (int i = 0; i < jugadores.length; i++) {
            comprobarNumeroJugador(i);
            jugadores[i].jugar();
        }
    }

    public int getPuntuacionGanadora() {
        comprobarJugadores();
        int puntuacionGanadora = 0;
        for (int i = 0; i < jugadores.length; i++) {
            comprobarNumeroJugador(i);
            if (jugadores[i].getPuntuacionTotal() >= puntuacionGanadora) {
                puntuacionGanadora = jugadores[i].getPuntuacionTotal();
            }
        }
        return puntuacionGanadora;
    }

    public Jugador[] getGanadores() {
        comprobarJugadores();
        Jugador ganador[] = new Jugador[jugadores.length];
        int contadorGanadores = 1;
        for (int i = 0; i < jugadores.length; i++) {
            comprobarNumeroJugador(i);
            if (getPuntuacionGanadora() == jugadores[i].getPuntuacionTotal()) {
                ganador[contadorGanadores - 1] = jugadores[i];
                contadorGanadores++;
            }
        }
        return Arrays.copyOf(ganador, contadorGanadores - 1);
        // Arrays.copy0f --> Mirado en internet, preguntar a profesor si puedo hacer de su uso.
    }

    @Override
    public String toString() {
        return Arrays.toString(jugadores);
    }
}
