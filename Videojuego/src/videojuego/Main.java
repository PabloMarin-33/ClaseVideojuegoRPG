package videojuego;

import java.util.Scanner;

public class Main {

    public static void mensaje(){

    System.out.println("\n===== PANEL DE OPCIONES =====");
    System.out.println("1. Combatir");
    System.out.println("2. Tienda");
    System.out.println("3. Mis estadisticas");
    System.out.println("4. Salir del juego");
    System.out.print("Elige una opción: ");
    
}
   
    public static void main(String[] args) {

        // declaracion variables
        String nombreJugador;
        boolean jugando = true;
        String [] listaE = {"Enigma", "El pinguino", "Posion Ivy", "Bane"};
        int opcionFuerza;

        Scanner teclado = new Scanner(System.in);
        Musica audio = new Musica();

        audio.play("Videojuego/src/videojuego/audio/Batman.wav");

        
       
        
        System.out.println("\n ====Batalla en Gotham city==== \n");
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

        System.out.println("____________________                              ____________________\r\n" + //
                        "`-._:  .:'   `:::  .:\\           |\\__/|           /::  .:'   `:::  .:.-'\r\n" + //
                        "    \\      :          \\          |:   |          /         :       /    \r\n" + //
                        "     \\     ::    .     `-_______/ ::   \\_______-'   .      ::   . /      \r\n" + //
                        "      |  :   :: ::'  :   :: ::'  :   :: ::'      :: ::'  :   :: :|       \r\n" + //
                        "      |     ;::         ;::         ;::         ;::         ;::  |       \r\n" + //
                        "      |  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:|       \r\n" + //
                        "      /     :           :           :           :           :    \\       \r\n" + //
                        "     /______::_____     ::    .     ::    .     ::   _____._::____\\      \r\n" + //
                        "                   `----._:: ::'  :   :: ::'  _.----'                    \r\n" + //
                        "                          `--.       ;::  .--'                           \r\n" + //
                        "                              `-. .:'  .-'                               \r\n" + //
                        "                                 \\    /                            \r\n" + //
                        "                                  \\  /                                   \r\n" + //
                        "                                   \\/ ");
        
        Jugador jugador1 = new Jugador(nombreJugador, 0, 0, 0);
        
        jugador1.calcularFuerzaJ();
        System.out.println("Tu fuerza inicial es: " +jugador1.getPuntosAtaque());
        
        do{
        System.out.println("¿Te gustaría cambiar de fuerza?");
        System.out.println("Recuerda que tienes solo dos batarangs(dinero) por usar");
        System.out.println("Opcion 1 es reasignar tu fuerza actual por un batarang");
        System.out.println("Opcion 2 significa que estás listo para adentrarte en Gotham");
        
        opcionFuerza = teclado.nextInt();
        if (opcionFuerza == 1  && jugador1.getBatarangs() <= 0 ){
        jugador1.calcularFuerzaJ();
        System.out.println("Tu fuerza inicial es: " +jugador1.getPuntosAtaque());
        jugador1.setBatarangs(-1);
        }
        else if(opcionFuerza == 2){
            System.out.println("Preparate para la noche...");
            jugando = true;

        }
        else {
            System.out.println("Esa opcion no existe");
        }
    }while(opcionFuerza!=2);

        while (jugando) {
            
            mensaje();

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    audio.stop();
                    System.out.println("!Ha combatir¡");
                    break;
                case 2:
                    System.out.println("!Ha gastar dinero¡");
                    break;
                case 3:
                    System.out.println("Tus estadisticas");
                    System.out.println(jugador1);
                    break;
                case 4:
                    System.out.println("!Adios, vuelva pronto¡");
                    jugando = false;
                    break;
                default:
                    System.out.println("uff.. por ahi no, siga las intrucciones");
        
        
        
            }
        }

    }

}