import java.util.ArrayList;

public class MagoDeLasPalabras {
    // atributos
    private int turno, contadorRonda,numJugadores;
    private String modalidad;
    private ArrayList<Palabra> palabras;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Letra> letras;
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
    }
    public void iniciarJuego(){
        cargarPalabras();
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
