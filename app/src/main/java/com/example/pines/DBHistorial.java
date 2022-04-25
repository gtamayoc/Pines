package com.example.pines;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBHistorial {
    Context context;
    Historial historial;
    ArrayList<Historial> listaHistorial;
    SQLiteDatabase sqLiteDatabase;
    String bd = "BDPines";

    String tablaHistorial = "CREATE TABLE IF NOT EXISTS historial(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "fk_pin_id INTEGER ," +
            "fk_plan_id INTEGER ," +
            "fk_trabajador_id INTEGER ," +
            "comprador_id TEXT ," +
            "hash_pin TEXT ," +
            "valor_compra TEXT ," +
            "fecha_compra TEXT)";

    public DBHistorial(Context context) {
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(bd, Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL(tablaHistorial);
        historial = new Historial();

    }

    public boolean insertarHistorial(Historial historial) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fk_pin_id", historial.getNombre_pin());
        contentValues.put("fk_plan_id", historial.getNombre_plan());
        contentValues.put("fk_trabajador_id", historial.getFk_trabajador_id());
        contentValues.put("comprador_id", historial.getComprador_id());
        contentValues.put("hash_pin", historial.getHash_pin());
        contentValues.put("valor_compra", historial.getValor_compra());
        contentValues.put("fecha_compra", historial.getFecha_compra());
        sqLiteDatabase.insert("historial",null,contentValues);
        return true;
    }

    public ArrayList<Historial> selecionarHistorial(){
        ArrayList<Historial> listaHistorial=new ArrayList<Historial>();
        listaHistorial.clear();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM historial",null);
        if(cursor!=null&&cursor.moveToFirst()){
            do {
                Historial historial= new Historial();
                historial.setId(cursor.getInt(0));
                historial.setNombre_pin(cursor.getString(1));
                historial.setNombre_plan(cursor.getString(2));
                historial.setFk_trabajador_id(cursor.getInt(3));
                historial.setComprador_id(cursor.getString(4));
                historial.setHash_pin(cursor.getString(5));
                historial.setValor_compra(cursor.getString(6));
                historial.setFecha_compra(cursor.getString(7));
                listaHistorial.add(historial);
            }while (cursor.moveToNext());

        }return listaHistorial;
    }


    public ArrayList<Historial> selecionarHistorialTrabajador(String trabajador){
        ArrayList<Historial> listaHistorial=new ArrayList<Historial>();
        listaHistorial.clear();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM historial WHERE fk_trabajador_id='" + trabajador + "'",null);
        if(cursor!=null&&cursor.moveToFirst()){
            do {
                Historial historial= new Historial();
                historial.setId(cursor.getInt(0));
                historial.setNombre_pin(cursor.getString(1));
                historial.setNombre_plan(cursor.getString(2));
                historial.setFk_trabajador_id(cursor.getInt(3));
                historial.setComprador_id(cursor.getString(4));
                historial.setHash_pin(cursor.getString(5));
                historial.setValor_compra(cursor.getString(6));
                historial.setFecha_compra(cursor.getString(7));
                listaHistorial.add(historial);
            }while (cursor.moveToNext());

        }return listaHistorial;
    }


    public boolean consultar(int id){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM historial WHERE fk_trabajador_id='"+id+"'", null);
        if (cursor.moveToFirst()) {
            return true;
        }else{
            return false;
        }
    }


    public boolean consultarFechas(String actual,int id_usuario){
        String fechaActualConcat = actual+" "+"00:00:00";

        String fechaActualConcate = actual+" "+"23:00:59";
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM historial WHERE fk_trabajador_id ==  '"+id_usuario+"' AND fecha_compra >= '"+fechaActualConcat+"' AND fecha_compra <= '"+fechaActualConcate+"'", null);
        if (cursor.moveToFirst()) {
            return true;
        }else{
            return false;
        }
    }


}
