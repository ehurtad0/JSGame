package com.joyscrum.models;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

/**
 * Created by Jorge Mota
 * on 3/27/17.
 */
@Embedded
public class RolPlayer {
    @Reference
    private Rol rol;

    private int index;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
