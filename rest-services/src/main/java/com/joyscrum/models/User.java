package com.joyscrum.models;

import org.bson.types.ObjectId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jorge Mota
 * on 3/16/17.
 */
@Entity
@XmlRootElement
public class User {
    @Id
    private ObjectId id;

    private String userName;

}
