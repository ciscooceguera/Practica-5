import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Letra {
    private ArrayList<String> vocales;
    private char letra;
    public Letra(char letra){
        this.letra = letra;
        // genero ArrayList de vocales
        vocales = new ArrayList<String>();
        vocales.add("a");
        vocales.add("e");
        vocales.add("i");
        vocales.add("o");
        vocales.add("u");
    }
    public boolean esConsonante(){
        return false;
    }
    public boolean esVocal(){
        Optional<String> resultado = vocales.stream()
                .filter(vocal->vocal.equals(letra))
                .findAny();
        if (resultado.isEmpty()){
            return false;
        }
        return true;
    }
}
