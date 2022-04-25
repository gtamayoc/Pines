package com.example.pines;

public class Historial {

    int id,fk_trabajador_id;
    String  descripcion,comprador_id, nombre_pin, nombre_plan, fecha_compra, hash_pin, valor_compra;

    public Historial(int id, int fk_trabajador_id, String descripcion, String comprador_id, String nombre_pin, String nombre_plan, String fecha_compra, String hash_pin, String valor_compra) {
        this.id = id;
        this.fk_trabajador_id = fk_trabajador_id;
        this.descripcion = descripcion;
        this.comprador_id = comprador_id;
        this.nombre_pin = nombre_pin;
        this.nombre_plan = nombre_plan;
        this.fecha_compra = fecha_compra;
        this.hash_pin = hash_pin;
        this.valor_compra = valor_compra;
    }

    public Historial() {

    }

    @Override
    public String toString() {
        return "Historial{" +
                "id=" + id +
                ", fk_trabajador_id=" + fk_trabajador_id +
                ", descripcion='" + descripcion + '\'' +
                ", comprador_id='" + comprador_id + '\'' +
                ", nombre_pin='" + nombre_pin + '\'' +
                ", nombre_plan='" + nombre_plan + '\'' +
                ", fecha_compra='" + fecha_compra + '\'' +
                ", hash_pin='" + hash_pin + '\'' +
                ", valor_compra='" + valor_compra + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_trabajador_id() {
        return fk_trabajador_id;
    }

    public void setFk_trabajador_id(int fk_trabajador_id) {
        this.fk_trabajador_id = fk_trabajador_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComprador_id() {
        return comprador_id;
    }

    public void setComprador_id(String comprador_id) {
        this.comprador_id = comprador_id;
    }

    public String getNombre_pin() {
        return nombre_pin;
    }

    public void setNombre_pin(String nombre_pin) {
        this.nombre_pin = nombre_pin;
    }

    public String getNombre_plan() {
        return nombre_plan;
    }

    public void setNombre_plan(String nombre_plan) {
        this.nombre_plan = nombre_plan;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getHash_pin() {
        return hash_pin;
    }

    public void setHash_pin(String hash_pin) {
        this.hash_pin = hash_pin;
    }

    public String getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(String valor_compra) {
        this.valor_compra = valor_compra;
    }
}
