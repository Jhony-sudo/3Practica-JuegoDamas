package src.controlador;

import src.jugador.*;
import src.tablero.*;
import java.util.*;

public class Controlador {
    private Tablero tablero;
    private Jugador Jugador1;
    private Jugador Jugador2;
    Scanner leer = new Scanner(System.in);

    public Controlador(Jugador Jugador1, Jugador Jugador2, Tablero Tablero) {
        this.Jugador1 = Jugador1;
        this.Jugador2 = Jugador2;
        this.tablero = Tablero;
        Jugar();
    }

    public void Jugar() {

        do {
            if (Jugador1.getNegra()) {
                System.out.println("Turno Fichas Negras: " + Jugador1.getNombre());
                tablero.pintarTablero();
                moverFicha(Jugador1.getNegra());
                System.out.println("Turno Fichas Blancas: " + Jugador2.getNombre());
                tablero.pintarTablero();
                moverFicha(Jugador2.getNegra());

            } else {
                System.out.println("Turno Fichas Negras: " + Jugador2.getNombre());
                tablero.pintarTablero();
                moverFicha(Jugador2.getNegra());
                System.out.println("Turno Fichas Blancas: " + Jugador1.getNombre());
                tablero.pintarTablero();
                moverFicha(Jugador1.getNegra());

            }
        } while (FinalizarPartida() != false);
        System.out.println("El juego ha terminado");
    }

    public boolean FinalizarPartida() {
        boolean res = true;
        boolean HayNegras = false;
        boolean HayBlancas = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.getCelda(i, j).ocupadaPorFicha()) {

                    if (tablero.getCelda(i, j).obtFicha().getesNegra()) {
                        HayNegras = true;
                    }

                    if (!tablero.getCelda(i, j).obtFicha().getesNegra()) {
                        HayBlancas = true;
                    }

                }
            }
        }
        if (!HayBlancas || !HayNegras) {
            res = false;
            Jugador1.setPartidasJugadas(Jugador1.getPartidasJugadas() + 1);
            Jugador2.setPartidasJugadas(Jugador2.getPartidasJugadas() + 1);
            if (Jugador1.getNegra()) {
                if (!HayBlancas) {
                    System.out.println("Gana fichas blancas " + Jugador2.getNombre());
                    Jugador2.setPartidasGanadas(Jugador2.getPartidasGanadas() + 1);
                } else {
                    System.out.println("Gana fichas negras" + Jugador1.getNombre());
                    Jugador1.setPartidasGanadas(Jugador1.getPartidasGanadas() + 1);
                }
            } else {
                if (!HayBlancas) {
                    System.out.println("Gana fichas blancas " + Jugador1.getNombre());
                    Jugador1.setPartidasGanadas(Jugador1.getPartidasGanadas() + 1);
                } else {
                    System.out.println("Gana fichas negras" + Jugador2.getNombre());
                    Jugador2.setPartidasGanadas(Jugador2.getPartidasGanadas() + 1);
                }

            }
        }
        return res;
    }

    public void moverFicha(boolean EsNegra) {
        int posXFin = 0;
        int posYFin = 0;
        int PosicionX1 = 0;
        int PosicionY1 = 0;
        int PosicionX2 = 0;
        int PosicionY2 = 0;
        System.out.println("Ingrese la posicion de la ficha que desea mover");
        int posXIni = leer.nextInt();
        int posYIni = leer.nextInt();
        if (tablero.getCelda(posXIni, posYIni).ocupadaPorFicha()
                && !tablero.getCelda(posXIni, posYIni).obtFicha().esReina()) {
            if (!EsNegra) {
                if (tablero.getCelda(posXIni, posYIni).ocupadaPorFicha()
                        && !tablero.getCelda(posXIni, posYIni).obtFicha().getesNegra()) {
                    if (posXIni == 0 || posXIni == 7) {
                        if (posXIni == 0) {
                            PosicionX1 = posXIni + 1;
                            PosicionY1 = posYIni + 1;
                        } else {
                            PosicionX2 = posXIni - 1;
                            PosicionY2 = posYIni + 1;
                        }

                    } else {
                        PosicionX1 = posXIni + 1;
                        PosicionY1 = posYIni + 1;
                        PosicionX2 = posXIni - 1;
                        PosicionY2 = posYIni + 1;
                    }
                }
            }
            if (EsNegra) {
                if (tablero.getCelda(posXIni, posYIni).ocupadaPorFicha()
                        && tablero.getCelda(posXIni, posYIni).obtFicha().getesNegra()) {
                    if (posXIni == 0 || posXIni == 7) {
                        if (posXIni == 0) {
                            PosicionX1 = posXIni + 1;
                            PosicionY1 = posYIni - 1;
                        } else {
                            PosicionX2 = posXIni - 1;
                            PosicionY2 = posYIni - 1;
                        }

                    } else {
                        PosicionX1 = posXIni + 1;
                        PosicionY1 = posYIni - 1;
                        PosicionX2 = posXIni - 1;
                        PosicionY2 = posYIni - 1;
                    }
                }
            }

            do {
                System.out.println("Elija uno de los dos mivimientos posibles");
                System.out.println("Movimiento1: x = " + PosicionX1 + " y = " + PosicionY1);
                System.out.println("Movimiento2: x = " + PosicionX2 + "  y = " + PosicionY2);
                int Seleccion = leer.nextInt();
                if (Seleccion == 1) {
                    posXFin = PosicionX1;
                    posYFin = PosicionY1;
                }
                if (Seleccion == 2) {
                    posXFin = PosicionX2;
                    posYFin = PosicionY2;
                }
                MatarBlancas(posXIni, posYIni, posXFin, posYFin, EsNegra, Seleccion);
                MatarNegras(posXIni, posYIni, posXFin, posYFin, EsNegra, Seleccion);

            } while (!ValidarMovimiento(posXFin, posYFin));
            if (!tablero.getCelda(posXFin, posYFin).ocupadaPorFicha()) {
                tablero.getCelda(posXFin, posYFin).setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
            }
        } else if (tablero.getCelda(posXIni, posYIni).obtFicha().esReina()) {
            System.out.println("Tooodo bien");
            MoverReina(posXIni, posYIni);
        }
        tablero.AsignarReina();

    }

    public boolean ValidarMovimiento(int x, int y) {
        boolean res = true;
        if (!tablero.getCelda(x, y).ocupadaPorFicha()) {
            res = true;
        } else {
            res = false;
        }
        return res;

    }

    public void MatarBlancas(int posXIni, int posYIni, int posXFin, int posYFin, boolean Negras, int Sele) {
        if (Negras) {
            if (tablero.getCelda(posXFin, posYFin).ocupadaPorFicha()
                    && !tablero.getCelda(posXFin, posYFin).obtFicha().getesNegra()) {
                if (Sele == 1 && !tablero.getCelda(posXFin + 1, posYFin - 1).ocupadaPorFicha()) {
                    tablero.getCelda(posXFin + 1, posYFin - 1).setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                    tablero.getCelda(posXFin, posYFin).getFicha();
                }

                if (Sele == 2 && !tablero.getCelda(posXFin - 1, posYFin - 1).ocupadaPorFicha()) {
                    tablero.getCelda(posXFin - 1, posYFin - 1).setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                    tablero.getCelda(posXFin, posYFin).getFicha();

                }
            }
        }
    }

    public void MatarNegras(int posXIni, int posYIni, int posXFin, int posYFin, boolean Negras, int Sele) {
        if (!Negras) {
            if (tablero.getCelda(posXFin, posYFin).ocupadaPorFicha()
                    && tablero.getCelda(posXFin, posYFin).obtFicha().getesNegra()) {
                System.out.println(Sele);
                if ((Sele == 1 || Sele == 4) && !tablero.getCelda(posXFin + 1, posYFin + 1).ocupadaPorFicha()) {
                    tablero.getCelda(posXFin + 1, posYFin + 1).setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                    tablero.getCelda(posXFin, posYFin).getFicha();
                }

                if ((Sele == 2 || Sele == 3) && !tablero.getCelda(posXFin - 1, posYFin + 1).ocupadaPorFicha()) {
                    tablero.getCelda(posXFin - 1, posYFin + 1).setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                    tablero.getCelda(posXFin, posYFin).getFicha();

                }

            }

        }
    }

    public void MoverReina(int posXIni, int posYIni) {
        int X1 = 0, Y1 = 0, X2 = 0, Y2 = 0, X3 = 0, Y3 = 0, X4 = 0, Y4 = 0;
        int posXFin = 0, posYFin = 0;
        int Seleccion;
        if (tablero.getCelda(posXIni, posYIni).obtFicha().esReina()) {
            if (tablero.getCelda(posXIni, posYIni).obtFicha().getesNegra()
                    || !tablero.getCelda(posXIni, posYIni).obtFicha().getesNegra()) {
                if (posXIni == 7) {
                    if (posYIni == 0) {
                        X3 = 6;
                        Y3 = 1;
                        if (tablero.getCelda(X3, Y3).ocupadaPorFicha()
                                && !tablero.getCelda(X3, Y3).obtFicha().getesNegra()
                                && !tablero.getCelda(X3 - 1, Y3 + 1).ocupadaPorFicha()) {
                            tablero.getCelda(X3 - 1, Y3 - 1).setFicha(tablero.getCelda(posXIni, posYIni).obtFicha());
                        }
                    } else {
                        X3 = posXIni - 1;
                        Y3 = posYIni + 1;
                        X1 = posXIni - 1;
                        Y1 = posYIni - 1;
                    }
                } else if (posXIni > 0 && posXIni < 6 && posYIni == 0) {
                    System.out.println(posXIni + "   " + X3);
                    X3 = posXIni - 1;
                    Y3 = posYIni + 1;
                    X4 = posXIni + 1;
                    Y4 = posYIni + 1;

                } else if (posXIni == 0) {
                    X2 = posXIni + 1;
                    Y2 = posYIni - 1;
                    X4 = posXIni + 1;
                    Y4 = posYIni + 1;
                } else {
                    X1 = posXIni - 1;
                    Y1 = posYIni - 1;
                    X2 = posXIni + 1;
                    Y2 = posYIni - 1;
                    X3 = posXIni - 1;
                    Y3 = posYIni + 1;
                    X4 = posXIni + 1;
                    Y4 = posYIni + 1;
                }
                do {
                    System.out.println("Elija una opcion de movimiento");
                    System.out.println("Movimiento 1: x = " + X1 + "  y = " + Y1);
                    System.out.println("Movimiento 2: x = " + X2 + "  y = " + Y2);
                    System.out.println("Movimiento 3: x = " + X3 + "  y = " + Y3);
                    System.out.println("Movimiento 4: x = " + X4 + "  y = " + Y4);
                    Seleccion = leer.nextInt();
                    switch (Seleccion) {
                        case 1:
                            posXFin = X1;
                            posYFin = Y1;
                            break;
                        case 2:

                            posXFin = X2;
                            posYFin = Y2;
                            break;
                        case 3:
                            posXFin = X3;
                            posYFin = Y3;
                            break;
                        case 4:
                            posXFin = X4;
                            posYFin = Y4;
                            break;
                        default:
                            System.out.println("Ingrese una opcion correcta");
                            break;

                    }
                    MatarReina(posXIni, posYIni, posXFin, posYFin, Seleccion);

                    System.out.println("Sali ");
                } while (!ValidarMovimiento(posXFin, posYFin));

            }
        }

        if (!tablero.getCelda(posXFin, posYFin).ocupadaPorFicha()) {
            tablero.getCelda(posXFin, posYFin).setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
        }
        System.out.println("Sali");
    }

    public void MatarReina(int posXIni, int posYIni, int posXFin, int posYFin, int Sele) {
        System.out.println("Entre al metodo");
        if (tablero.getCelda(posXIni, posYIni).ocupadaPorFicha()
                && tablero.getCelda(posXIni, posYIni).obtFicha().esReina()
                && tablero.getCelda(posXFin, posYFin).ocupadaPorFicha()) {
            System.out.println("Primera validacion");
            if (tablero.getCelda(posXIni, posYIni).obtFicha().getesNegra()
                    && !tablero.getCelda(posXFin, posYFin).obtFicha().getesNegra()) {
                System.out.println("Es Negra");
                switch (Sele) {
                    case 1:
                        if (!tablero.getCelda(posXFin - 1, posYFin - 1).ocupadaPorFicha()) {
                            tablero.getCelda(posXFin - 1, posYFin - 1)
                                    .setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                            tablero.getCelda(posXFin, posYFin).getFicha();
                        }
                        break;
                    case 2:
                        if (!tablero.getCelda(posXFin + 1, posYFin - 1).ocupadaPorFicha()) {
                            tablero.getCelda(posXFin + 1, posYFin - 1)
                                    .setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                            tablero.getCelda(posXFin, posYFin).getFicha();
                        }
                        break;
                    case 3:
                        if (!tablero.getCelda(posXFin - 1, posYFin + 1).ocupadaPorFicha()) {
                            tablero.getCelda(posXFin - 1, posYFin + 1)
                                    .setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                            tablero.getCelda(posXFin, posYFin).getFicha();
                        }
                        break;
                    case 4:
                        System.out.println("Entre al caso 4");
                        if (!tablero.getCelda(posXFin + 1, posYFin + 1).ocupadaPorFicha()) {
                            System.out.println("If");
                            tablero.getCelda(posXFin + 1, posYFin + 1)
                                    .setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                            System.out.println("Penultima");
                            tablero.getCelda(posXFin, posYFin).getFicha();
                            System.out.println("Todo bien");
                        }
                        break;
                    default:
                        break;
                }
            }
            // Reina Blanca
            if (!tablero.getCelda(posXIni, posYIni).obtFicha().getesNegra()
                    && tablero.getCelda(posXFin, posYFin).obtFicha().getesNegra()) {
                System.out.println("Es blanca");
                switch (Sele) {
                    case 1:
                        if (!tablero.getCelda(posXFin - 1, posYFin - 1).ocupadaPorFicha()) {
                            tablero.getCelda(posXFin - 1, posYFin - 1)
                                    .setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                            tablero.getCelda(posXFin, posYFin).getFicha();
                        }
                        break;
                    case 2:
                        if (!tablero.getCelda(posXFin + 1, posYFin - 1).ocupadaPorFicha()) {
                            tablero.getCelda(posXFin + 1, posYFin - 1)
                                    .setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                            tablero.getCelda(posXFin, posYFin).getFicha();
                        }
                        break;
                    case 3:
                        if (!tablero.getCelda(posXFin - 1, posYFin + 1).ocupadaPorFicha()) {
                            tablero.getCelda(posXFin - 1, posYFin + 1)
                                    .setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                            tablero.getCelda(posXFin, posYFin).getFicha();
                        }
                        break;
                    case 4:
                        if (!tablero.getCelda(posXFin + 1, posYFin + 1).ocupadaPorFicha()) {
                            tablero.getCelda(posXFin + 1, posYFin + 1)
                                    .setFicha(tablero.getCelda(posXIni, posYIni).getFicha());
                            tablero.getCelda(posXFin, posYFin).getFicha();
                        }
                        break;
                    default:
                        break;
                }
            }

        }

    }

}
