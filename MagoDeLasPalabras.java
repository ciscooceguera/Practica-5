import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MagoDeLasPalabras {
    // atributos
    private int turno, contadorRonda,numJugadores;
    private String modalidad;
    private Palabra palabra;
    private Letra letraProhibida;
    private HashSet<Palabra> palabrasUsadasEnElTurno;
    private HashMap<Integer,Integer> jugadores;
    private HashMap<Integer,Palabra> jugadorPalabrasUsadas;
    private HashSet<Letra> letras;
    private HashMap<Palabra, Integer> palabrasMap;

    public MagoDeLasPalabras(int numJugadores, String modalidad){
        // siempre inicia el jugador 1
        turno = 1;
        // guardo lo recibido de los parámetros del constructor en los atributos, respectivamente
        this.modalidad = modalidad;
        this.numJugadores = numJugadores;
        // inicializo arraylists
        jugadores = new HashMap<>();
        letras = new HashSet<>();
        palabrasMap = new HashMap<>();
        palabrasUsadasEnElTurno = new HashSet<>();
        jugadorPalabrasUsadas = new HashMap<>();
        letraProhibida = new Letra('3');
        contadorRonda = 0;
    }
    // inicializo puntajes en 0s
    public void inicializarPuntajes(){
        for (int i = 0; i<numJugadores; i++){
            jugadores.put(i,0);
        }
    }
    // tomar una letra de letras para el modo dificil
    public void generarLetraProhibida(){
        Random rnd = new Random();
        int numRandom = rnd.nextInt(9), contador = 0;
        for (Letra letra : letras){
            contador++;
            if (contador == numRandom){
                letraProhibida = letra;
                break;
            }
        }
    }
    // control del flujo del juego
    public void iniciarJuego(){
        cargarPalabras();
        inicializarPuntajes();
        while (contadorRonda!=3){
            // creo las palabras para el turno y las muestro
            generarLetras();
            // si la modalidad es dificil
            if (modalidad.equals("Experto")){
                generarLetraProhibida();
            }
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
                                System.out.println("Solo puedes usar las letras en permitidas !");
                            }else{
                                if(validarPalabraEnArchivoTXT()) {
                                    if (!validarPalabraEnHashSet()) {
                                        System.out.println("Palabra correcta !");
                                        palabrasUsadasEnElTurno.add(palabra);
                                        jugadorPalabrasUsadas.put(turno-1,palabra);
                                        puntajeTurno += encontrarValuePalabraEnHash();
                                        System.out.println("Puntaje de la palabra: " + puntajeTurno);

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
                        int puntajeTemp = jugadores.get(turno-1);
                        // no adivinó
                        if (flagJugadorAdivinoPalabra==0){
                            puntajeTemp -= 5;
                            jugadores.remove(turno-1);
                            jugadores.put(turno-1, puntajeTemp);
                        // sí adivinó
                        }else{
                            puntajeTemp += puntajeTurno;
                            jugadores.remove(turno-1);
                            jugadores.put(turno-1, puntajeTemp);
                        }
                        puntajeTurno = 0;
                        cambiarTurno();
                        break;
                    // case ver palabras
                    case 3:
                        mostrarPalabrasJugador(turno-1);
                        break;
                }

            }
        }
        mostrarGanador();
        mostrarPuntajes();
    }
    public boolean validarPalabraEnHashSet(){
        return palabrasUsadasEnElTurno.contains(palabra);
    }
    // mostrar puntajes
    public void mostrarPuntajes(){
        for (int i = 0; i<numJugadores; i++){
            int j = i+1;
            System.out.println("Puntaje jugador " + j + ": " + jugadores.get(i));
        }
    }
    // mostrar ganador
    public void mostrarGanador(){
        ArrayList<Integer> jugadoresGanadores = new ArrayList<>();
        int ganador = 0;
        for (int i = 0; i<numJugadores-1; i++){
            int jugador = jugadores.get(i);
            int jugadorSig = jugadores.get(i+1);
            if (jugador<jugadorSig){
                ganador = i+1;
            }else if (jugador==jugadorSig){
                jugadoresGanadores.add(ganador);
                jugadoresGanadores.add(ganador+1);
                ganador = -2;
            }
        }
        ganador+=1;
        if (ganador==-1){
            System.out.println("Empate, ganadores:");
            for (Integer jugadoresGanadore : jugadoresGanadores) {
                System.out.println("Jugador " + jugadoresGanadore);
            }
        }else {
            System.out.println("Ha ganado el jugador " + ganador);
        }
    }
    // encontrar idx palabra en hasmap
    public int encontrarValuePalabraEnHash(){
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
        System.out.println("1. Escribir palabra\n2. Pasar turno\n3. Ver Palabras adivinadas del jugador actual\nIngresa la opción: ");
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
        return palabra.palabraContieneLasLetras(letras,letraProhibida);
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
        if (turno==numJugadores){
            contadorRonda++;
        }
        turno = turno%numJugadores+1;
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
        Iterator<Letra> iterator = letras.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        if (modalidad.equals("Experto")) {
            System.out.println("Letra Prohibida: " + letraProhibida);
        }
    }
    // generar las 10 letras
    public void generarLetras(){
        letras.clear();
        // ciclo for 0 - 9
        while (letras.size()<10){
            // creo un objeto letra y la agrego al arraylist de letras
            Letra letraTemporal = new Letra('0');
            Character toma =  letraTemporal.tomarLetra();
            Letra letra = new Letra(toma);
            letras.add(letra);

        }
    }

    public void mostrarPalabrasJugador(int jugador) {
        int puntajeAcumulado = 0;
        Iterator<Palabra> iterator = palabrasUsadasEnElTurno.iterator();
        System.out.println("\nPalabras del jugador "+(jugador+1));
        if(jugadorPalabrasUsadas.size()==0){
            System.out.println("\nNo hay palabras del jugador\n");
        } else {
            for(int i=0; i<jugadores.size(); i++){
                if (jugadorPalabrasUsadas.containsKey(jugador-1)){
                    while(iterator.hasNext()){
                        Palabra palabra = iterator.next();
                        puntajeAcumulado += palabra.obtejerPuntajePalabra();
                        int puntaje = palabra.obtejerPuntajePalabra();
                        if(palabrasUsadasEnElTurno.contains(palabra)){
                            System.out.println("Palabra usada: "+palabra+". Puntos: "+puntaje);
                        }
                    }
                }
            }
            System.out.println("Puntaje del jugador: "+puntajeAcumulado+"\n");
        }
    }
}
