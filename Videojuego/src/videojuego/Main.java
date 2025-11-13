package videojuego;

import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // declaracion variables
        String nombreJugador;
        
        
        System.out.println("Batalla en Gotham city");
        System.out.println("En una noche de Gotham city... mientras caminas por la calle escuchas gruñidos y gritos");
        System.out.println("de gente desesperada, vas a investigar por curiosidad, no es hasta que ahí te encuentras");
        System.out.println("a Batman haciendo su trabajo interrogando lo a quien puedes asimilar que son gánsters");
        System.out.println("de bajo nivel, no es hasta que Batman reconoce tu presencia y dice:\n" +
        "\n" +
        "B: ...Tu... has sido testigo de algo que no deberías de haber visto. Saben tu cara... Pero no tu nombre... ¿Quién eres?...");
        
        System.out.println("introduce tu nombre ");
        nombreJugador = teclado.nextLine();
        
        Jugador jugador1 = new Jugador(nombreJugador, 0, 0, 0);
        
        
        System.out.println(jugador1);
        
        
        
    }
}