package com.example.practicacomerciosadmin.modelos;

public class Tarjeta {

    String id;
    float saldo;

    public Tarjeta(String id, float saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
