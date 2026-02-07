package videojuego;

import java.util.Scanner;

/**
 * Proyecto: Videojuego RPG Versión: 1.0.1
 *
 * @author Tomás Cano Y Pablo Marín
 */
public class Main implements Graficos {

    // Variables estáticas para el sistema recursivo del jefe
    private static JefeFinal jefeRecurrente = null;
    private static int vecesEnfrentado = 0;

    public static void main(String[] args) {
        /**
         * Declaración de variables
         */
        String nombreJugador, nombreEnemigo;
        boolean jugando = true;
        String[] listaE = { "Enigma", "El pinguino", "Poison Ivy", "Bane" };
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

                    if (jugador1.getPuntosAtaque() > enemigo.getPuntosAtaque()) {

                        // Gana combate
                        botin = enemigo.soltarDinero();
                        jugador1.setBatarangs(jugador1.getBatarangs() + botin);

                        System.out.println("¡GANASTE EL COMBATE!");
                        Jugador.mostrarMensaje("Has derrotado a " + enemigo.getNombre());
                        Jugador.mostrarMensaje("Recolectas " + botin + " batarangs.");
                        Jugador.mostrarMensaje("Ahora tienes: " + jugador1.getBatarangs() + " batarangs.\n");
                        contador++;

                        Jugador.mostrarMensaje("Has derrotado " + contador + " enemigo/s.\n");

                    } else if (jugador1.getPuntosAtaque() < enemigo.getPuntosAtaque()) {

                        // Pierde combate
                        damage = enemigo.getPuntosAtaque() - jugador1.getPuntosAtaque();
                        jugador1.setPuntosSalud(jugador1.getPuntosSalud() - damage);

                        if (jugador1.getPuntosSalud() < 0) {// condicion que para que los PS no se reduzcan de 0
                            jugador1.setPuntosSalud(0);
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

                    } else {
                        System.out.println("\n ¡EMPATE! ");
                        Jugador.mostrarMensaje("Tu fuerza y la de " + enemigo.getNombre() + " son iguales.");
                        Jugador.mostrarMensaje("Ambos retroceden sin causar daño.");
                        Jugador.mostrarMensaje("¡No hay ganador esta vez!\n");
                        // No se suma al contador, no hay botín, no hay daño
                    }
                    /**
                     * Al combatir hasta cierta cantidad de enemigos se enseñara
                     * a un nuevo tipo de enemigo con música e una pequeña
                     * introducción un Jefe del cual dependiendo(if-else) de tus
                     * PS podrá salir tres variaciones del Jefe
                     */

                    if (contador == 5) {
                        // Llamar al combate recursivo del jefe
                        jugando = combateRecursivoJefe(jugador1, audio, enemigo);
                        contador = 0; // Resetear contador después del combate con el jefe
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
                                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 6);// Se añade el cambio
                                        // de estadisticas

                                        System.out.println("Ha cambio de 9 batarangs has ganado 6 de fuerza");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs, ");
                                    }

                                    break;

                                case 2:
                                    if (jugador1.getBatarangs() >= 6) {

                                        jugador1.setBatarangs(jugador1.getBatarangs() - 6);     
                                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 3);

                                        System.out.println("Ha cambio de 6 batarangs has ganado 3 de fuerza");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs");
                                    }

                                    break;

                                case 3:
                                    if (jugador1.getBatarangs() >= 4) {

                                        jugador1.setBatarangs(jugador1.getBatarangs() - 4);
                                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 2);
                                        
                                        System.out.println("Ha cambio de 4 batarangs has ganado 2 de fuerza");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs");
                                    }

                                    break;

                                case 4:
                                    if (jugador1.getBatarangs() >= 2) {
                                        jugador1.setBatarangs(jugador1.getBatarangs() - 2);
                                        jugador1.setPuntosSalud(jugador1.getPuntosSalud() + 2);
                                      
                                        System.out.println("Te has curado 2 PS");
                                    } else {
                                        System.out.println("No tienes suficiente batarangs");
                                    }

                                    break;

                                case 5:
                                    if (jugador1.getBatarangs() >= 3) {
                                        jugador1.setBatarangs(jugador1.getBatarangs() - 3);
                                        jugador1.setPuntosSalud(jugador1.getPuntosSalud() + 5);

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

    /**
     * Método recursivo para el combate con el jefe final
     * El jefe sube de nivel cada vez que lo derrotas y vuelves a enfrentarlo
     * 
     * @param jugador El jugador actual
     * @param audio Sistema de audio del juego
     * @param enemigo Referencia al enemigo para mensajes de derrota
     * @return true si el juego continúa, false si el jugador muere
     */
    private static boolean combateRecursivoJefe(Jugador jugador, Musica audio, Enemigo enemigo) {
        audio.Stop();
        System.out.println("──────────────────────────────────────────────────────────────\n"
                + "Un enemigo terrorífico se acerca... estas dispuesto a seguir.\n");

        // Si es la primera vez, crear el jefe
        if (jefeRecurrente == null) {
            jefeRecurrente = new JefeFinal(null, 0, 0, 0);
            vecesEnfrentado = 0;
        } else {
            // Si ya existe, subir su nivel
            jefeRecurrente.subirNivel();
        }

        vecesEnfrentado++;
        
        if (vecesEnfrentado == 1) {
            audio.Play("Videojuego/src/videojuego/audio/Risa-Joker.wav");
            Jugador.mostrarMensaje("¡Cuidado ha aparecido el JOKER!");
            JefeFinal.risaPrecentacion();
        } else {
            System.out.println("\n ¡EL JOKER HA REGRESADO!\n");
            System.out.println("   Enfrentamiento #" + vecesEnfrentado);
        }

        jefeRecurrente.llamarJefe(jugador);

        // Variables para el combate
        int damage;
        int ataqueJefe = jefeRecurrente.getPuntosAtaqueJefe();
        
        // Verificar si el jefe usa ataque especial
        if (jefeRecurrente.usarAtaqueEspecial()) {
            ataqueJefe = jefeRecurrente.calcularAtaqueEspecial();
        }

        // Lógica de combate (sin turnos, como el original)
        if (jugador.getPuntosAtaque() > ataqueJefe) {
            // Gana combate
            int botin = (int)(Math.random() * 20) + 10; // Botín mayor por ser jefe
            jugador.setBatarangs(jugador.getBatarangs() + botin);

            System.out.println("\n ¡VICTORIA SOBRE EL JOKER!\n");
            
            Jugador.mostrarMensaje("Has derrotado a " + jefeRecurrente.getNombreJefe());
            Jugador.mostrarMensaje("Recolectas " + botin + " batarangs.");
            Jugador.mostrarMensaje("Ahora tienes: " + jugador.getBatarangs() + " batarangs.\n");
            
            if (vecesEnfrentado > 1) {
                System.out.println("Has derrotado al Joker " + vecesEnfrentado + " veces consecutivas");
                System.out.println("La próxima vez será aún más difícil...\n");
            }

        } else if (jugador.getPuntosAtaque() < ataqueJefe) {
            // Pierde combate
            damage = ataqueJefe - jugador.getPuntosAtaque();
            jugador.setPuntosSalud(jugador.getPuntosSalud() - damage);

            if (jugador.getPuntosSalud() < 0) {
                jugador.setPuntosSalud(0);
            }

            Jugador.mostrarMensaje("\n ¡PERDISTE LA PELEA!");
            Jugador.mostrarMensaje(jefeRecurrente.getNombreJefe() + " te superó por " + damage + " puntos.");
            Jugador.mostrarMensaje("Pierdes " + damage + " puntos de salud.");
            Jugador.mostrarMensaje("Salud restante: " + jugador.getPuntosSalud() + "\n");

            // Verificar si murió
            if (jugador.getPuntosSalud() <= 0) {
                System.out.println("\n       GAME OVER 💀 \n");
                System.out.println("\nEl Joker: '¿Sabías que la locura es como la gravedad?");
                System.out.println("         ¡Solo hace falta un pequeño empujón! JAJAJA!'\n");
                System.out.println("Has caído ante el Joker después de " + vecesEnfrentado + " enfrentamiento(s).");
                
                jugador.setPuntosSalud(0);
                JefeFinal.finalCombateJefe();
                audio.Play("Videojuego/src/videojuego/audio/Batman.wav");
                return false; // El juego termina
            }
        } else {      
            System.out.println("\n ¡EMPATE! ");
            Jugador.mostrarMensaje("Tu fuerza y la de " + enemigo.getNombre() + " son iguales.");
            Jugador.mostrarMensaje("Ambos retroceden sin causar daño.");
            Jugador.mostrarMensaje("¡No hay ganador esta vez!\n");
            // No se suma al contador, no hay botín, no hay daño
        }

        JefeFinal.finalCombateJefe();
        audio.Play("Videojuego/src/videojuego/audio/Batman.wav");
        return true; // El juego continúa
    }

    @Override
    public void presentacion() {
        throw new UnsupportedOperationException("Not supported yet.");// Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void simbolo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mensajeMenu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void elegirFuerza() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mensajeTienda() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}