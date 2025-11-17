package videojuego;

import java.util.Scanner;

public class Main {

    public static void mensaje() {

        System.out.println("\n===== PANEL DE OPCIONES =====");
        System.out.println("1. Combatir");
        System.out.println("2. Tienda");
        System.out.println("3. Mis estadisticas");
        System.out.println("4. Salir del juego \n");
        System.out.print("Elige una opción: ");

    }

    public static void mensaje2() {

        System.out.println("¿Te gustaría cambiar de fuerza? \n");
        System.out.println("Recuerda que tienes solo dos batarangs(dinero) por usar");
        System.out.println("Opcion 1 es reasignar tu fuerza actual por un batarang");
        System.out.println("Opcion 2 significa que estás listo para adentrarte en Gotham");
    }

    public static void main(String[] args) {

        // declaracion variables
        String nombreJugador, nombreEnemigo;
        boolean jugando = true;
        String[] listaE = { "Enigma", "El pinguino", "Posion Ivy", "Bane" };
        int opcionFuerza = 0, indice, botin, damage;

        Scanner teclado = new Scanner(System.in);
        Musica audio = new Musica();

        audio.play("Videojuego/src/videojuego/audio/Batman.wav");

        System.out.println("\n ====Batalla en Gotham city==== \n");
        System.out.println("En una noche de Gotham city... mientras caminas por la calle escuchas gruñidos y gritos \n"
                +
                "de gente desesperada, vas a investigar por curiosidad, no es hasta que ahí te encuentras \n" +
                "a Batman haciendo su trabajo interrogando lo a quien puedes asimilar que son gánsters \n" +
                "de bajo nivel, no es hasta que Batman reconoce tu presencia y dice: \n" +
                "\n" +
                "B: ...Tu... has sido testigo de algo que no deberías de haber visto. Saben tu cara... Pero no tu nombre... ¿Quién eres?...");

        System.out.print("introduce tu nombre: ");
        nombreJugador = teclado.nextLine();

        System.out.println("B: " + nombreJugador + " Tu noche acaba de empeorar y espero \n" +
                "que te puedas manejar por las calles. Por que hoy me vas a acompañar... \n" +
                "\n");

        System.out.println(
                "Es así como tu historia empieza para resolver el misterio que rodea esta noche en Gotham. \n" +
                        "\n");

        System.out.println("_____________________                              _____________________\r\n" + //
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
                "                                 \\    /                                  \r\n" + //
                "                                  \\  /                                   \r\n" + //
                "                                   \\/ ");

        Jugador jugador1 = new Jugador(nombreJugador);

        jugador1.calcularFuerzaJ();
        System.out.println("Tu fuerza inicial es: " + jugador1.getPuntosAtaque()+ "\n");

        do {

            mensaje2();

            opcionFuerza = teclado.nextInt();

            switch (opcionFuerza) {
                case 1:
                    if (jugador1.getBatarangs() > 0) {

                        jugador1.setBatarangs(jugador1.getBatarangs() - 1);
                        jugador1.calcularFuerzaJ();

                        System.out.println("\n Has reasignado tu fuerza por 1 batarang.");
                        System.out.println("Tu nueva fuerza es: " + jugador1.getPuntosAtaque());
                        System.out.println("Oro restante: " + jugador1.getBatarangs() + "\n");
                    } else {
                        System.out.println("\n No tienes batarangs suficientes para cambiar tu fuerza.\n");
                    }
                    break;
                case 2:
                    System.out.println("\nPerfecto, Preparate para la noche...\n");
                    break;
                default:
                    System.out.println("\n Opción inválida, bro, elige bien.\n");
                    break;
            }
        } while (opcionFuerza != 2);

        while (jugando) {

            mensaje();

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("!Ha combatir¡");

                    indice = (int) (Math.random() * listaE.length);
                    nombreEnemigo = listaE[indice];

                    Enemigo enemigo = new Enemigo(nombreEnemigo);

                    enemigo.calcularFuerzaE();

                    System.out.println(" Un enemigo aparece: " + enemigo.getNombre());
                    System.out.println(" Su fuerza es: " + enemigo.getPuntosAtaque());
                    System.out.println(" Tu fuerza es: " + jugador1.getPuntosAtaque());
                    System.out.println("─────────────────────────────");

                    if (jugador1.getPuntosAtaque() >= enemigo.getPuntosAtaque()) {

                        // Gana combate
                        botin = enemigo.soltarDinero();
                        jugador1.setBatarangs(jugador1.getBatarangs() + botin);

                        System.out.println("¡GANASTE EL COMBATE!");
                        System.out.println("Has derrotado a " + enemigo.getNombre());
                        System.out.println("Recolectas " + botin + " batarangs.");
                        System.out.println("Ahora tienes: " + jugador1.getBatarangs() + " batarangs.\n");

                    } else {

                        // Pierde combate
                        damage = enemigo.getPuntosAtaque() - jugador1.getPuntosAtaque();
                        jugador1.setPuntosSalud(Math.max(0, jugador1.getPuntosSalud() - damage));

                        System.out.println(" ¡PERDISTE LA PELEA!");
                        System.out.println(enemigo.getNombre() + " te superó por " + damage + " puntos.");
                        System.out.println("Pierdes " + damage + " puntos de salud.");
                        System.out.println("Salud restante: " + jugador1.getPuntosSalud() + "\n");

                        // ¿Murió?
                        if (jugador1.getPuntosSalud() <= 0) {
                            jugador1.morirPorEnemigo(enemigo);
                            jugando = false;
                        }
                    }
                    break;
                case 2:
                    audio.stop();
                    Musica audio1 = new Musica();
                    audio.play("Videojuego/src/videojuego/audio/Tienda.wav");

                    System.out.println("!Ha gastar dinero¡");
                    break;
                case 3:
                    audio.stop();
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