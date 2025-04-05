public class Jugador {
    // atributos
    int puntaje;
    // constructor
    public Jugador() {
        // inicializa puntaje en 0
        puntaje = 0;
    }
    // retorna el puntaje del jugador
    public int obtenerPuntaje(){
        return puntaje;
    }
    // acumula el puntaje del jugador
    public void cambiarPuntaje(int puntaje){
        this.puntaje += puntaje;
    }
}
