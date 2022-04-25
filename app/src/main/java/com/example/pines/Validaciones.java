package com.example.pines;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {


    static boolean ValidarEmail(String email1) {
        Boolean validacion=false;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        String email = email1;
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            validacion=true;
        } else {
            validacion=false;
        }

        return validacion;
    }


    public static boolean contieneSoloLetras(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }


    public static boolean contieneSoloLetrasp(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            if (((c >= 'a' && c <= 'z') || (c >='0' && c <= '9') || (c >= 'A' && c <= 'Z') || c != ' ')) {
                return false;
            }
        }
        return true;
    }




}
