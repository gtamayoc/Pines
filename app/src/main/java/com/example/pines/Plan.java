package com.example.pines;

import java.io.Serializable;

public class Plan implements Serializable {
     int  codigo;
     String  nombre, valor, duracion, descripcion,nombre_pin;

    Integer imagen;

    public Plan(int codigo, String nombre, String valor, String duracion, String descripcion, String nombre_pin, Integer imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.nombre_pin = nombre_pin;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", valor='" + valor + '\'' +
                ", duracion='" + duracion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nombre_pin='" + nombre_pin + '\'' +
                ", imagen=" + imagen +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_pin() {
        return nombre_pin;
    }

    public void setNombre_pin(String nombre_pin) {
        this.nombre_pin = nombre_pin;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }
}
