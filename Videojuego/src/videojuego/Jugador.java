package videojuego;

public class Jugador {
    private String nombre;
    private int puntosSalud, puntosAtaque, batarangs;

    public Jugador(String nombre) {
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
        return "\n PERFIL DEL JUGADOR \n" +
            "────────────────────────────\n" +
            "» Nombre:     " + nombre + "\n" +
            "» Salud:      " + puntosSalud + "\n" +
            "» Fuerza:     " + puntosAtaque + "\n" +
            "» Batarangs:  " + batarangs + "\n" +
            "────────────────────────────\n";
    }
    
    public void calcularFuerzaJ(){
        int Random = (int)(Math.random()*10);
        this.puntosAtaque = Random;
    }

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
}

