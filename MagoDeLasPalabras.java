import java.util.ArrayList;
import java.util.HashMap;

public class MagoDeLasPalabras {
    // atributos
    private int turno, contadorRonda,numJugadores;
    private String modalidad;
    private HashMap<Palabra,Integer> palabras;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Letra> letras;
    public MagoDeLasPalabras(int numJugadores, String modalidad){
        // siempre inicia el jugador 1
        turno = 1;
        // guardo lo recibido de los parámetros del constructor en los atributos, respectivamente
        this.modalidad = modalidad;
        this.numJugadores = numJugadores;
        // inicializo arraylists
        palabras = new HashMap<>();
        jugadores = new ArrayList<>();
        letras = new ArrayList<>();
        contadorRonda = 0;
    }
    // inicializo puntajes en 0s
    public void inicializarPuntajes(){
        for (int i = 0; i<numJugadores; i++){
            Jugador jugador = new Jugador();
            jugadores.add(jugador);
        }
    }
    // control del flujo del juego
    public void iniciarJuego(){
        cargarPalabras();
        inicializarPuntajes();
        while (contadorRonda<3){

        }
    }
    public void hayGanador(){

    }
    public void cambiarTurno(){
        turno = turno%numJugadores+1;
    }
    public void cargarPalabras(){
    }

    public void leerPalabrasDeArchivo(){

    }

    public void mostrarPalabrasDisponibles(){

    }
}
