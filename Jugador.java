public class Jugador {
    int puntaje;

    public Jugador() {
        puntaje = 0;
    }

    public int obtenerPuntaje(){
        return puntaje;
    }

    public void cambiarPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
}
