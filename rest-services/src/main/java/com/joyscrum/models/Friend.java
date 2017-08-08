package com.joyscrum.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.xml.bind.annotation.XmlRootElement;

/**
Define el modelo de datos para amigos invitados desde la app.
 */
@Entity
@XmlRootElement
public class Friend  extends ModelBase {
    @Id
    private ObjectId id;

    private String name;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
