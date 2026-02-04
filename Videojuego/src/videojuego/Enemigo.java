package videojuego;


/**
 *Declaracion de atributos
 * 
 */
public class Enemigo {
    
    private String nombre;
    private int puntosAtaque;
    private EnumVillanos tipVillanos;

    /**
     *Constructor con parámetros para el Enemigo
     * @param nombre
     * @param puntosAtaque
     */
    public Enemigo(String nombre, int puntosAtaque) {
        this.nombre = nombre;
        this.puntosAtaque = puntosAtaque;
        asignarTipoVillano();
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
     *Funcion que elige un nombre aleatorio del array en Main
     * @param nombre
     */
    public Enemigo(String nombre) {
        this.nombre = nombre;
        calcularFuerzaE();
        asignarTipoVillano(); 
    }
    
    /**
     * Funcion que asigna el tipoVillano según el nombre    
     */
    private void asignarTipoVillano() {
        if (this.nombre.equalsIgnoreCase("Enigma")) {
            this.tipVillanos = EnumVillanos.Enigma;
        } else if (this.nombre.equalsIgnoreCase("El pinguino")) {
            this.tipVillanos = EnumVillanos.ElPinguino;
        } else if (this.nombre.equalsIgnoreCase("Posion Ivy")) {
            this.tipVillanos = EnumVillanos.PoisonIvy;
        } else if (this.nombre.equalsIgnoreCase("Bane")) {
            this.tipVillanos = EnumVillanos.Bane;
        } else {
            this.tipVillanos = EnumVillanos.Batman; // Por defecto
        }
    }    

    /**
     *Funcion que muestra las múltiples pantallas de GAME OVER
     * @param enemigo
     */
    public void morirPorEnemigo(Jugador jugador) {
        System.out.println("Has caído en Gotham...");

        switch(this.tipVillanos) {
            case Enigma:
                System.out.println("Enigma: '¿De verdad pensaste que podrías con mis acertijos?'");
                break;
            case ElPinguino:
                System.out.println("El Pingüino: 'La ciudad me pertenece, y tú no eres nadie...'");
                break;
            case PoisonIvy:
                System.out.println("Poison Ivy: 'La naturaleza siempre gana sobre la debilidad humana.'");
                break;
            case Bane:
                System.out.println("Bane: 'Gotham se fortalece mientras caes…'");
                break;
            default:
                System.out.println("Batman: 'No todos están hechos para estas calles...'");
        }

        System.out.println("GAME OVER");
        jugador.setPuntosSalud(0); // asegurar que no quede la salud del jugador en un número negativo negativo
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
