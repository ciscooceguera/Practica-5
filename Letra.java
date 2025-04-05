import java.util.ArrayList;

public class Letra {
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
    public boolean esConsonante(){
        if (esVocal()){
            return false;
        }
        return true;
    }
    public boolean esVocal(){
        return vocales.stream().anyMatch(vocal -> vocal.equals(letra));
    }
}
