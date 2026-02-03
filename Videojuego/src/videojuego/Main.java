package videojuego;

import java.util.Scanner;

/**
 * Proyecto: Videojuego RPG Versión: 1.0.1
 *
 * @author Tomás Cano Y Pablo Marín
 */
public class Main implements Graficos {

    public static void main(String[] args) {
        /**
         * Declaración de variables
         */
        String nombreJugador, nombreEnemigo;
        boolean jugando = true;
        String[] listaE = { "Enigma", "El pinguino", "Posion Ivy", "Bane" };
        int opcionFuerza = 0, indice, botin, damage, opcionTienda;
        int contador = 0;
        Renderizacion render = new Renderizacion();
        /**
         * Declarando el Scanner(teclado) y musica
         */
        Scanner teclado = new Scanner(System.in);
        Musica audio = new Musica();

        audio.Play("Videojuego/src/videojuego/audio/Batman.wav");
        /**
         * Introducción del juego donde el jugador se adentrara, y se
         * declara(Jugador1 ) en el juego hasta que le piden que inserte su
         * nombre en String
         */

        render.presentacion();

        nombreJugador = teclado.nextLine();

        System.out.println("\nB: " + nombreJugador + " Tu noche acaba de empeorar y espero que te puedas manejar por las calles.\n"
                        + "Por que hoy me vas a acompañar... \n");

        System.out.println("Es así como tu historia empieza para resolver el misterio que rodea esta noche en Gotham. \n"
                        + "\n");

        render.simbolo();

        Jugador jugador1 = new Jugador(nombreJugador);
        /**
         * Bucle en el que se le presentará al jugador con la opción de
         * restablcer el valor de su fuerza a cambio de dinero. Esto se ha
         * realizado a través de un bucle(do-while) con un pequeño panel de
         * opciones(switch) y una condiocional(if) para que el dinero no vaya a
         * numeros negativos
         */
        jugador1.calcularFuerzaJ();
        System.out.println("Tu fuerza inicial es: " + jugador1.getPuntosAtaque() + "\n");

        do {

            render.elegirFuerza();

            opcionFuerza = teclado.nextInt();

            switch (opcionFuerza) {
                case 1:
                    if (jugador1.getBatarangs() > 0) {

                        jugador1.setBatarangs(jugador1.getBatarangs() - 1); // Se resta del dinero del jugador
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
        /**
         * Bucle en el que se le presentará al jugador el principal panel de
         * opciones que el jugador debera escoger una delas opciones(switch) en
         * bucle(do-while) hasta sus ps estén a 0 o eliga salir del juego.
         */
        while (jugando) {

            render.mensajeMenu();

            int opcion = teclado.nextInt();

            switch (opcion) {
                /**
                 * Primera elección en el cual se le presentará un enemigo con
                 * sus puntos de ataque. El caombate acába cuando el jugador
                 * supera los puntes de ataque del enemigo o sus PS se reducen a
                 * 0
                 */
                case 1:
                    System.out.println("¡A combatir!");

                    indice = (int) (Math.random() * listaE.length); // Se escoge un nombre del array de enemigos(65)
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

                        if (jugador1.getPuntosSalud() < 0) {// condicion que para que los PS no se reduzcan de 0
                            jugador1.setPuntosSalud(0);
                            jugador1.getPuntosSalud();

                        }

                        Jugador.mostrarMensaje(" ¡PERDISTE LA PELEA!");
                        Jugador.mostrarMensaje(enemigo.getNombre() + " te superó por " + damage + " puntos.");
                        Jugador.mostrarMensaje("Pierdes " + damage + " puntos de salud.");
                        Jugador.mostrarMensaje("Salud restante: " + jugador1.getPuntosSalud() + "\n");

                        // ¿Murió?
                        if (jugador1.getPuntosSalud() <= 0) { // Si la vida del jugador cae a 0
                            enemigo.morirPorEnemigo(jugador1); // se muestra un mensaje personalizado de cada enemigo
                            jugando = false; // es juego se acaba
                        }
                    }
                    /**
                     * Al combatir hasta cierta cantidad de enemigos se enseñara
                     * a un nuevo tipo de enemigo con música e una pequeña
                     * introducción un Jefe del cual dependiendo(if-else) de tus
                     * PS podrá salir tres variaciones del Jefe
                     */

                    if (contador == 3) {
                        audio.Stop();
                        System.out.println("──────────────────────────────────────────────────────────────\n"
                                + "Un enemigo terrorífico se acerca... estas dispuesto a seguir.\n");

                        JefeFinal jefeFinal1 = new JefeFinal(nombreEnemigo, contador, contador);
                        audio.Play("Videojuego/src/videojuego/audio/Risa-Joker.wav");
                        Jugador.mostrarMensaje("¡Cuidado a aparecido el JOKER!");
                        /**
                         * Aqui se espera 11 segundos para que suene el sonido
                         * de la presentacion dela jefe Si la ruta del archivo
                         * es incorrecta o no encotrada el progarama te muestra
                         * el mensaje pero sigue con el juego pero sin musica en
                         * esta parte
                         */
                        try {
                            Thread.sleep(11400); // Se detendra estos segundos el programa hasta que pase el sonido de
                                                 // arriba
                        } catch (InterruptedException e) {
                            System.out.println("Error en la espera del jefe: " + e.getMessage());
                        }

                        jefeFinal1.llamarJefe(jugador1);

                        if (jugador1.getPuntosAtaque() >= jefeFinal1.getPuntosAtaqueJefe()) {

                            // Gana combate
                            botin = enemigo.soltarDinero();
                            jugador1.setBatarangs(jugador1.getBatarangs() + botin);

                            System.out.println("───────────────────────────────"
                                    + "\n¡LE HAS GANADO A " + jefeFinal1.getNombreJefe() + '!' + "\n");

                            Jugador.mostrarMensaje("Recolectas " + botin + " batarangs.");
                            Jugador.mostrarMensaje("Ahora tienes: " + jugador1.getBatarangs() + " batarangs.\n");
                            contador = 0;// cada que le ganes o pierdas contra el jefe el contador se restablece a 0
                                         // combates

                        } else {
                            // Pierde combate
                            damage = jefeFinal1.getPuntosAtaqueJefe() - jugador1.getPuntosAtaque();
                            jugador1.setPuntosSalud(jugador1.getPuntosSalud() - damage);

                            if (jugador1.getPuntosSalud() < 0) {
                                jugador1.setPuntosSalud(0);
                                jugador1.getPuntosSalud();

                            }

                            Jugador.mostrarMensaje(" ¡PERDISTE LA PELEA!");
                            Jugador.mostrarMensaje(
                                    jefeFinal1.getNombreJefe() + " te superó por " + damage + " puntos.");
                            Jugador.mostrarMensaje("Pierdes " + damage + " puntos de salud.");
                            Jugador.mostrarMensaje("Salud restante: " + jugador1.getPuntosSalud() + "\n");
                            contador = 0;

                            // Murio
                            if (jugador1.getPuntosSalud() <= 0) {
                                enemigo.morirPorEnemigo(jugador1);
                                jugando = false;
                            }
                        }
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Error en la espera del jefe: " + e.getMessage());
                        }
                        audio.Play("Videojuego/src/videojuego/audio/Batman.wav");
                    }

                    break;
                /**
                 * Segunda opción de la cual es la tienda de la cual se mostrará
                 * un nuevo panel de control para los objetos que puede comprar
                 * todo esto mientras(if-else) tengas la contidad suficiente de
                 * dinero.
                 */
                case 2:
                    audio.Stop();
                    audio.Tienda("Videojuego/src/videojuego/audio/Tienda.wav");

                    System.out.println("\n¡Ha gastar dinero!");
                    do {// Bucle para que el jugador pueda comprar más de un objeto
                        System.out.println("\nTienes: " + jugador1.getBatarangs() + " batarangs en total\n");
                        render.mensajeTienda();
                        opcionTienda = teclado.nextInt();
                        if (jugador1.getBatarangs() > 0) {// Se presentera las opciones si tienes dinero

                            switch (opcionTienda) {
                                case 1:
                                    if (jugador1.getBatarangs() >= 9) {// Solo se accede si el jugador posee el dinero
                                        // suficiente

                                        jugador1.setBatarangs(jugador1.getBatarangs() - 9);// Se resta el dinero del
                                        // objeto
                                        jugador1.getBatarangs();
                                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 6);// Se añade el cambio
                                        // de estadisticas
                                        jugador1.getPuntosAtaque();

                                        if (jugador1.getBatarangs() < 0) {// Se comprueba y se fija que el dinero no se
                                            // baje a 0
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
                    audio.Play("Videojuego/src/videojuego/audio/Batman.wav");

                    break;
                /**
                 * Tercera opcion de la cual se muestra las estadísticas del
                 * jugador, a través de un método toString
                 */
                case 3:
                    System.out.println("Tus estadisticas");
                    System.out.println(jugador1);
                    break;
                /**
                 * Cuarta opción que es salir del juego combiendo el valor del
                 * Booleano
                 */
                case 4:
                    System.out.println("¡Adios, vuelva pronto!");
                    jugando = false;
                    break;
                default:
                    System.out.println("uff.. por ahi no, siga las intrucciones");

            }
        }

        teclado.close();
        audio.Stop();
    }

    @Override
    public void presentacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void simbolo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mensajeMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void elegirFuerza() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mensajeTienda() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}