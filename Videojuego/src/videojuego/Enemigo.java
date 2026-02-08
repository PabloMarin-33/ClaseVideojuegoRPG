package videojuego;

/**
 * Declaracion de atributos
 * 
 */
public class Enemigo {

    private String nombre;
    private int puntosAtaque;
    private EnumVillanos tipVillanos;

    private int dineroMaximo = 0, dineroMinimo = 0;

    /**
     * Constructor con parámetros para el Enemigo
     * 
     * @param nombre
     * @param puntosAtaque
     */
    public Enemigo(String nombre, int puntosAtaque) {
        this.nombre = nombre;
        this.puntosAtaque = puntosAtaque;
        asignarTipoVillano();
    }

    /**
     * Función get que devuelve el String del nombre del enemigo
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Función get que devuelve el int de los puntos de ataque del enemigo
     * 
     * @return
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     * Función set que asigna el String del nombre
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Función set que asigna los puntos de ataque del enemigo
     * 
     * @param puntosAtaque
     */
    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    /**
     * Función toString para que se muestren los atributos del enemigo
     * 
     * @return
     */
    @Override
    public String toString() {
        return "Enemigo{" + "nombre= " + nombre + ", puntosAtaque= " + puntosAtaque + '}';
    }

    /**
     * Función EQUILIBRADA que calcula la fuerza del enemigo proporcional al jugador
     * Sistema balanceado: 70% mismo nivel, 20% más fácil, 10% más difícil
     */
    public void calcularFuerzaEscalada(Jugador jugador) {
        int fuerzaJugador = jugador.getPuntosAtaque();
        
        // Determinar el nivel base del enemigo según la fuerza del jugador
        int nivelBase = determinarNivelPorFuerza(fuerzaJugador);
        
        // Sistema de variación equilibrado
        int nivelFinal = calcularNivelConVariacion(nivelBase);
        
        // Configurar estadísticas según el nivel final
        configuracionDineroPorNivel(nivelFinal);
        
        // Calcular ataque del enemigo de forma equilibrada
        // El enemigo tendrá entre 70%-120% de la fuerza del jugador
        int rangoMin = (int)(fuerzaJugador * 0.7);
        int rangoMax = (int)(fuerzaJugador * 1.2);
        
        // Asegurar mínimos y máximos razonables
        if (rangoMin < 1) rangoMin = 1;
        if (rangoMax < rangoMin + 3) rangoMax = rangoMin + 3;
        
        // Generar ataque dentro del rango equilibrado
        this.puntosAtaque = (int)(Math.random() * (rangoMax - rangoMin + 1)) + rangoMin;
    }

    /**
     * Calcula el nivel final con variación equilibrada
     * 70% de probabilidad: mismo nivel
     * 20% de probabilidad: -1 nivel (más fácil)
     * 10% de probabilidad: +1 nivel (más difícil)
     */
    private int calcularNivelConVariacion(int nivelBase) {
        int probabilidad = (int)(Math.random() * 100); // 0-99
        
        int nivelFinal;
        if (probabilidad < 70) {
            // 70% - Mismo nivel
            nivelFinal = nivelBase;
        } else if (probabilidad < 90) {
            // 20% - Nivel más fácil
            nivelFinal = nivelBase - 1;
        } else {
            // 10% - Nivel más difícil
            nivelFinal = nivelBase + 1;
        }
        
        // Limitar entre nivel 1 y 4
        if (nivelFinal < 1) nivelFinal = 1;
        if (nivelFinal > 4) nivelFinal = 4;
        
        return nivelFinal;
    }

    /**
     * Determina el nivel del enemigo según la fuerza del jugador
     * Sistema balanceado con rangos ajustados
     */
    private int determinarNivelPorFuerza(int fuerzaJugador) {
        if (fuerzaJugador >= 25) {
            return 4; // Nivel 4 - Jugador muy fuerte
        } else if (fuerzaJugador >= 16) {
            return 3; // Nivel 3 - Jugador fuerte
        } else if (fuerzaJugador >= 8) {
            return 2; // Nivel 2 - Jugador medio
        } else {
            return 1; // Nivel 1 - Jugador débil
        }
    }

    /**
     * Configura las estadísticas BALANCEADAS del enemigo según su nivel
     */
    private void configuracionDineroPorNivel(int nivel) {
        switch (nivel) {
            case 4:
                // Enemigos NIVEL 4 (25+ fuerza jugador)
                dineroMinimo = 12;
                dineroMaximo = 20;
                break;
            case 3:
                // Enemigos NIVEL 3 (16-24 fuerza jugador)
                dineroMinimo = 8;
                dineroMaximo = 15;
                break;
            case 2:
                // Enemigos NIVEL 2 (8-15 fuerza jugador)
                dineroMinimo = 5;
                dineroMaximo = 10;
                break;
            case 1:
            default:
                // Enemigos NIVEL 1 (0-7 fuerza jugador)
                dineroMinimo = 2;
                dineroMaximo = 6;
                break;
        }
    }


/**
 * Función que calcula el dinero que suelta el enemigo al morir
 * @return cantidad de dinero/batarangs
 */
    public int soltarDinero() {
    int dinero = (int)(Math.random() * (dineroMaximo - dineroMinimo + 1)) + dineroMinimo;
    return dinero;
    }

    /**
     * Funcion que elige un nombre aleatorio del array en Main
     * 
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
     * Funcion que muestra las múltiples pantallas de GAME OVER
     * 
     * @param enemigo
     */
    public void morirPorEnemigo(Jugador jugador) {
        System.out.println("Has caído en Gotham...");

        switch (this.tipVillanos) {
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
