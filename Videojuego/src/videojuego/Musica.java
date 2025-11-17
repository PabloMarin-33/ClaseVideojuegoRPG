package videojuego;

import java.io.File;
import javax.sound.sampled.*;

public class Musica {
    private Clip clip;

    public void play(String ruta) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(ruta));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error al reproducir audio: " + e.getMessage());
        }finally{
            System.out.println("Corriendo el videojuego");
        }
    }

    public void Tienda(String ruta) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(ruta));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error al reproducir audio: " + e.getMessage());
        }finally{
            System.out.println("Corriendo el videojuego");
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
