package com.example.practicacomerciosadmin.modelos;

public class Usuarios {

    String nombre;
    String id;
    Tarjeta tarjeta;

    public Usuarios(String nombre, String id, Tarjeta tarjeta) {
        this.nombre = nombre;
        this.id = id;
        this.tarjeta = tarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
