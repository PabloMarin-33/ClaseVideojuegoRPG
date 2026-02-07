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
    

    int bonoMinimo = 0, bonoMaximo = 0;
    /**
     * Función que calcula la fuerza del enemigo escalada según el nivel del jugador
     * A mayor progreso del jugador, los enemigos se vuelven más fuertes
     * @param jugador El jugador actual para calcular el escalado
     */
    public void calcularFuerzaEscalada(Jugador jugador) {
        // Calcular nivel del jugador (salud + ataque)
        int nivelJugador = jugador.getPuntosSalud() + jugador.getPuntosAtaque();
        
        // Determinar rango base y bono según nivel del jugador
        int rangoBase = 10; // Rango aleatorio base (0-10)

        if (nivelJugador >= 50) {
            // Jugador muy fuerte → Enemigos nivel 4
            bonoMinimo = 7;
            bonoMaximo = 15;
        } else if (nivelJugador >= 35) {
            // Jugador fuerte → Enemigos nivel 3
            bonoMinimo = 6;
            bonoMaximo = 10;
        } else if (nivelJugador >= 25) {
            // Jugador medio → Enemigos nivel 2
            bonoMinimo = 2;
            bonoMaximo = 5;
        } else {
            // Jugador inicial → Enemigos nivel 1 (sin bono)
            bonoMinimo = 0;
            bonoMaximo = 0;
        }
        
        // Calcular fuerza base aleatoria (0-10)
        int fuerzaBase = (int)(Math.random() * (rangoBase + 1));
        
        
        this.puntosAtaque = fuerzaBase + soltarDinero();
    }

    /**
     *Funcion que elije un cantidad de dinero que el enemigo suelta cuando muere
     * @return
     */
    public int soltarDinero(){
        // Añadir bono aleatorio según nivel
        int bono = (int)(Math.random() * (bonoMaximo - bonoMinimo + 1)) + bonoMinimo;
        return bono;
    }

    /**
     *Funcion que elige un nombre aleatorio del array en Main
     * @param nombre
     */
    public Enemigo(String nombre) {
        this.nombre = nombre;
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
}
