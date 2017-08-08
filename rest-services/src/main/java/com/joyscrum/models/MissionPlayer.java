package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Transient;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Modelo que representa las misiones asignadas a un jugador
 * Almacena el progreso, puntos, etc.
 */
@Entity("MisionJugador")
@XmlRootElement
public class MissionPlayer extends ModelBase {
    @Id
    private ObjectId id;

    private String guid;
    @Transient
    private Player player;
    @Property("jugador_id")
    private String playerId;

    private Mission mission;
    @Property("mision_id")
    private String missionId;
    @Property("rol_id")
    private String rolId;

    private double progreso;
    private double puntos;
    @Property("misionCompleta")
    private boolean completa;
    private double riesgoMision;
    @Property("fechaIni")
    private Date inicio;
    @Property("fechaFin")
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

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
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

    public double getRiesgoMision() {
        return riesgoMision;
    }

    public void setRiesgoMision(double riesgoMision) {
        this.riesgoMision = riesgoMision;
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

    public void sumarProgreso(double progress) {
        this.progreso += progress;
        if (this.progreso >= 99.899999) {
            this.setCompleta(true);
            this.progreso = 100;
        }
    }

    public void sumarPuntos(double puntos) {
        this.puntos += puntos;

    }
}
