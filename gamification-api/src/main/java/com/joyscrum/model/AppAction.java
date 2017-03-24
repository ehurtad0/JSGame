package com.joyscrum.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
/*import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
*/
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This class is an Action. An action can be performed by a user. When a user
 * perform an action, this is called an Event.
 *
 */
/*@NamedQueries({
  @NamedQuery(
          name = "findAllAppActions",
          query = "select a from AppAction a where a.application.id = :appid"
  ),
  @NamedQuery(
          name = "findAllActionPointsForUser",
          query = "select a, sum(a.points) as points "
          + "from AppUser u inner join u.events e inner join e.action a "
          + "where u.id = :userid group by a"
  )
})*/
@Entity
public class AppAction implements Serializable {

  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
  private ObjectId id;

  private String title;

  private int points;

  private String description;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "action")
  private final List<Rule> rules;

  @ManyToOne
  private Application application;

  public AppAction() {
    title = "UNDEF";
    points = -1;
    description = "UNDEF";
    rules = new LinkedList<>();
  }

  public AppAction(AppAction action) {
    this.title = action.title;
    this.points = action.points;
    this.description = action.description;
    this.application = action.application;
    this.rules = action.rules;
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPoints() {
    return this.points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
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
    if (!(object instanceof AppAction) || this.id == null) {
      return false;
    }
    AppAction other = (AppAction) object;
    return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
  }

  @Override
  public String toString() {
    return "com.joyscrum.model.AppAction[id=" + id + "]";
  }
}
