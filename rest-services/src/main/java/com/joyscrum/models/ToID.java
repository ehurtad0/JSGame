package com.joyscrum.models;

/**
 * Created by Jorge Mota
 * on 3/27/17.
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
