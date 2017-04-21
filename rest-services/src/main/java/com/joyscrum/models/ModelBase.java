package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Transient;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jorge Mota
 * on 3/28/17.
 */
@XmlRootElement
public abstract class ModelBase {
    abstract ObjectId getId();

    @Transient
    private String pk;

    abstract void setId(ObjectId id);

    public String getPk() {
        return getId().toHexString();
    }
}
