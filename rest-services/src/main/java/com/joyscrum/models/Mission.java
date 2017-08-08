package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Modelo que representa la tabla Mision
 */
@Entity("Mision")
@XmlRootElement

public class Mission extends ModelBase {
    @Id
    private ObjectId id;

    private int index;
    private String guid;
    private int tipomision;
    private String nombremision;

    @Property("rol_id")
    private String rolId;
    @Transient
    private Rol rol;

    @Property("valormision")
    private double valor;
    @Property("posicionmision")
    private int posicionMision;
    @Property("puntosmision")
    private int puntosMision;
    @Embedded
    private List<SubMission> detalleMision;

    @Transient
    private double riesgo;

    public Mission() {

    }

    public Mission(com.mongodb.BasicDBObject dbo) {
        if (dbo.containsField("nombremision")) {
            this.nombremision = dbo.getString("nombremision");
        }
        if (dbo.containsField("tipomision")) {
            this.tipomision = dbo.getInt("tipoMision");
        }
        if (dbo.containsField("_id")) {
            this.id = new ObjectId(dbo.getString("_id"));
        }
        if (dbo.containsField("valormision")) {
            this.valor = dbo.getDouble("valormision");
        }
        if (dbo.containsField("puntosMision")) {
            this.puntosMision = dbo.getInt("puntosMision");
        }
        if (dbo.containsField("posicionmision")) {
            this.posicionMision = dbo.getInt("posicionmision");
        }

    }

    public Mission(Map dbo) {
        if (dbo.containsKey("nombremision")) {
            this.nombremision = (String) dbo.get("nombremision");
        }
        if (dbo.containsKey("tipomision")) {
            this.tipomision = (Integer) dbo.get("tipoMision");
        }
        if (dbo.containsKey("_id")) {
            this.id = new ObjectId((String) dbo.get("_id"));
        }
        if (dbo.containsKey("valormision")) {
            this.valor = (double) dbo.get("valormision");
        }
        if (dbo.containsKey("puntosMision")) {
            this.puntosMision = (int) dbo.get("puntosMision");
        }
        if (dbo.containsKey("posicionmision")) {
            this.posicionMision = (int) dbo.get("posicionmision");
        }

    }


    public ObjectId getId() {
        return id;
    }

    @Override
    void setId(ObjectId id) {
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

    public int getTipomision() {
        return tipomision;
    }

    public void setTipomision(int tipomision) {
        this.tipomision = tipomision;
    }

    public String getNombremision() {
        return nombremision;
    }

    public void setNombremision(String nombremision) {
        this.nombremision = nombremision;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPosicionMision() {
        return posicionMision;
    }

    public void setPosicionMision(int posicionMision) {
        this.posicionMision = posicionMision;
    }

    public int getPuntosMision() {
        return puntosMision;
    }

    public void setPuntosMision(int puntosMision) {
        this.puntosMision = puntosMision;
    }

    public List<SubMission> getDetalleMision() {
        return detalleMision;
    }

    public void setDetalleMision(List<SubMission> detalleMision) {
        this.detalleMision = detalleMision;
    }

    public double getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(double riesgo) {
        this.riesgo = riesgo;
    }
}
