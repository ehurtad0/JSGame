package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Jorge Mota
 * on 3/24/17.
 */
@Entity
public class Mission {
    @Id
    private ObjectId id;
    private String tipomision;
    private String nombremision;
    private String rol;
    private int valor;
    private int posicion;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTipomision() {
        return tipomision;
    }

    public void setTipomision(String tipomision) {
        this.tipomision = tipomision;
    }

    public String getNombremision() {
        return nombremision;
    }

    public void setNombremision(String nombremision) {
        this.nombremision = nombremision;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
