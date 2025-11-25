package videojuego;

// Librerias necesarias
import java.io.File;
import javax.sound.sampled.*;

/**
 *Declaración de atributos
 */
public class Musica {
    private Clip clip;

    // Método genérico para reproducir cualquier sonido
    private void reproducir(String ruta) {
        AudioInputStream audioStream = null;
        
        //Exeception de por si falla los sonidos, no detiene el juego
        try {
            audioStream = AudioSystem.getAudioInputStream(new File(ruta));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error al reproducir audio: " + e.getMessage());
        } finally {
            try {
                if (audioStream != null) {
                    audioStream.close(); // Buen uso del finally
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el audio: " + e.getMessage());
            }
        }
    }

    // Métodos específicos que reutilizan el central

    /**
     *Funcion que llama a Play
     * @param ruta reproduce la cancion o el sonido, segun la ruta que pongas en el main
     */
    public void Play(String ruta) {
        reproducir(ruta);
    }

    /**
     *Funcion que llama a Tienda
     * @param ruta reproduce la cancion o el sonido, segun la ruta que pongas en el main
     * 
     */
    public void Tienda(String ruta) {
        reproducir(ruta);
    }

    /**
     *Funcion que llama a PresentacionJefe
     * @param ruta reproduce la cancion o el sonido, segun la ruta que pongas en el main
     */
    public void PresentacionJefe(String ruta) {
        reproducir(ruta);
    }

    /**
     *Funcion que llama Stop
     *para y cierra el sonido o la cancion
     */
    public void Stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

}
