import java.util.ArrayList;

public class Palabra {
    // atributos
    private String palabra;
    private int puntaje;
    // constructor, recibe palabra
    public Palabra(String palabra){
        this.palabra = palabra;
        puntaje = 0;
    }
    // obtiene el puntaje de la palabra
    public int obtejerPuntajePalabra(){
        // itero cada elemento del string
        for (int i = 0; i<palabra.length(); i++){
            // creo objeto de la palabra letra
            Letra letra = new Letra(palabra.charAt(i));
            // es vocal
            if (letra.esVocal()){
                puntaje+=5;
            // es consonante
            }else{
                puntaje+=3;
            }
        }
        return puntaje;
    }
    // recibe palabra y evalua si es igual
    public boolean palabraEsIgualA(Palabra otraPalabra){
        // compara si son iguales ignorando mayusculas y minusculas
        return this.palabra.equalsIgnoreCase(otraPalabra.palabra);
    }
}
