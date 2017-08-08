package com.joyscrum.models;

import org.bson.types.ObjectId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 Modelo para representar un usuario en la app.
 */
@Entity
@XmlRootElement
public class User {
    @Id
    private ObjectId id;

    private String userName;

}
