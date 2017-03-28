package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


/**
 * Created by Jorge Mota
 * on 3/27/17.
 */
@Entity("Equipo")
public class Team extends ModelBase {
    @Id
    private ObjectId id;

    private int index;
    private String guid;
    private String nombreEquipo;
    private long puntos;
    private String logoEquipo;
    private double progresoEquipo;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public long getPuntos() {
        return puntos;
    }

    public void setPuntos(long puntos) {
        this.puntos = puntos;
    }

    public String getLogoEquipo() {
        return logoEquipo;
    }

    public void setLogoEquipo(String logoEquipo) {
        this.logoEquipo = logoEquipo;
    }

    public double getProgresoEquipo() {
        return progresoEquipo;
    }

    public void setProgresoEquipo(double progresoEquipo) {
        this.progresoEquipo = progresoEquipo;
    }

}
