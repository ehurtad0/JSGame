package com.joyscrum.model;

import java.io.Serializable;
import javax.persistence.ManyToOne;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * This class represent a rule.
 * 
 * @author Gaël Jobin
 */
/*
@NamedQueries({
  @NamedQuery(
          name = "findAllRules",
          query = "select r from Rule r where r.application.id = :appid"
  ),
  @NamedQuery(
          name = "findAllRulesForAction",
          query = "select r from AppAction a inner join a.rules r where a.id = :actionid"
  )
})*/
@Entity
public class Rule implements Serializable {

  @Id
  private ObjectId id;

  private String name;
  
  private String description;
  
  private int goalPoints;

  @ManyToOne
  private AppAction action;
  
  @ManyToOne
  private Application application;

  public Rule() {
    name = "UNDEF";
    description = "UNDEF";
    goalPoints = -1;
    action = null;
  }

  public Rule(Rule rule) {
    this.name = rule.name;
    this.description = rule.description;
    this.goalPoints = rule.goalPoints;
    this.action = rule.action;
    this.application = rule.application;
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getGoalPoints() {
    return this.goalPoints;
  }

  public void setGoalPoints(int acquiredPoints) {
    this.goalPoints = acquiredPoints;
  }
  
  public AppAction getAction() {
    return this.action;
  }

  public void setAction(AppAction action) {
    this.action = action;
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
    if (!(object instanceof Rule) || this.id == null) {
      return false;
    }
    Rule other = (Rule)object;
    return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
  }

  @Override
  public String toString() {
    return "com.joyscrum.model.Rule[id=" + id + "]";
  }
}
