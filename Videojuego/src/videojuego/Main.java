package videojuego;

import java.util.Scanner;

public class Main {

    public static void mensaje() {

        System.out.println("\n      PANEL DE OPCIONES \n"
                + "───────────────────────────────\n"
                + "»1       Combatir \n"
                + "»2       Tienda \n"
                + "»3       Mis estadisticas \n"
                + "»4       Salir del juego \n"
                + "───────────────────────────────\n");
        System.out.print("Elige una opción: ");

    }

    public static void mensaje2() {

        System.out.println("¿Te gustaría cambiar de fuerza? \n");
        System.out.println("Recuerda que tienes solo dos batarangs(dinero) por usar");
        System.out.println("Opcion 1 es reasignar tu fuerza actual por un batarang");
        System.out.println("Opcion 2 significa que estás listo para adentrarte en Gotham");
        System.out.print("Elige una opcion: ");
    }

    public static void mensajeTienda() {

        System.out.println("\n        EQUIPAMIENTO \n"
                + "───────────────────────────────────────────────────────────\n"
                + "» 1   Bat-Hacha " + " Precio:  9 Batarangs " + " Fuerza: 6" + "\n"
                + "» 2   Bat-Taser " + " Precio:  6 Batarangs " + " Fuerza: 3" + "\n"
                + "» 3   Spray Anti-Tiburones " + " Precio:  4 Batarangs " + " Fuerza: 2" + "\n"
                + "\n                   CURACION \n"
                + "───────────────────────────────────────────────────────────\n"
                + "» 4   Vendas " + " Precio:  2 Batarangs " + " Curacion: +2" + "\n"
                + "» 5   Botiquin " + " Precio:  3 Batarangs " + " Curacion: +5" + "\n"
                + "───────────────────────────────────────────────────────────\n"
                + "» 6   para salir" + "\n");
        System.out.print("Elige una opcion: " + "\n");
    }

    public static void main(String[] args) {

        // declaracion variables
        String nombreJugador, nombreEnemigo;
        boolean jugando = true;
        String[] listaE = { "Enigma", "El pinguino", "Posion Ivy", "Bane" };
        int opcionFuerza = 0, indice, botin, damage, opcionTienda;
        int contador = 0;

        Scanner teclado = new Scanner(System.in);
        Musica audio = new Musica();

        audio.Play("Videojuego/src/videojuego/audio/Batman.wav");

        System.out.println("\n Batalla en Gotham city \n");
        System.out.println("En una noche de Gotham city... mientras caminas por la calle escuchas gruñidos y gritos \n"
                + "de gente desesperada, vas a investigar por curiosidad, no es hasta que encuentras \n"
                + "a Batman haciendo su trabajo, interrogando a lo que parecen gánsters de bajo nivel, \n"
                + "El nota tu precencia, levanta apenas la mirada y dice: \n"
                + "\n"
                + "B: ...Tu... has sido testigo de algo que no deberías de haber visto. Saben tu cara... Pero no tu nombre... ¿Quién eres?...\n");

        System.out.print("introduce tu nombre: ");
        nombreJugador = teclado.nextLine();

        System.out.println(
                "\nB: " + nombreJugador + " Tu noche acaba de empeorar y espero que te puedas manejar por las calles.\n"
                        + "Por que hoy me vas a acompañar... \n");

        System.out.println(
                "Es así como tu historia empieza para resolver el misterio que rodea esta noche en Gotham. \n"
                        + "\n");

        System.out.println("_____________________                              _____________________\r\n"
                + //
                "`-._:  .:'   `:::  .:\\           |\\__/|           /::  .:'   `:::  .:.-'\r\n"
                + //
                "    \\      :          \\          |:   |          /         :       /    \r\n"
                + //
                "     \\     ::    .     `-_______/ ::   \\_______-'   .      ::   . /      \r\n"
                + //
                "      |  :   :: ::'  :   :: ::'  :   :: ::'      :: ::'  :   :: :|       \r\n"
                + //
                "      |     ;::         ;::         ;::         ;::         ;::  |       \r\n"
                + //
                "      |  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:|       \r\n"
                + //
                "      /     :           :           :           :           :    \\       \r\n"
                + //
                "     /______::_____     ::    .     ::    .     ::   _____._::____\\      \r\n"
                + //
                "                   `----._:: ::'  :   :: ::'  _.----'                    \r\n"
                + //
                "                          `--.       ;::  .--'                           \r\n"
                + //
                "                              `-. .:'  .-'                               \r\n"
                + //
                "                                 \\    /                                  \r\n"
                + //
                "                                  \\  /                                   \r\n"
                + //
                "                                   \\/ ");

        Jugador jugador1 = new Jugador(nombreJugador);

        jugador1.calcularFuerzaJ();
        System.out.println("Tu fuerza inicial es: " + jugador1.getPuntosAtaque() + "\n");

        do {

            mensaje2();

            opcionFuerza = teclado.nextInt();

            switch (opcionFuerza) {
                case 1:
                    if (jugador1.getBatarangs() > 0) {

                        jugador1.setBatarangs(jugador1.getBatarangs() - 1);
                        jugador1.calcularFuerzaJ();

                        System.out.println("\nHas reasignado tu fuerza por 1 batarang.");
                        System.out.println("Tu nueva fuerza es: " + jugador1.getPuntosAtaque());
                        System.out.println("Oro restante: " + jugador1.getBatarangs() + "\n");
                    } else {
                        System.out.println("\n No tienes batarangs suficientes.\n");
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
                    System.out.println("!A combatir¡");

                    indice = (int) (Math.random() * listaE.length);
                    nombreEnemigo = listaE[indice];

                    Enemigo enemigo = new Enemigo(nombreEnemigo);

                    enemigo.calcularFuerzaE();

                    Jugador.mostrarMensaje(" Un enemigo aparece: " + enemigo.getNombre());
                    Jugador.mostrarMensaje(" Su fuerza es: " + enemigo.getPuntosAtaque());
                    Jugador.mostrarMensaje(" Tu fuerza es: " + jugador1.getPuntosAtaque());
                    System.out.println("─────────────────────────────");

                    if (jugador1.getPuntosAtaque() >= enemigo.getPuntosAtaque()) {

                        // Gana combate
                        botin = enemigo.soltarDinero();
                        jugador1.setBatarangs(jugador1.getBatarangs() + botin);

                        System.out.println("¡GANASTE EL COMBATE!");
                        Jugador.mostrarMensaje("Has derrotado a " + enemigo.getNombre());
                        Jugador.mostrarMensaje("Recolectas " + botin + " batarangs.");
                        Jugador.mostrarMensaje("Ahora tienes: " + jugador1.getBatarangs() + " batarangs.\n");
                        contador++;
                        Jugador.mostrarMensaje("Has derrotado " + contador + " enemigo/s.\n");

                    } else {

                        // Pierde combate
                        damage = enemigo.getPuntosAtaque() - jugador1.getPuntosAtaque();
                        jugador1.setPuntosSalud(jugador1.getPuntosSalud() - damage);

                        if (jugador1.getPuntosSalud() < 0) {
                            jugador1.setPuntosSalud(0);
                            jugador1.getPuntosSalud();

                        }
                    

                        Jugador.mostrarMensaje(" ¡PERDISTE LA PELEA!");
                        Jugador.mostrarMensaje(enemigo.getNombre() + " te superó por " + damage + " puntos.");
                        Jugador.mostrarMensaje("Pierdes " + damage + " puntos de salud.");
                        Jugador.mostrarMensaje("Salud restante: " + jugador1.getPuntosSalud() + "\n");

                        // ¿Murió?
                        if (jugador1.getPuntosSalud() <= 0) {
                                   jugador1.morirPorEnemigo(enemigo);
                                   jugando = false;
                        }
                    }
                     

                    if (contador == 2) {
                        System.out.println("──────────────────────────────────────────────────────────────\n"
                            +"Un enemigo terrorífico se acerca... estas dispuesto a seguir.\n");
                        Jefefinal jefefinal1 = new Jefefinal(nombreEnemigo, contador, contador);
                        Jugador.mostrarMensaje("!Cuidado ah aparecido el " + jefefinal1.getNombreJefe() + '¡'+"\n");
                        
                        jefefinal1.llamarJefe(jugador1);

                        if (jugador1.getPuntosAtaque() >= jefefinal1.getPuntosAtaqueJefe()) {

                        // Gana combate
                        botin = enemigo.soltarDinero();
                        jugador1.setBatarangs(jugador1.getBatarangs() + botin);

                        System.out.println("───────────────────────────────"+
                                            "\n¡LE HAS GANADO A "+ jefefinal1.getNombreJefe()+ '!'+"\n");
                        
                        Jugador.mostrarMensaje("Recolectas " + botin + " batarangs.");
                        Jugador.mostrarMensaje("Ahora tienes: " + jugador1.getBatarangs() + " batarangs.\n");

                        } else {

                            // Pierde combate
                            damage = enemigo.getPuntosAtaque() - jugador1.getPuntosAtaque();
                            jugador1.setPuntosSalud(jugador1.getPuntosSalud() - damage);

                                if (jugador1.getPuntosSalud() < 0) {
                                    jugador1.setPuntosSalud(0);
                                    jugador1.getPuntosSalud();

                                }

                            Jugador.mostrarMensaje(" ¡PERDISTE LA PELEA!");
                            Jugador.mostrarMensaje(enemigo.getNombre() + " te superó por " + damage + " puntos.");
                            Jugador.mostrarMensaje("Pierdes " + damage + " puntos de salud.");
                            Jugador.mostrarMensaje("Salud restante: " + jugador1.getPuntosSalud() + "\n");
                               
                            if (jugador1.getPuntosSalud() <= 0) {
                                   jugador1.morirPorEnemigo(enemigo);
                                   jugando = false;
                                }
                        }
                    }
                     
                    break;
                case 2:
                    audio.stop();
                    audio.Play("Videojuego/src/videojuego/audio/Tienda.wav");

                    System.out.println("\n!Ha gastar dinero¡");
                    do {
                        System.out.println("\nTienes: " + jugador1.getBatarangs() + " batarangs en total\n");
                        mensajeTienda();
                        opcionTienda = teclado.nextInt();
                        if (jugador1.getBatarangs() > 0) {

                            switch (opcionTienda) {
                                case 1:
                                    if (jugador1.getBatarangs() >= 9) {

                                        jugador1.setBatarangs(jugador1.getBatarangs() - 9);
                                        jugador1.getBatarangs();
                                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 6);
                                        jugador1.getPuntosAtaque();

                                        if (jugador1.getBatarangs() < 0) {
                                            jugador1.setBatarangs(0);
                                            jugador1.getBatarangs();
                                        }

                                        System.out.println("Ha cambio de 9 batarangs has ganado 6 de fuerza");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs, ");
                                    }

                                    break;

                                case 2:
                                    if (jugador1.getBatarangs() >= 6) {

                                        jugador1.setBatarangs(jugador1.getBatarangs() - 6);
                                        jugador1.getBatarangs();
                                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 3);
                                        jugador1.getPuntosAtaque();

                                        if (jugador1.getBatarangs() < 0) {
                                            jugador1.setBatarangs(0);
                                            jugador1.getBatarangs();
                                        }

                                        System.out.println("Ha cambio de 6 batarangs has ganado 3 de fuerza");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs");
                                    }

                                    break;

                                case 3:
                                    if (jugador1.getBatarangs() >= 4) {

                                        jugador1.setBatarangs(jugador1.getBatarangs() - 4);
                                        jugador1.getBatarangs();
                                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 2);
                                        jugador1.getPuntosAtaque();

                                        if (jugador1.getBatarangs() < 0) {
                                            jugador1.setBatarangs(0);
                                            jugador1.getBatarangs();
                                        }

                                        System.out.println("Ha cambio de 4 batarangs has ganado 2 de fuerza");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs");
                                    }

                                    break;

                                case 4:
                                    if (jugador1.getBatarangs() >= 2) {
                                        jugador1.setBatarangs(jugador1.getBatarangs() - 2);
                                        jugador1.getBatarangs();
                                        jugador1.setPuntosSalud(jugador1.getPuntosSalud() + 2);
                                        jugador1.getPuntosSalud();

                                        if (jugador1.getBatarangs() < 0) {
                                            jugador1.setBatarangs(0);
                                            jugador1.getBatarangs();
                                        }

                                        System.out.println("Te has curado 2 PS");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs");
                                    }

                                    break;

                                case 5:
                                    if (jugador1.getBatarangs() >= 3) {
                                        jugador1.setBatarangs(jugador1.getBatarangs() - 3);
                                        jugador1.getBatarangs();
                                        jugador1.setPuntosSalud(jugador1.getPuntosSalud() + 5);
                                        jugador1.getPuntosSalud();

                                        if (jugador1.getBatarangs() < 0) {
                                            jugador1.setBatarangs(0);
                                            jugador1.getBatarangs();
                                        }

                                        System.out.println("has curado 5 PS");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs");
                                    }

                                    break;

                            }

                        } else {
                            System.out.println("No tienes dinero");
                        }
                    } while (opcionTienda != 6);

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
