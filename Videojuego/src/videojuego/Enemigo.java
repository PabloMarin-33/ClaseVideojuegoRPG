package videojuego;

public class Enemigo {
    
    private String nombre;
    private int puntosAtaque;

    public Enemigo(String nombre, int puntosAtaque) {
        this.nombre = nombre;
        this.puntosAtaque = puntosAtaque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    @Override
    public String toString() {
        return "Enemigo{" + "nombre= " + nombre + ", puntosAtaque= " + puntosAtaque + '}';
    }
    
    
    
}
