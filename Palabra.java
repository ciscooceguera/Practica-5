public class Palabra {
    // atributos
    private String palabra;
    private int puntaje;
    public Palabra(String palabra){
        this.palabra = palabra;
    }
    public int obtejerPuntajePalabra(){
        return puntaje;
    }
    public boolean palabraEsIgualA(Palabra otraPalabra){
        return this.palabra.equalsIgnoreCase(otraPalabra.palabra);
    }
}
