/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author jpescola
 */
public abstract class Number {

    public static double stringToDouble(String s) {
        return Double.parseDouble(substituirPontos(s));
    }

    public static String realToString(double v) {
        Locale ptBr = new Locale("pt", "BR");
        return NumberFormat.getNumberInstance(ptBr).format(v);
    }

    public static String floatToString(float v) {
        return String.valueOf(v).replaceAll("\\.", ",");
    }

    public static float stringToFloat(String s) {
        return Float.parseFloat(substituirPontos(s));
    }

    private static String substituirPontos(String s) {
        return s.replaceAll("\\.", "").replaceAll("\\,", "\\.");
    }

    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

}
