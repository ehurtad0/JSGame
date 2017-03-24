package com.joyscrum.model;

import org.bson.types.ObjectId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represent a success.
 *
 * @author Alexandre Perusset
 */
/*
@NamedQueries({
  @NamedQuery(
          name = "findAllSuccess",
          query = "select s from Success s where s.application.id = :appid"
  )
})*/
@Entity
public class Success implements Serializable {

    @Id
    private ObjectId id;

    private String name;

    private String badge;

    @ManyToMany(fetch = FetchType.LAZY)
    private final List<Rule> rules;

    @ManyToOne
    private Application application;

    public Success() {
        name = "UNDEF";
        badge = "UNDEF";
        rules = new LinkedList<>();
    }

    public Success(Success success) {
        name = success.name;
        badge = success.badge;
        rules = success.rules;
        application = success.application;
    }

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

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public Application getApplication() {
        return this.application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Success) || this.id == null) {
            return false;
        }
        Success other = (Success) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "com.joyscrum.model.Success[id=" + id + "]";
    }
}
