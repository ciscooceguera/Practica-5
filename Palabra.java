import java.util.ArrayList;
import java.util.HashSet;

public class Palabra {
    // atributos
    private String palabra;
    private int puntaje;
    // constructor, recibe palabra
    public Palabra(String palabra){
        if (palabra == null || palabra.isEmpty()) {
            throw new IllegalArgumentException("La palabra no puede ser nula o vacía.");
        }
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
            }else if (letra.esConsonante()){
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
    // separar palabra en arraylist de caracteres
    public ArrayList<Letra> obtenerLetras(){
        ArrayList<Letra> letras = new ArrayList<>();
        for (int i = 0; i<palabra.length(); i++){
            Letra letra = new Letra(palabra.charAt(i));
            letras.add(letra);
        }
        return letras;
    }
    public boolean palabraContieneLasLetras(HashSet<Letra> letrasUsadas){
        ArrayList<Letra> palabraUsadaArrayList = obtenerLetras();
        int contadorLetrasUsadas = 0;
        for (int i = 0; i < palabraUsadaArrayList.size(); i++){
            Letra letra = palabraUsadaArrayList.get(i);
            if (letrasUsadas.contains(letra)){
                contadorLetrasUsadas++;
                break;
            }
        }
        return contadorLetrasUsadas == palabraUsadaArrayList.size();
    }
    public String toString() {
        return palabra;
    }
}
