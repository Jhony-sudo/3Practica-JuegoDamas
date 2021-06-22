package src.tablero;

import java.util.Scanner;

public class Tablero {
    Scanner leer = new Scanner(System.in);
    private Celda[][] tablero;
    private final int x, y;

    private boolean juegoEnBlancas;

    public Tablero(int x, int y, boolean juegoEnBlancas) {
        this.juegoEnBlancas = juegoEnBlancas;
        this.x = x;
        this.y = y;
        tablero = new Celda[x][y];
        // inicializarTablero();
        // inicializarFichas(0, 3, true, "BB");
        // inicializarFichas(5, 8, false, "NN");

    }

    public void inicializarFichas(int ini, int cant, boolean esBlanca, String id) {
        for (int i = ini; i < cant; i++) {
            for (int j = 0; j < x; j++) {
                if (tablero[j][i].getEsColor() == !juegoEnBlancas) {
                    tablero[j][i].setFicha(new Ficha(!esBlanca, id));
                }
            }

        }
    }

    public void inicializarTablero() {

        boolean esColorInicio = false;
        boolean esColorIteracion = false;
        for (int i = 0; i < y; i++) {
            esColorIteracion = !esColorInicio;
            for (int j = 0; j < x; j++) {
                tablero[j][i] = new Celda(esColorIteracion);
                esColorIteracion = !esColorIteracion;

            }
            esColorInicio = !esColorInicio;
        }
    }

    public void pintarTablero() {
        System.out.println("   0     1      2     3     4     5     6     7");
        for (int i = 0; i < y; i++) {

            for (int k = 0; k < 3; k++) {
                if (k == 1) {
                    System.out.print(i);
                } else
                    System.out.print(" ");
                for (int j = 0; j < x; j++) {
                    System.out.print(tablero[j][i].pintarCelda(k));
                }
                if (k == 1) {
                    System.out.println(i);
                } else {
                    System.out.println(" ");
                }
            }

        }
        System.out.println("   0     1      2     3     4     5     6     7");
        System.out.println("\n\n");
    }

    public Celda getCelda(int x, int y) {
        return tablero[x][y];
    }

    public void esReina(int x, int y) {
        tablero[x][y].obtFicha().setReina(true);
    }

    public void AsignarReina() {
        for (int i = 0; i < 8; i++) {
            if (tablero[i][0].ocupadaPorFicha() && tablero[i][0].obtFicha().getesNegra()) {
                tablero[i][0].obtFicha().setReina(true);
                tablero[i][0].obtFicha().setId("RN");
            }

            if (tablero[i][7].ocupadaPorFicha() && !tablero[i][7].obtFicha().getesNegra()) {
                tablero[i][7].obtFicha().setReina(true);
                tablero[i][7].obtFicha().setId("RB");
            }
        }
    }

}
