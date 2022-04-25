package com.example.pines;

import java.io.Serializable;

public class Paquete implements Serializable {

    int id;
    Integer imagen;
    String nombrePin, descripcionPin, cantPin;


    public Paquete(int id, Integer imagen, String nombrePin, String descripcionPin, String cantPin) {
        this.id = id;
        this.imagen = imagen;
        this.nombrePin = nombrePin;
        this.descripcionPin = descripcionPin;
        this.cantPin = cantPin;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "id=" + id +
                ", imagen=" + imagen +
                ", nombrePin='" + nombrePin + '\'' +
                ", descripcionPin='" + descripcionPin + '\'' +
                ", cantPin='" + cantPin + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePin() {
        return nombrePin;
    }

    public void setNombrePin(String nombrePin) {
        this.nombrePin = nombrePin;
    }

    public String getDescripcionPin() {
        return descripcionPin;
    }

    public void setDescripcionPin(String descripcionPin) {
        this.descripcionPin = descripcionPin;
    }

    public String getCantPin() {
        return cantPin;
    }

    public void setCantPin(String cantPin) {
        this.cantPin = cantPin;
    }

    public Integer getImagen() {
        return imagen;
    }
    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }
}
