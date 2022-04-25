package com.example.pines;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class DBTrabajadores {

    Context context;
    Trabajador trabajador;
    ArrayList<Trabajador> listaTrabajadores;
    SQLiteDatabase sqLiteDatabase;
    String bd = "BDPines";
    String tablaTrabajadores = "CREATE TABLE IF NOT EXISTS trabajador(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT ," +
            "apellido TEXT ," +
            "documento TEXT ," +
            "correo TEXT ," +
            "nombre_usuario type UNIQUE," +
            "contrasena TEXT," +
            "saldo TEXT)";

    public DBTrabajadores(Context context) {
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(bd, Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL(tablaTrabajadores);
        trabajador = new Trabajador();

    }

    public Boolean insertarUser(Trabajador trabajador) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nombre", trabajador.getNombre());
            contentValues.put("apellido", trabajador.getApellido());
            contentValues.put("documento", trabajador.getDocumento());
            contentValues.put("correo", trabajador.getCorreo());
            contentValues.put("nombre_usuario", trabajador.getNombreUsuario());
            contentValues.put("contrasena", trabajador.getContrasena());
            contentValues.put("saldo", trabajador.getSaldo());
            sqLiteDatabase.insert("trabajador",null,contentValues);
            return true;
    }


    public boolean actualizarTrabajador(@NonNull Trabajador trabajador) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("saldo", trabajador.getSaldo());
        sqLiteDatabase.update("trabajador", contentValues, "nombre_usuario='"+ trabajador.getNombreUsuario() +"'", null);
        return true;
    }



    public ArrayList<Trabajador> selecionarUsuario(){
        ArrayList<Trabajador> listaTrabajadores=new ArrayList<Trabajador>();
        listaTrabajadores.clear();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM trabajador",null);
        if(cursor!=null&&cursor.moveToFirst()){
            do {
                Trabajador trabajador= new Trabajador();
                trabajador.setId(cursor.getInt(0));
                trabajador.setNombre(cursor.getString(1));
                trabajador.setApellido(cursor.getString(2));
                trabajador.setDocumento(cursor.getString(3));
                trabajador.setCorreo(cursor.getString(4));
                trabajador.setNombreUsuario(cursor.getString(5));
                trabajador.setContrasena(cursor.getString(6));
                trabajador.setSaldo(cursor.getString(7));
                listaTrabajadores.add(trabajador);
            }while (cursor.moveToNext());

        }return listaTrabajadores;
    }


    public boolean consultar(String nombreUsuario, String contrasena){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM trabajador WHERE nombre_usuario='"+nombreUsuario+"' AND contrasena='"+contrasena+"'", null);
        if (cursor.moveToFirst()) {
            return true;
        }else{
            return false;
        }
    }


    public boolean consultarNombreUsuario(String nombreUsuario){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM trabajador WHERE nombre_usuario='"+nombreUsuario+"'", null);
        if (cursor.moveToFirst()) {
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Trabajador> selecionarUsuario1(String nombreUsuario){
        ArrayList<Trabajador> listaTrabajadores=new ArrayList<Trabajador>();
        listaTrabajadores.clear();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM trabajador WHERE nombre_usuario='"+nombreUsuario+"'",null);
        if(cursor!=null&&cursor.moveToFirst()){
            do {
                Trabajador trabajador= new Trabajador();
                trabajador.setId(cursor.getInt(0));
                trabajador.setNombre(cursor.getString(1));
                trabajador.setApellido(cursor.getString(2));
                trabajador.setDocumento(cursor.getString(3));
                trabajador.setCorreo(cursor.getString(4));
                trabajador.setNombreUsuario(cursor.getString(5));
                trabajador.setContrasena(cursor.getString(6));
                trabajador.setSaldo(cursor.getString(7));
                listaTrabajadores.add(trabajador);
            }while (cursor.moveToNext());

        }return listaTrabajadores;
    }

    public int selecionarUsuario2(String nombreUsuario) {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM trabajador WHERE nombre_usuario='" + nombreUsuario + "'", null);
        int IdTrabajador = 0;
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int trabajador = -1;
                trabajador = cursor.getInt(0);
                IdTrabajador = Integer.parseInt(String.valueOf(trabajador));
            } while (cursor.moveToNext());

        }
        return IdTrabajador;
    }

    public int selecionarSaldo(String nombreUsuario) {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM trabajador WHERE nombre_usuario='" + nombreUsuario + "'", null);
        int SaldoTrabajador = 0;
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int trabajador = 0;
                trabajador = cursor.getInt(7);
                SaldoTrabajador = trabajador;
            } while (cursor.moveToNext());

        }
        return SaldoTrabajador;
    }


    public int selecionarMaxVenta(String nombreUsuario) {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM trabajador WHERE nombre_usuario='" + nombreUsuario + "'", null);
        int MaxVenta = 0;
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int trabajador = -1;
                trabajador = cursor.getInt(8);
                MaxVenta = trabajador;
            } while (cursor.moveToNext());

        }
        return MaxVenta;
    }

    public int login(String nombreUsuario, String contrasena){
        int a=0;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM trabajador where nombre_usuario='Giuseppe' and contrasena=123", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    if (cursor.getString(5).equals(nombreUsuario) && cursor.getString(6).equals(contrasena)) {
                        a++;
                    }
                } while (cursor.moveToNext());
            }
        return a;
    }



    public Trabajador getTrabajador(String nombreUsuario,String contrasena) {
        listaTrabajadores = selecionarUsuario();
        for(Trabajador trabajador:listaTrabajadores){
            if(trabajador.getNombreUsuario().equals(nombreUsuario)&&trabajador.getContrasena().equals(contrasena)){
                return trabajador;
            }
        }
        return null;
    }

    public Trabajador getTrabajadorById(int id) {
        listaTrabajadores = selecionarUsuario();
        for(Trabajador trabajador:listaTrabajadores){
            if(trabajador.getId()==id){
                return trabajador;
            }

        }
        return null;
    }

}

