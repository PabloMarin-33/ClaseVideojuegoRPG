package videojuego;

/**
 *Declaracion de atributos
 * @author Pablo Marín Ortega
 */
public class Enemigo {
    
    private String nombre;
    private int puntosAtaque;

    /**
     *Declaración del objeto
     * @param nombre
     * @param puntosAtaque
     */
    public Enemigo(String nombre, int puntosAtaque) {
        this.nombre = nombre;
        this.puntosAtaque = 0;
    }

    /**
     *Función get que devuelve el String del nombre del enemigo
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Función get que devuelve el int de los puntos de ataque del enemigo
     * @return
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     *Función set que asigna el String del nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Función set que asigna los puntos de ataque del enemigo 
     * @param puntosAtaque
     */
    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    /**
     *Función toString para que se muestren los atributos del enemigo
     * @return
     */
    @Override
    public String toString() {
        return "Enemigo{" + "nombre= " + nombre + ", puntosAtaque= " + puntosAtaque + '}';
    }
   
    /**
     *Función que asigna un número aleatorio a los Puntos de Ataque
     */
    public void calcularFuerzaE(){
        int random = (int)(Math.random()*11);
        this.puntosAtaque = random;
    }

    /**
     *Funcion que asifna un nombre aleatorio del array en Main
     * @param nombre
     */
    public Enemigo(String nombre) {
        this.nombre = nombre;
        calcularFuerzaE(); 
    }

    /**
     *Funcion que elije un cantidad de dinero que el enemigo suelta cuando muere
     * @return
     */
    public int soltarDinero(){
        int dineroE = (int)(Math.random()*10);
        return dineroE;
    }
    
    
    
}
