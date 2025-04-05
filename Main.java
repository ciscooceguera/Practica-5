import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        while (opc!= 3) {
            // pregunto que acció quiere realizar el usuario
            System.out.println("1. Jugar\n2. Reglas\n3. Créditos\n4. Salir\nIngresa una opción: ");
            opc = sc.nextInt();
            sc.nextLine();
            // switch de la opción seleccionada
            switch (opc){
                // opción jugar
                case 1:
                    int numJugadores = 0;
                    while (numJugadores<2 || numJugadores>4){
                        // solicito # jugadores
                        System.out.println("\nIngresa el número de jugadores (2 - 4): ");
                        numJugadores = sc.nextInt();
                        sc.nextLine();
                    }
                   int modalidadInt = 0;
                    while (modalidadInt != 1 && modalidadInt !=2){
                        // solicito modalidad
                        System.out.println("\n1. Regular\n2. Experto\nEscoje la modalidad: ");
                        modalidadInt = sc.nextInt();
                        sc.nextLine();
                    }
                    String modalidad = "";
                    switch (modalidadInt){
                        case 1-> modalidad = "Regular";
                        case 2-> modalidad = "Experto";
                        default->System.out.println("\nOpción inválida");
                    }

                    break;
                // opción reglas
                case 2:
                    int reglasOpc = 0;
                    while(reglasOpc!=2) {
                        System.out.println("\n1. Reglas modalidad Regular\n2. Reglas modalidad Experto\n3. Salir\nIngresa una opción: ");
                        reglasOpc = sc.nextInt();
                        sc.nextLine();
                        switch (reglasOpc) {
                            // ver reglas de modalidad regular
                            case 1:
                                System.out.println("\nReglas Modalidad Regular:\nRecibe un conjunto de 10 letras y forma todas las palabras válidas" +
                                                " posibles con estas para poder puntuar.\n" +
                                        "Al formar una palabra válida, recibe 5 puntos por c/d vocal y 3 por c/d consonante.\n" +
                                        "Si el jugador no forma una palabra válida, entonces pierde 5 puntos.\n" +
                                                "No podrás repetir palabras en una ronda.\nUna ronda termina si todos los jugadores" +
                                                " acuerdan no poder escribir más palabras.\nAl pasar 3 rondas el ganador será aquel" +
                                                " que haya acumulado una mayor cantidad de puntos");
                                break;
                            // ver reglas de modalidad experto
                            case 2:
                                System.out.println("\nReglas Modalidad Experto:\nRecibe un conjunto de 10 letras y forma todas las palabras válidas" +
                                                " posibles con estas para poder puntuar.\n" +
                                                "Al formar una palabra válida, recibe 5 puntos por c/d vocal y 3 por c/d consonante.\n" +
                                                "Si el jugador no forma una palabra válida, entonces pierde 5 puntos.\n" +
                                                "No podrás repetir palabras en una ronda.\nUna ronda termina si todos los jugadores" +
                                                " acuerdan no poder escribir más palabras.\nAl pasar 3 rondas el ganador será aquel" +
                                                " que haya acumulado una mayor cantidad de puntos\n" +
                                        "Regla experto: Al inicio de cada ronda se generará una letra de manera aleatoria" +
                                                "la cual no podrá ser utilizada para formar palabras.");
                                break;
                            // salir de las reglas
                            case 3:
                                break;
                            default:
                                System.out.println("\nOpción inválida\n");
                        }
                    }
                    break;
                // opción créditos
                case 3:
                System.out.println("\nCréditos:\nRealizado por:\nSuffo Peimbert\nFrancisco Oceguera");
                    break;
                // opción salir
                case 4:
                    break;
                default:
                    System.out.println("\nOpción inválida\n");
            }
        }
    }
}
