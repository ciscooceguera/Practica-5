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
                    Integer[] numJugadores = {2, 3, 4};
                    Integer numSeleccionado = (Integer) JOptionPane.showInputDialog(null,
                            "Ingresa número de jugadores",
                            "Número de jugadores",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            numJugadores,
                            numJugadores[0]);
                    // solicito modalidad
                    String[] modalidades = {"Regular", "Experto"};
                    String modalidadSeleccionada = (String) JOptionPane.showInputDialog(null,
                            "Ingresa el modo de juego",
                            "Selección de dificultad",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            modalidades,
                            modalidades[0]);
                    break;
                // opción reglas
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "Realizado por:\nSuffo Peimbert\nFrancisco Oceguera",
                            "Reglas",
                            JOptionPane.INFORMATION_MESSAGE);
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
