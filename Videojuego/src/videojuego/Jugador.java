package videojuego;

public class Jugador {
    private String nombre;
    private int puntosSalud, puntosAtaque, batarangs;

    public Jugador(String nombre, int puntosSalud, int puntosAtaque, int batarangs) {
        this.nombre = nombre;
        this.puntosSalud = 20;
        this.puntosAtaque = 0;
        this.batarangs = 2;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getBatarangs() {
        return batarangs;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public void setBatarangs(int batarangs) {
        this.batarangs = batarangs;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre= " + nombre + ", puntosSalud= " + puntosSalud + ", puntosAtaque= " + puntosAtaque + ", batarangs= " + batarangs + '}';
    }
    
       public void calcularFuerzaJ(){
        int Random = (int)(Math.random()*10);
        this.puntosAtaque = Random;
    }
    
    
}
