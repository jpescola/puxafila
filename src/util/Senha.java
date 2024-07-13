/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author jpescola
 */
public abstract class Senha {

    private static final byte[] salt = "ASDFADF$#%%654hdfghsdfgsdfgsfdgaaa2".getBytes();

    public static String enc(String senha) {
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);

            byte[] hashedInputPassword = md.digest(senha.getBytes());
            return Base64.getEncoder().encodeToString(hashedInputPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean verifyPassword(String inputPassword, String storedHash) {

        return enc(inputPassword).equals(storedHash);

    }

}
