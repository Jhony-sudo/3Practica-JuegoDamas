package src.tablero;

public class Ficha {
    private boolean esNegra;
    private boolean esReina;

    private char celda = 178;
    private char celdaColor = 219;
    // █▓
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[31m";

    private String id;

    public String getCaracter() {
        String res = (esNegra) ? "" + ANSI_BLACK + celda : "" + ANSI_YELLOW + celda;
        return res;
    }

    public Ficha(boolean esNegra, String id) {
        this.esNegra = esNegra;
        this.id = id;
        this.esReina = false;
    }

    public String getId() {
        return id;
    }

    public boolean getesNegra() {
        return esNegra;
    }

    public boolean esReina() {
        return esReina;
    }

    public void setReina(boolean EsReina) {
        this.esReina = EsReina;
    }

    public void setId(String Id) {
        this.id = Id;
    }

}
