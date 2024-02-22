package vista;

import javax.sound.sampled.*;
import java.io.File;

public class ReproductorMusica extends Thread {
    private Clip clip;

    public ReproductorMusica(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Reproducir en bucle
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000); // Esperar un segundo entre iteraciones
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
    }
}