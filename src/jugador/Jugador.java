package src.jugador;

public class Jugador {
    private String Nombre;
    private int PartidasJugadas;
    private int PartidasGanadas;
    private boolean Negras;

    public Jugador(String Nombre) {
        this.Nombre = Nombre;
        this.PartidasGanadas = 0;
        this.PartidasJugadas = 0;

    }

    public int getPartidasGanadas() {
        return PartidasGanadas;
    }

    public int getPartidasJugadas() {
        return PartidasJugadas;
    }

    public void setPartidasGanadas(int Par) {
        this.PartidasGanadas += Par;
    }

    public void setPartidasJugadas(int Par) {
        this.PartidasJugadas += Par;
    }

    public String MostrarInformacion() {
        String Datos = "Nombre: " + Nombre;
        return Datos;
    }

    public void Estadisticas() {
        System.out.println("Nombre: " + Nombre + "  Partidas Gandas: " + PartidasGanadas);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNegras(boolean lado) {
        this.Negras = lado;
    }

    public boolean getNegra() {
        return Negras;
    }
}
