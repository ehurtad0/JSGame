package com.joyscrum.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jorge Mota
 * on 3/11/17.
 */
@XmlRootElement(name = "Bean Demo")
@XmlAccessorType(XmlAccessType.FIELD)

public class BeanExample {
    public BeanExample(){

    }
    private String name;
    private String who;

    public String getName(){
        return name;
    }
    public String getWho(){
        return who;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setWho(String who){
        this.who= who;
    }
}
