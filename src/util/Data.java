/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jpescola
 */
public abstract class Data {

    private static final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private static final SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy");

    public static Date stringToDate(String s) {
        try {
            return f.parse(s);
        } catch (ParseException ex) {
        }
        return null;
    }

    public static Date stringToDateNoTime(String s) {
        try {
            return f2.parse(s);
        } catch (ParseException ex) {
        }
        return null;
    }

    public static String dateToString(Date d) {
        if (d != null) {
            return f.format(d);
        }
        return "";
    }

    public static String dateNoTimeToString(Date d) {
        if (d != null) {
            return f2.format(d);
        }
        return "";
    }

    public static String getAno(Date d) {
        if (d != null) {
            SimpleDateFormat f2 = new SimpleDateFormat("yyyy");
            return f2.format(d);
        }
        return "";
    }

    public static String getDiaMes(Date d) {
        if (d != null) {
            SimpleDateFormat f2 = new SimpleDateFormat("ddMMM");
            return f2.format(d);
        }
        return "";
    }

    public static String getMes(Date d) {
        if (d != null) {
            SimpleDateFormat f2 = new SimpleDateFormat("MMM");
            return f2.format(d);
        }
        return "";
    }

}
