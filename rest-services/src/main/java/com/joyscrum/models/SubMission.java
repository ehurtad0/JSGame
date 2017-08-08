package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo que representa las misiones secundarias de cada misión principal
 */
@XmlRootElement
@Embedded
public class SubMission implements Serializable {
    private ObjectId missionId;

    @Property("nombremision")
    private String nombreMision;

    @Property("tipomision")
    private int tipoMision;

    @Property("valormision")
    private double valorMision;

    @Property("posicionmision")
    private int posicionMision;

    @Property("puntosMision")
    private double puntosMision;

    @Property("detalleMision")
    List<SubMission> detalleMision;

    public ObjectId getMissionId() {
        return missionId;
    }

    public void setMissionId(ObjectId missionId) {
        this.missionId = missionId;
    }

    public String getNombreMision() {
        return nombreMision;
    }

    public void setNombreMision(String nombreMision) {
        this.nombreMision = nombreMision;
    }

    public int getTipoMision() {
        return tipoMision;
    }

    public void setTipoMision(int tipoMision) {
        this.tipoMision = tipoMision;
    }

    public double getValorMision() {
        return valorMision;
    }

    public void setValorMision(double valorMision) {
        this.valorMision = valorMision;
    }

    public int getPosicionMision() {
        return posicionMision;
    }

    public void setPosicionMision(int posicionMision) {
        this.posicionMision = posicionMision;
    }

    public double getPuntosMision() {
        return puntosMision;
    }

    public void setPuntosMision(double puntosMision) {
        this.puntosMision = puntosMision;
    }

    public List<SubMission> getDetalleMision() {
        return detalleMision;
    }

    public void setDetalleMision(List<SubMission> detalleMision) {
        this.detalleMision = detalleMision;
    }
}

