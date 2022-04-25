package com.example.pines;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class FechaActual {
    @NonNull
    @RequiresApi(api = Build.VERSION_CODES.O)

    static String getFechaHora() {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    static String getFecha() {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static String getHora() {
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    static String  calcularFecha() {
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        c.add(Calendar.DATE, -1);
        Date nowMinus15 = c.getTime();
        return String.valueOf(nowMinus15);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static String  calcularFecha1() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        Date nowMinus15 = c.getTime();
        String now = new SimpleDateFormat("yyyy/MM/dd").format(nowMinus15);
        return now;

    }

}
