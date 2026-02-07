package videojuego;

/**
 *Declaración de atributos
 */
public class JefeFinal {

    private String nombreJefe;
    private int puntosSaludJefe, puntosAtaqueJefe;
    private int nivelJefe;

    /**
     *Constructor con parámetros para el JefeFinal
     * @param nombreJefe
     * @param puntosSaludJefe
     * @param puntosAtaqueJefe
     */
    public JefeFinal(String nombreJefe, int puntosSaludJefe, int puntosAtaqueJefe, int nivelJefe) {
        this.nombreJefe = nombreJefe;
        this.puntosSaludJefe = puntosSaludJefe;
        this.puntosAtaqueJefe = puntosAtaqueJefe;
        this.nivelJefe = 1;
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
     *Función get que devuelve el nivel actual del jefe
     * @return
     */
    public int nivelJefe() {
        return nivelJefe;
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
     *Función que sube el nivel del jefe
     */
    public void subirNivel() {
        this.nivelJefe++;
        // Incremento aleatorio entre 1 y 5 puntos
        int incrementoSalud = (int)(Math.random() * 5) + 1;
        int incrementoAtaque = (int)(Math.random() * 5) + 1;
        
        this.puntosSaludJefe += incrementoSalud;
        this.puntosAtaqueJefe += incrementoAtaque;
        
        System.out.println("\n¡ EL JOKER ES MAS PODEROSO! ⚠");
        System.out.println("Nivel: " + this.nivelJefe);
        System.out.println("Salud aumentada en +" + incrementoSalud + " (Total: " + this.puntosSaludJefe + ")");
        System.out.println("Ataque aumentado en +" + incrementoAtaque + " (Total: " + this.puntosAtaqueJefe + ")");
    }

    /**
     *Función que determina si el jefe usa su ataque especial (25% probabilidad)
     * @return true si usa ataque especial, false si no
     */
    public boolean usarAtaqueEspecial() {
        int probabilidad = (int)(Math.random() * 100) + 1; // Número entre 1 y 100
        return probabilidad <= 25; // 25% de probabilidad
    }

    /**
     * Función que calcula el daño del ataque especial según el tipo de Joker
     * Cada Joker tiene su ataque especial único
     * @return daño del ataque especial
     */
    public int calcularAtaqueEspecial() {
        int dañoEspecial = this.puntosAtaqueJefe;
        
        switch(this.nombreJefe) {
            case "Joaquin Phoenix":
                // ATAQUE ESPECIAL: "Danza de la Locura"
                // Incremento moderado x1.5 (redondeado)
                System.out.println("\n¡JOAQUIN PHOENIX USA: 'DANZA DE LA LOCURA'!");
                System.out.println("'¿Sabes lo que es tener un mal día? ¡Déjame mostrarte!'");
                System.out.println("¡El Joker se mueve erráticamente aumentando su daño en 50%!");
                dañoEspecial = (int)(this.puntosAtaqueJefe * 1.5);
                break;
                
            case "Mark Hamill":
                // ATAQUE ESPECIAL: "Gas de la Risa"
                // Duplica el daño
                System.out.println("\n¡MARK HAMILL USA: 'GAS DE LA RISA'!");
                System.out.println("'JAJAJA! ¡Todos ríen al final!'");
                System.out.println("¡Una nube tóxica te envuelve duplicando el daño!");
                dañoEspecial = this.puntosAtaqueJefe * 2;
                break;
                
            case "Heath Ledger":
                // ATAQUE ESPECIAL: "Caos Absoluto"
                // Triplica el daño - el más peligroso
                System.out.println("\n¡HEATH LEDGER USA: 'CAOS ABSOLUTO'!");
                System.out.println("'¿Por qué tan serio? ¡Vamos a poner una sonrisa en esa cara!'");
                System.out.println("¡Explosiones y cuchillas por doquier! ¡DAÑO TRIPLICADO!");
                dañoEspecial = this.puntosAtaqueJefe * 3;
                break;
                
            default:
                // Por si acaso, ataque genérico
                System.out.println("\n ¡EL JOKER USA SU ATAQUE ESPECIAL!");
                dañoEspecial = this.puntosAtaqueJefe * 2;
                break;
        }
        
        return dañoEspecial;
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
                "» Nivel:      " + nivelJefe + "\n" +
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
            maxjefe = 45;

            setNombreJefe("Heath Ledger");
            System.out.println("!A aparecido el jefe " + getNombreJefe()+ " - El Joker Definitivo!");
            
            
        } else if (nivelJugador >= 25) {
            minJefe = 15;
            maxjefe = 20;

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

            // Solo recalcular estadísticas si es la primera vez (nivel 1)
            if (this.nivelJefe == 1) {
                this.puntosSaludJefe = (int)(Math.random() * (maxjefe - minJefe + 1)) + minJefe;// Calculo de la vida del Jefe
                this.puntosAtaqueJefe = (int)(Math.random() * (maxjefe - minJefe + 1)) + minJefe;
            }
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

