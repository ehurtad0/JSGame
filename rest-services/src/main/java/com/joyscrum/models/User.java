package com.joyscrum.models;

import org.bson.types.ObjectId;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Jorge Mota
 * on 3/16/17.
 */
@Entity
public class User {
    @Id
    private ObjectId id;

    private String userName;

}
