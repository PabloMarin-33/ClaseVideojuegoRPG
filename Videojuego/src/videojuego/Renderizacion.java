/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuego;

/**
 *
 * @author usuario
 */
public class Renderizacion implements Graficos {

    @Override
    public void presentacion() {
        System.out.println("\n Batalla en Gotham city \n");
        System.out.println("En una noche de Gotham city... mientras caminas por la calle escuchas gruñidos y gritos \n"
                + "de gente desesperada, vas a investigar por curiosidad, no es hasta que encuentras \n"
                + "a Batman haciendo su trabajo, interrogando a lo que parecen gánsters de bajo nivel, \n"
                + "El nota tu precencia, levanta apenas la mirada y dice: \n"
                + "\n"
                + "B: ...Tu... has sido testigo de algo que no deberías de haber visto. Saben tu cara... Pero no tu nombre... ¿Quién eres?...\n");

        System.out.print("introduce tu nombre: ");
    }
    
    @Override
    public void mensajeMenu() {
        System.out.println("\n      PANEL DE OPCIONES \n"
                + "───────────────────────────────\n"
                + "»1       Combatir \n"
                + "»2       Tienda \n"
                + "»3       Mis estadisticas \n"
                + "»4       Salir del juego \n"
                + "───────────────────────────────\n");
        System.out.print("Elige una opción: ");
    }
    
    @Override
    public void elegirFuerza() {
        System.out.println("¿Te gustaría cambiar de fuerza? \n");
        System.out.println("Recuerda que tienes solo dos batarangs(dinero) por usar");
        System.out.println("Opcion 1 es reasignar tu fuerza actual por un batarang");
        System.out.println("Opcion 2 significa que estás listo para adentrarte en Gotham");
        System.out.print("Elige una opcion: ");
    }
    
     public void mensajeTienda() {
        Jugador.mostrarMensaje("\n        EQUIPAMIENTO \n"
                + "───────────────────────────────────────────────────────────\n"
                + "» 1   Bat-Hacha " + " Precio:  12 Batarangs " + " Fuerza: 8" + "\n"
                + "» 2   Bat-Taser " + " Precio:  8 Batarangs " + " Fuerza: 3" + "\n"
                + "» 3   Spray Anti-Tiburones " + " Precio:  6 Batarangs " + " Fuerza: 2" + "\n"
                + "\n                   CURACION \n"
                + "───────────────────────────────────────────────────────────\n"
                + "» 4   Vendas " + " Precio:  4 Batarangs " + " Curacion: +2" + "\n"
                + "» 5   Botiquin " + " Precio:  5 Batarangs " + " Curacion: +5" + "\n"
                + "───────────────────────────────────────────────────────────\n"
                + "» 6   para salir" + "\n");
        System.out.print("Elige una opcion: ");
    }
     
    @Override
    public void simbolo() {
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
    }
}
