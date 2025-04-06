import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MagoDeLasPalabras {
    // atributos
    private int turno, contadorRonda,numJugadores;
    private String modalidad;
    private Palabra palabra;
    private HashSet<Palabra> palabrasUsadasEnElTurno;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Letra> letras;
    private HashMap<Palabra, Integer> palabrasMap;

    public MagoDeLasPalabras(int numJugadores, String modalidad){
        // siempre inicia el jugador 1
        turno = 1;
        // guardo lo recibido de los parámetros del constructor en los atributos, respectivamente
        this.modalidad = modalidad;
        this.numJugadores = numJugadores;
        // inicializo arraylists
        jugadores = new ArrayList<>();
        letras = new ArrayList<>();
        palabrasMap = new HashMap<>();
        palabrasUsadasEnElTurno = new HashSet<>();
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
            // creo las palabras para el turno y las muestro
            generarLetras();
            // mientras quiera jugar
            int opcTurno = 1;
            int puntajeTurno = 0;
            int flagJugadorAdivinoPalabra = 0;
            while (opcTurno!=2) {
                mostrarLetras();
                opcTurno = mostrarMenuDeTurno();
                switch (opcTurno){
                    // jugar
                    case 1:
                        // establezco como falso
                        boolean validacionDeIntento = false;
                        // mientras no se usen las letras permitidas o no se solicite salir
                        while (!validacionDeIntento) {
                            solicitarPalabra();
                            validacionDeIntento = evaluarSiSeUsaronSoloLasLetrasPermitidas();
                            if (!validacionDeIntento) {
                                System.out.println("Solo puedes usar las letras en pantalla !");
                            }else{
                                if(validarPalabraEnArchivoTXT()) {
                                    if (!validarPalabraEnHashSet()) {
                                        System.out.println("Palabra correcta !");
                                        palabrasUsadasEnElTurno.add(palabra);
                                        puntajeTurno += encontrarPosicionPalabraEnHash();
                                        System.out.println("Puntaje actual del jugador " + turno + ": " + puntajeTurno);

                                        flagJugadorAdivinoPalabra = 1;
                                    } else {
                                        System.out.println("Palabra ya adivinada previamente ");
                                    }
                                }else {
                                    System.out.println("Palabra incorrecta ");
                                }
                            }
                        }
                        break;
                    // pasar turno
                    case 2:
                        // actualizo el puntaje
                        Jugador jugador = jugadores.get(turno);
                        if (flagJugadorAdivinoPalabra==1){
                            jugador.cambiarPuntaje(-5);
                            jugadores.set(turno, jugador);
                        }else{
                            jugador.cambiarPuntaje(puntajeTurno);
                            jugadores.set(turno, jugador);
                        }
                        puntajeTurno = 0;
                        cambiarTurno();
                        break;
                }

            }
        }
        mostrarGanador();
    }
    public boolean validarPalabraEnHashSet(){
        return palabrasUsadasEnElTurno.contains(palabra);
    }
    // mostrar puntajes
    public void mostrarPuntajes(){
        for (int i = 0; i<numJugadores; i++){
            Jugador jugador = jugadores.get(i);
            System.out.println("Puntaje jugador " + i + " " + jugador.obtenerPuntaje());
        }
    }
    // mostrar ganador
    public void mostrarGanador(){
        System.out.println("Ha ganado el jugador " + turno);
    }
    // encontrar idx palabra en hasmap
    public int encontrarPosicionPalabraEnHash(){
        return palabrasMap.get(palabra);
    }
    // validar palabra
    public boolean validarPalabraEnArchivoTXT(){
        if (palabrasMap.containsKey(palabra)){
            return true;
        }
        return false;
    }
    // menu del turno
    public int mostrarMenuDeTurno(){
        // imprimo quien está jugando actualmente y su puntaje hasta el momento
        Scanner sc = new Scanner(System.in);
        System.out.println("Turno actual: "+turno);
        System.out.println("1. Escribir palabra\n2. Pasar turno\nIngresa la opción: ");
        int opc = 0;
        if (sc.hasNextInt()) {
            opc = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
        } else {
            System.out.println("Entrada inválida. Debes ingresar un número.");
            sc.nextLine(); // Limpiar el texto inválido
        }
        return opc;
    }
    // evalua si se usaron solo las letras generadas para el turno
    public boolean evaluarSiSeUsaronSoloLasLetrasPermitidas(){
        if (palabra.toString().equals("1")){
            return true;
        }
        return palabra.palabraContieneLasLetras(letras);
    }
    // metodo para pedir que el jugador cree una palabra con las letras dadas
    public void solicitarPalabra(){
        Scanner sc = new Scanner(System.in);
        System.out.println("* Para regresar ingresa 1 * ");
        System.out.println("Forma una palabra con las letras dadas: ");
        String palabraTemporal = sc.nextLine();
        palabra = new Palabra(palabraTemporal);
    }
    public void hayGanador(){

    }
    public void cambiarTurno(){
        turno = turno%numJugadores+1;
        if (turno==numJugadores){
            contadorRonda++;
        }
    }
    public void cargarPalabras(){
        String nombreArchivo ="C:\\Users\\RedBo\\OneDrive\\Escritorio\\POO\\PRACTICA_5\\Practica-5\\out\\production\\Practica-5\\palabras.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String palabra;
            Integer puntaje;
            while ((palabra = br.readLine()) != null) {
              //  System.out.println(palabra);
                Palabra p = new Palabra(palabra);
                puntaje=p.obtejerPuntajePalabra();
                palabrasMap.put(p, puntaje);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void leerPalabrasDeArchivo() {
    }
    // mostrar las letras para el turno actual
    public void mostrarLetras(){
        System.out.println("Tus letras son: ");
        for (int i = 0; i<letras.size();i++){
            System.out.println(letras.get(i));
        }
    }
    // generar las 10 letras
    public void generarLetras(){
        letras.clear();
        // ciclo for 0 - 9
        for (int i = 0; i < 10; i++){
            // creo un objeto letra y la agrego al arraylist de letras
            Letra letraTemporal = new Letra('0');
            Character toma =  letraTemporal.tomarLetra();
            Letra letra = new Letra(toma);
            letras.add(letra);
        }
    }

    public void mostrarPalabrasDisponibles(){

    }
}
