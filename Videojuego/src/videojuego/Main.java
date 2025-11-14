package videojuego;

import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {

        // declaracion variables
        String nombreJugador;
        boolean jugando = true;

        Scanner teclado = new Scanner(System.in);
        Musica audio = new Musica();

        audio.play("Videojuego/src/videojuego/audio/Batman.wav");

        
       
        
        System.out.println("Batalla en Gotham city");
        System.out.println("En una noche de Gotham city... mientras caminas por la calle escuchas gruñidos y gritos \n" +
        "de gente desesperada, vas a investigar por curiosidad, no es hasta que ahí te encuentras \n" +
        "a Batman haciendo su trabajo interrogando lo a quien puedes asimilar que son gánsters \n" +
        "de bajo nivel, no es hasta que Batman reconoce tu presencia y dice: \n" +
        "\n" +
        "B: ...Tu... has sido testigo de algo que no deberías de haber visto. Saben tu cara... Pero no tu nombre... ¿Quién eres?..." );
        
        System.out.print("introduce tu nombre: ");
        nombreJugador = teclado.nextLine();

        System.out.println("B: " +nombreJugador+ " Tu noche acaba de empeorar y espero \n" + 
        "que te puedas manejar por las calles. Por que hoy me vas a acompañar... \n" +
        "\n");

        System.out.println("Es así como tu historia empieza para resolver el misterio que rodea esta noche en Gotham. \n" +
        "\n");
        
        Jugador jugador1 = new Jugador(nombreJugador, 0, 0, 0);
        
        
        System.out.println(jugador1);

        
        while (jugando) {
            System.out.println("\n===== PANEL DE OPCIONES =====");
            System.out.println("1. Jugar");
            System.out.println("2. Configuración");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    audio.stop();
                    System.out.println("¡Iniciando partida!");
                    jugando = false;
                    break;
        
        
        
            }
        }
    }
}