/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;

/**
 *
 * @author jpescola
 */
public abstract class Arq {

    public static boolean upload(String origem, String dirDestino, String arqDestino) {
        try {
            Path original = Paths.get(origem);
            new File(dirDestino).mkdirs();
            Path destino = Paths.get(dirDestino + "/" + arqDestino);
            Files.copy(original, destino, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
        }
        return false;
    }

    public static String selecionar() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String arq = fc.getSelectedFile().getAbsoluteFile().getPath();
            return arq;
        }
        return null;
    }

//    public static String uploadPdf(String dirDestino, String arqDestino) {
//        try {
//            JFileChooser fc = new JFileChooser();
//            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//                String arq = fc.getSelectedFile().getAbsoluteFile().getPath();
//                Path original = Paths.get(arq);
//                new File(dirDestino).mkdirs();
//                Path destino = Paths.get(dirDestino + "/" + arqDestino);
//                Files.copy(original, destino, StandardCopyOption.REPLACE_EXISTING);
//                return arq;
//            }
//        } catch (IOException ex) {
//        }
//        return null;
//    }
}
