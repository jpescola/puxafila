/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author jpescola
 */
public abstract class StringUtil {

    public static String snakeCase(String s) {
        return s.replaceAll(" ", "_");
    }

}
