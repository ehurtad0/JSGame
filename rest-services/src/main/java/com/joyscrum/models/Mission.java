package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jorge Mota
 * on 3/24/17.
 */
@Entity("Mision")
@XmlRootElement

public class Mission extends ModelBase {
    @Id
    private ObjectId id;
    private int tipomision;
    private String nombremision;

    private Rol rol;

    @Property("rol_id")
    private String rolId;

    @Property("valorMision")
    private int valor;
    @Property("posicionMision")

    private int posicion;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public Rol getRol() {
        return rol;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }
}
