import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opc = 0;
        while (opc!= 3) {
            // pregunto que acció quiere realizar el usuario
            Object[] botones = {"Jugar","Reglas","Créditos","Salir"};
            opc = JOptionPane.showOptionDialog(null,
                    "Selecciona la opción",
                    "El Mago de las Palabras",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    botones,
                    botones[0]);
            System.out.println(opc);
            // switch de la opción seleccionada
            switch (opc){
                // opción jugar
                case 0:
                    // solicito # jugadores
                    Object[] botonesNumJugadores = {2, 3, 4};
                    Integer numSeleccionado = (Integer) JOptionPane.showOptionDialog(null,
                            "Ingresa número de jugadores",
                            "Número de jugadores",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            botonesNumJugadores,
                            botonesNumJugadores[0]);
                    // solicito modalidad
                    Object[] botonesModalidades = {"Regular", "Experto"};
                    int modalidadSeleccionada = (Integer) JOptionPane.showOptionDialog(null,
                            "Ingresa el modo de juego",
                            "Selección de dificultad",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            botonesModalidades,
                            botonesModalidades[0]);
                    break;
                // opción reglas
                case 1:
                    int reglasOpc = 0;
                    while(reglasOpc!=2) {
                        Object[] botonesReglas = {"Regular", "Experto", "Salir"};
                        reglasOpc = JOptionPane.showOptionDialog(null,
                                "Selecciona para ver las reglas según la modalidad",
                                "Reglas",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                botonesReglas,
                                botonesReglas[0]);
                        switch (reglasOpc) {
                            // ver reglas de modalidad regular
                            case 0:
                                JOptionPane.showMessageDialog(null,
                                        "Recibe un conjunto de 10 letras y forma todas las palabras válidas" +
                                                " posibles con estas para poder puntuar.\n" +
                                        "Al formar una palabra válida, recibe 5 puntos por c/d vocal y 3 por c/d consonante.\n" +
                                        "Si el jugador no forma una palabra válida, entonces pierde 5 puntos.\n" +
                                                "No podrás repetir palabras en una ronda.\nUna ronda termina si todos los jugadores" +
                                                " acuerdan no poder escribir más palabras.\nAl pasar 3 rondas el ganador será aquel" +
                                                " que haya acumulado una mayor cantidad de puntos",
                                        "Modalidad Regular",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            // ver reglas de modalidad experto
                            case 1:
                                JOptionPane.showMessageDialog(null,
                                        "Recibe un conjunto de 10 letras y forma todas las palabras válidas" +
                                                " posibles con estas para poder puntuar.\n" +
                                                "Al formar una palabra válida, recibe 5 puntos por c/d vocal y 3 por c/d consonante.\n" +
                                                "Si el jugador no forma una palabra válida, entonces pierde 5 puntos.\n" +
                                                "No podrás repetir palabras en una ronda.\nUna ronda termina si todos los jugadores" +
                                                " acuerdan no poder escribir más palabras.\nAl pasar 3 rondas el ganador será aquel" +
                                                " que haya acumulado una mayor cantidad de puntos\n" +
                                        "Regla experto: Al inicio de cada ronda se generará una letra de manera aleatoria" +
                                                "la cual no podrá ser utilizada para formar palabras.",
                                        "Modalidad Experto",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            // salir de las reglas
                            case 2:
                                break;
                        }
                    }
                    break;
                // opción créditos
                case 2:
                JOptionPane.showMessageDialog(null,
                        "Realizado por:\nSuffo Peimbert\nFrancisco Oceguera",
                        "Créditos",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                // opción salir
                case 3:
                    break;
            }
        }
    }
}
