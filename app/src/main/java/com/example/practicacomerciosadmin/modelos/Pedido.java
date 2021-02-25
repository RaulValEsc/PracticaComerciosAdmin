package com.example.practicacomerciosadmin.modelos;

public class Pedido {

    String idCom,idProd,idUser;
    int cantidad;
    boolean entrega = false;

    public Pedido(String idCom, String idProd, String idUser, int cantidad, boolean entrega) {
        this.idCom = idCom;
        this.idProd = idProd;
        this.idUser = idUser;
        this.cantidad = cantidad;
        this.entrega = entrega;
    }

    public String getIdCom() {
        return idCom;
    }

    public void setIdCom(String idCom) {
        this.idCom = idCom;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }
}
