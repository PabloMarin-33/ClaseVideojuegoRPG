package videojuego;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Jefefinal {

    private String nombreJefe;
    private int puntosSaludJefe, puntosAtaqueJefe;

    public Jefefinal(String nombreJefe, int puntosSaludJefe, int puntosAtaqueJefe) {
        this.nombreJefe = nombreJefe;
        this.puntosSaludJefe = puntosSaludJefe;
        this.puntosAtaqueJefe = puntosAtaqueJefe;
    }

    public String getNombreJefe() {
        return nombreJefe;
    }

    public int getPuntosSaludJefe() {
        return puntosSaludJefe;
    }

    public int getPuntosAtaqueJefe() {
        return puntosAtaqueJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }
    public void setPuntosAtaqueJefe(int puntosAtaqueJefe) {
        this.puntosAtaqueJefe = puntosAtaqueJefe;
    }

    public void setPuntosSaludJefe(int puntosSaludJefe) {
        this.puntosSaludJefe = puntosSaludJefe;
    }

    @Override
    public String toString() {
        return "\n       JEFE FINAL \n" +
                "────────────────────────────\n" +
                "» Nombre:     " + nombreJefe + "\n" +
                "» Salud:      " + puntosSaludJefe + "\n" +
                "» Fuerza:     " + puntosAtaqueJefe + "\n" +
                "────────────────────────────\n";
    }

    public void llamarJefe(Jugador jugador) {
        System.out.println("El jefe fue llamado por " + jugador.getNombre() + ", tienes " + jugador.getPuntosSalud() + " de vida." + "\n");

        if (jugador.getPuntosSalud() >= 50) {
            System.out.println("Ya no juegas por que tu nivel esta muy alto");
            return;

        }

        int minJefe = 0;
        int maxjefe = 0;
        
        if (jugador.getPuntosSalud() >= 25) {
            minJefe = 25;
            maxjefe = 50;

            setNombreJefe("Heath Ledger");
            System.out.println("!A aparecido el jefe " + getNombreJefe());
            
            
        } else if (jugador.getPuntosSalud() >= 15) {
            minJefe = 15;
            maxjefe = 25;
            setNombreJefe("Mark Hamill");
            System.out.println("!A aparecido el jefe " + getNombreJefe());

            
        } else if (jugador.getPuntosSalud() >= 5) {
            minJefe = 5;
            maxjefe = 15;

            setNombreJefe("Jared Leto");
            System.out.println("!A aparecido el jefe " + getNombreJefe());

        } else {
            System.out.println("Tienes un nivel muy bajo");
            return;
        }

        this.puntosSaludJefe = (int)(Math.random() * (maxjefe - minJefe + 1)) + minJefe;

        System.out.println("Salud del jefe: " + this.puntosSaludJefe);
        toString();

    }
}
