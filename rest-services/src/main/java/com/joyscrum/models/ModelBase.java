package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Transient;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Clase abstracta base para casi todos los modelos de datos
 */
@XmlRootElement
public abstract class ModelBase implements Serializable {
    abstract ObjectId getId();

    @Transient
    private String pk;

    abstract void setId(ObjectId id);

    public String getPk() {
        return getId().toHexString();
    }
}
