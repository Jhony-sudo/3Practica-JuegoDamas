package src.principal;

import src.tablero.*;
import src.jugador.Jugador;

import java.util.Scanner;

import src.controlador.*;

public class Main {

    public static void main(String[] args) {
        Main inicio = new Main();

    }

    Tablero t = new Tablero(8, 8, true);
    Jugador[] Jugadores = new Jugador[10];
    Scanner leer = new Scanner(System.in);

    public Main() {
        Jugadores[0] = new Jugador("Jhony");
        Jugadores[1] = new Jugador("Carlos");
        Jugadores[2] = new Jugador("Romy");
        Jugadores[3] = new Jugador("Oliver");
        Jugadores[4] = new Jugador("Maria");
        Jugadores[5] = new Jugador("Josue");
        Jugadores[6] = new Jugador("Eduardo");
        Jugadores[7] = new Jugador("Diego");
        Jugadores[8] = new Jugador("Karla");
        Jugadores[9] = new Jugador("Oscar");
        int Seleccion;
        /*
         * int Jugador1; int Jugador2;
         */

        do {

            System.out.println("JUEGO DAMAS XDXD");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Estadisticas");
            System.out.println("3. Salir");
            Seleccion = leer.nextInt();

            switch (Seleccion) {
                case 1:
                    MostrarJugadores();
                    int Jugador1 = leer.nextInt();
                    int Jugador2 = leer.nextInt();
                    PiedraPapel Jugar = new PiedraPapel(Jugadores[Jugador1 - 1], Jugadores[Jugador2 - 1]);
                    Controlador Jugando = new Controlador(Jugadores[Jugador1 - 1], Jugadores[Jugador2 - 1], t);
                    break;
                case 2:
                    Ordenar();
                    MostrarEstadistica();
                    break;
                case 3:
                    System.out.println("Adios Amigo");
                    break;

            }

        } while (Seleccion != 3);

    }

    public void MostrarJugadores() {
        for (int i = 0; i < Jugadores.length; i++) {
            System.out.println((i + 1) + "  " + Jugadores[i].MostrarInformacion());

        }
    }

    public void MostrarEstadistica() {
        for (int i = 0; i < Jugadores.length; i++) {
            Jugadores[i].Estadisticas();

        }
    }

    public void Ordenar() {
        Jugador selec;
        int pos = 0;
        for (int i = 0; i < Jugadores.length; i++) {
            selec = Jugadores[i];
            pos = i;

            for (int j = i + 1; j < Jugadores.length; j++) {
                if (selec.getPartidasGanadas() < Jugadores[j].getPartidasGanadas()) {
                    selec = Jugadores[j];
                    pos = j;
                }

            }

            Jugadores[pos] = Jugadores[i];
            Jugadores[i] = selec;
        }

    }

}
