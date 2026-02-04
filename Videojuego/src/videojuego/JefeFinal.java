package videojuego;

/**
 *Declaración de atributos
 */
public class JefeFinal {

    private String nombreJefe;
    private int puntosSaludJefe, puntosAtaqueJefe;

    /**
     *Constructor con parámetros para el JefeFinal
     * @param nombreJefe
     * @param puntosSaludJefe
     * @param puntosAtaqueJefe
     */
    public JefeFinal(String nombreJefe, int puntosSaludJefe, int puntosAtaqueJefe) {
        this.nombreJefe = nombreJefe;
        this.puntosSaludJefe = puntosSaludJefe;
        this.puntosAtaqueJefe = puntosAtaqueJefe;
    }

    /**
     *Función get que devuelve el String del nombre del jefe
     * @return
     */
    public String getNombreJefe() {
        return nombreJefe;
    }

    /**
     *Función get que devuelve int de los Puntos de Salud del jefe
     * @return
     */
    public int getPuntosSaludJefe() {
        return puntosSaludJefe;
    }

    /**
     *Función get que devuelve int de los Puntos de Ataque del jefe
     * @return
     */
    public int getPuntosAtaqueJefe() {
        return puntosAtaqueJefe;
    }

    /**
     *Función set que reasigna el String del nobre del jefe
     * @param nombreJefe
     */
    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    /**
     *Función set que reasigna int de los Puntos de Ataque del jefe
     * @param puntosAtaqueJefe
     */
    public void setPuntosAtaqueJefe(int puntosAtaqueJefe) {
        this.puntosAtaqueJefe = puntosAtaqueJefe;
    }

    /**
     *Función set que reasigna int de los Puntos de Salud del jefe
     * @param puntosSaludJefe
     */
    public void setPuntosSaludJefe(int puntosSaludJefe) {
        this.puntosSaludJefe = puntosSaludJefe;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\n       JEFE FINAL \n" +
                "────────────────────────────\n" +
                "» Nombre:     " + nombreJefe + "\n" +
                "» Salud:      " + puntosSaludJefe + "\n" +
                "» Fuerza:     " + puntosAtaqueJefe + "\n" +
                "────────────────────────────\n";
    }

    /**
     *Función toString que devuelve todos los parámetros de los atributos del Jefe
     * @param jugador
     */
    public void llamarJefe(Jugador jugador) {
        int nivelJugador = jugador.getPuntosSalud() + jugador.getPuntosAtaque();
        int minJefe = 0, maxjefe = 0;
        
        System.out.println("\nEl jefe fue llamado por " + jugador.getNombre());
        System.out.println("Tienes: " + jugador.getPuntosSalud() + " de vida.");
        System.out.println("Con este ataque: " + jugador.getPuntosAtaque() + "\n");
        
        /**
     *Serie de condicionales que sirve para introducir 3 tipos de jefes que, varían 
     * dependiendo de los Puntos de Salud del Jugador y que la vida del Jefe se adapte a la situación del jugador
     */
        if (nivelJugador >= 60) {
            System.out.println("Ya no juegas por que tu nivel esta muy alto");
            return;

        } else if (nivelJugador >= 40) {
            minJefe = 25;
            maxjefe = 50;

            
            setNombreJefe("Heath Ledger");
            System.out.println("!A aparecido el jefe " + getNombreJefe()+ " - El Joker Definitivo!");
            
            
        } else if (nivelJugador >= 25) {
            minJefe = 15;
            maxjefe = 25;

            setNombreJefe("Mark Hamill");
            System.out.println("!A aparecido el jefe " + getNombreJefe()+ " - El Joker Clásico!");

            
        } else if (nivelJugador >= 10) {
            minJefe = 5;
            maxjefe = 15;

            setNombreJefe("Joaquin Phoenix");
            System.out.println("!A aparecido el jefe " + getNombreJefe() + " - El Joker Moderno!");

        } else {
            System.out.println("Tienes un nivel muy bajo para enfrentarte a un jefe");
            return;
        }

        this.puntosSaludJefe = (int)(Math.random() * (maxjefe - minJefe + 1)) + minJefe;// Calculo de la vida del Jefe
        this.puntosAtaqueJefe = (int)(Math.random() * (maxjefe - minJefe + 1)) + minJefe;

        System.out.println(this.toString());
    
    }

    /**
    * Aqui se espera 11 segundos para que suene el sonido
    * de la presentacion dela jefe Si la ruta del archivo
    * es incorrecta o no encotrada el progarama te muestra
    * el mensaje pero sigue con el juego pero sin musica en
    * esta parte
    */
    public static void risaPrecentacion() {
        try {
            Thread.sleep(11400); // Se detendra estos segundos el programa hasta que pase el sonido de
                                                 // arriba
        } catch (InterruptedException e) {
                System.out.println("Error en la espera del jefe: " + e.getMessage());
                Thread.currentThread().interrupt();
        }
    }

    public static void finalCombateJefe() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Error en la espera del jefe: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

    }

}

