package com.example.pines;

public class Trabajador {
    int id;
    String nombre, apellido, correo, nombreUsuario, contrasena, documento, saldo;

    public Trabajador(){}

    public Trabajador(int id, String nombre, String apellido, String correo, String nombreUsuario, String contrasena, String documento, String saldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.documento = documento;
        this.saldo = saldo;
    }

    public boolean isNull(){
        if(nombre.equals("")|| apellido.equals("")|| correo.equals("")|| nombreUsuario.equals("")|| contrasena.equals("")||documento.equals("")){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", documento='" + documento + '\'' +
                ", saldo='" + saldo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
