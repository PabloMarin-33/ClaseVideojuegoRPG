/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego;

/**
 *
 * @author usuario
 */
public class Jefefinal {
    
    private String nombreJefe;
    private int puntosSaludJefe, puntosAtaqueJefe;

    public Jefefinal(String nombreJefe , int puntosSaludJefe, int puntosAtaqueJefe) {
        this.nombreJefe = "Joker";
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

    public void setPuntosAtaqueJefe(int puntosAtaqueJefe) {
        this.puntosAtaqueJefe = puntosAtaqueJefe;
    }
    
    
    
    public void setPuntosSaludJefe(int puntosSaludJefe) {
        this.puntosSaludJefe = puntosSaludJefe;
    }
    
    @Override
    public String toString() {
        return "\n JEFE FINAL \n" +
            "────────────────────────────\n" +
            "» Nombre:     " + nombreJefe + "\n" +
            "» Salud:      " + puntosSaludJefe + "\n" +
            "» Fuerza:     " + puntosAtaqueJefe + "\n" +
            "────────────────────────────\n";
    }
    
    public void llamarJefe(){
                 
    
    }
    
}
