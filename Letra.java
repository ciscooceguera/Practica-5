import java.util.ArrayList;

public class Letra {
    // atributos
    private ArrayList<Character> vocales;
    private char letra;
    public Letra(char letra){
        this.letra = letra;
        // genero ArrayList de vocales
        vocales = new ArrayList<Character>();
        vocales.add('a');
        vocales.add('e');
        vocales.add('i');
        vocales.add('o');
        vocales.add('u');
        vocales.add('A');
        vocales.add('E');
        vocales.add('I');
        vocales.add('O');
        vocales.add('U');
    }
    // evaluar si es consonante
    public boolean esConsonante(){
        // si es vocal, no es consontante; y viceversa
        if (esVocal()){
            return false;
        }
        return true;
    }
    // evaluar si es vocal
    public boolean esVocal(){
        /* convierto el arraylist de caracteres a stream y uso metodo anyMatch()
        para comparar cada elemento con letra */
        return vocales.stream().anyMatch(vocal -> vocal.equals(letra));
    }
}
