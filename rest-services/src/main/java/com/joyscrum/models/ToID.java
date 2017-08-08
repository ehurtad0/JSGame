package com.joyscrum.models;

/**
 * Modelo temporal para pasar un identificador de entidad.
 */

public class ToID {
    public ToID(String hexValue){
        this.hexString= hexValue;
    }
    public ToID(){

    }
    private String hexString;

    public String getHexString() {
        return hexString;
    }

    public void setHexString(String hexString) {
        this.hexString = hexString;
    }
}
