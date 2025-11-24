package videojuego;

/**
 *Clase del Jugador
 * @author usuario
 */
public class Jugador {
    private String nombre;
    private int puntosSalud, puntosAtaque, batarangs;

    /**
     *Declaración de los atributos
     * @param nombre
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntosSalud = 20;
        this.puntosAtaque = 0;
        this.batarangs = 2;
    }

    /**
     *Función get que devuelve el String del nombre del jugador
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Función get que devuelve el int de los Puntos de Salud del jugador
     * @return
     */
    public int getPuntosSalud() {
        return puntosSalud;
    }

    /**
     *Función get que devuelve el int de los Puntos de Ataque del jugador
     * @return
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     *Función get que devuelve el int de los Puntos de Salud del jugador
     * @return
     */
    public int getBatarangs() {
        return batarangs;
    }

    /**
     *Función set que restablece el String nombre del jugador
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Función set que restablece el valor del int de los Puntos de Salud del jugador
     * @param puntosSalud
     */
    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    /**
     *
     * @param puntosAtaque
     */
    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    /**
     *
     * @param batarangs
     */
    public void setBatarangs(int batarangs) {
        this.batarangs = batarangs;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n PERFIL DEL JUGADOR \n" +
            "────────────────────────────\n" +
            "» Nombre:     " + nombre + "\n" +
            "» Salud:      " + puntosSalud + "\n" +
            "» Fuerza:     " + puntosAtaque + "\n" +
            "» Batarangs:  " + batarangs + "\n" +
            "────────────────────────────\n";
    }
    
    /**
     *
     */
    public void calcularFuerzaJ(){
        int Random = (int)(Math.random()*11);
        this.puntosAtaque = Random;
    }

    /**
     *
     * @param enemigo
     */
    public void morirPorEnemigo(Enemigo enemigo) {
        System.out.println("Has caído en Gotham...");

        switch(enemigo.getNombre()) {
            case "Enigma":
                System.out.println("Enigma: '¿De verdad pensaste que podrías con mis acertijos?'");
                break;
            case "El Pingüino":
                System.out.println("El Pingüino: 'La ciudad me pertenece, y tú no eres nadie...'");
                break;
            case "Poison Ivy":
                System.out.println("Poison Ivy: 'La naturaleza siempre gana sobre la debilidad humana.'");
                break;
            case "Bane":
                System.out.println("Bane: 'Gotham se fortalece mientras caes…'");
                break;
            default:
                System.out.println("Batman: 'No todos están hechos para estas calles...'");
        }

        System.out.println("GAME OVER");
        this.puntosSalud = 0; // asegurar que no quede negativo
    }
    
    /**
     *
     * @param mensaje
     */
    public static void mostrarMensaje(String mensaje) {
    try {
        System.out.println(mensaje);
        Thread.sleep(600); // podés ajustar el tiempo
        }  catch (InterruptedException e) {}
    }
}

