package videojuego;

import javax.sound.sampled.*;
import java.io.File;

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
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
