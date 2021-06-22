package src.controlador;

import java.util.Random;

import src.jugador.Jugador;

public class PiedraPapel {
    private Jugador Jugador1;
    private Jugador Jugador2;
    Random r = new Random();

    public PiedraPapel(Jugador Jugador1, Jugador Jugador2) {
        this.Jugador1 = Jugador1;
        this.Jugador2 = Jugador2;
        Jugar();
    }

    public void Jugar() {
        String Resultado = "Empate";
        System.out.println("Mini Juego Piedra Papel y Tijera");
        do {
            int Jug1 = r.nextInt(2) + 1;
            int Jug2 = r.nextInt(2) + 1;
            switch (Jug1) {
                case 1:
                    System.out.println(Jugador1.getNombre() + " Piedra");
                    break;
                case 2:
                    System.out.println(Jugador1.getNombre() + " Papel");
                    break;
                case 3:
                    System.out.println(Jugador1.getNombre() + " Tijeras");
                    break;
            }
            switch (Jug2) {
                case 1:
                    System.out.println(Jugador2.getNombre() + " Piedra");
                    break;
                case 2:
                    System.out.println(Jugador2.getNombre() + " Papel");
                    break;
                case 3:
                    System.out.println(Jugador2.getNombre() + " Tijeras");
                    break;
            }

            if (Jug1 == Jug2) {
                Resultado = "Empate";
            }
            if (Jug1 == 1 && Jug2 == 3) {
                Resultado = "Gana " + Jugador1.getNombre();
                Jugador1.setNegras(true);
            }
            if (Jug1 == 3 && Jug2 == 1) {
                Resultado = "Gana " + Jugador2.getNombre();
                Jugador2.setNegras(true);
            }

            if (Jug1 == 2 && Jug2 == 1) {
                Resultado = "Gana " + Jugador1.getNombre();
                Jugador1.setNegras(true);
            }
            if (Jug1 == 1 && Jug2 == 2) {
                Resultado = "Gana " + Jugador2.getNombre();
                Jugador2.setNegras(true);
            }

            if (Jug1 == 3 && Jug2 == 2) {
                Resultado = "Gana " + Jugador1.getNombre();
                Jugador1.setNegras(true);
            }
            if (Jug1 == 2 && Jug2 == 3) {
                Resultado = "Gana " + Jugador2.getNombre();
                Jugador2.setNegras(true);
            }

        } while (Resultado.equals("Empate"));
        System.out.println(Resultado);
    }

}
