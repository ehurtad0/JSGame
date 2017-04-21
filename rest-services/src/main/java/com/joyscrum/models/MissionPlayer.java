package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by  Jorge Mota
 * on 4/5/17.
 */
@Entity("MisionJugador")
@XmlRootElement
public class MissionPlayer {
    @Id
    private ObjectId id;

    private String guid;

    private Player player;
    @Property("jugador_id")
    private String playerId;
    private Mission mission;
    @Property("mision_id")
    private String missionId;
    private double progreso;
    private double puntos;
    private boolean completa;
    private double riesgo;
    private double avance;
    private Date inicio;
    private Date fin;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Player getPlayer() {
        return player;
    }


    public Mission getMission() {
        return mission;
    }


    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public double getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(double riesgo) {
        this.riesgo = riesgo;
    }

    public double getAvance() {
        return avance;
    }

    public void setAvance(double avance) {
        this.avance = avance;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }
}
