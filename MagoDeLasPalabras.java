import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MagoDeLasPalabras {
    // atributos
    private int turno, contadorRonda,numJugadores;
    private String modalidad;
    private ArrayList<Palabra> palabras;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Letra> letras;
    private HashMap<Integer, Palabra> palabrasMap;

    public MagoDeLasPalabras(int numJugadores, String modalidad){
        // siempre inicia el jugador 1
        turno = 1;
        // guardo lo recibido de los parámetros del constructor en los atributos, respectivamente
        this.modalidad = modalidad;
        this.numJugadores = numJugadores;
        // inicializo arraylists
        palabras = new ArrayList<>();
        jugadores = new ArrayList<>();
        letras = new ArrayList<>();
        palabrasMap = new HashMap<>();
    }
    // control del flujo del juego
    public void iniciarJuego(){
        cargarPalabras();
    }
    public void cambiarTurno(){
        turno = turno%numJugadores+1;
    }
    public void cargarPalabras(){
        String nombreArchivo ="C:\\Users\\joser\\IdeaProjects\\Practica-5\\palabras.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String palabra;
            Integer puntaje;
            while ((palabra = br.readLine()) != null) {
                System.out.println(palabra);
                Palabra p = new Palabra(palabra);
                puntaje=p.obtejerPuntajePalabra();
                palabrasMap.put(puntaje, p);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public ArrayList<Letra> generarLetras(){
        ArrayList<Letra> extraccion = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Letra temp = new Letra('0');
            Character toma =  temp.tomarLetra();
            Letra letra = new Letra(toma);
            extraccion.add(letra);
        }
        return extraccion;
    }

    public void mostrarPalabrasDisponibles(){
        for(int i = 0; i < palabrasMap.size(); i++){
            Palabra p = palabrasMap.get(i);
            if(p != null) {
                System.out.println(p.toString());
            }
        }
    }
}
