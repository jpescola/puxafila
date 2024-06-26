/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author jpescola
 */
public abstract class Som {

    private final static String NOTIFICACAO = "wav/not1.wav";

    public static void notificacao() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(NOTIFICACAO)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
