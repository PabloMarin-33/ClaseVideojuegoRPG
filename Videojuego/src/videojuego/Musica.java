package videojuego;

import java.io.File;
import javax.sound.sampled.*;

public class Musica {
    private Clip clip;

    // Método genérico para reproducir cualquier sonido
    private void reproducir(String ruta) {
        AudioInputStream audioStream = null;

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
    public void play(String ruta) {
        reproducir(ruta);
    }

    public void tienda(String ruta) {
        reproducir(ruta);
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
