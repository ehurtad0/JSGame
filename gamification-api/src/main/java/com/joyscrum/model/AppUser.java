package com.joyscrum.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This class is represent a user.
 *
 */
/*@NamedQueries({
  @NamedQuery(
          name = "findAllUsers",
          query = "select u from AppUser u where u.application.id = :appid"
  ),
  @NamedQuery(
          name = "findAllWithSuccess",
          query = "select u from AppUser u inner join u.successes s where s.id = :successid"
  )
})
*/
@Entity
public class AppUser implements Serializable {

  @Id                                               //ID field
  private String id;

  private String name;

  private String surname;

  //If we don't want a nullable field
  @Column(nullable = false)
  private String nickname;

  private String password;

  //Load success only on demand
  @ManyToMany(fetch = FetchType.LAZY)
  private final List<Success> successes;

  //Load events only on demand
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private final List<Event> events;

  @ManyToOne
  private Application application;

  public AppUser() {
    name = "UNDEF";
    surname = "UNDEF";
    nickname = "UNDEF";
    password = "UNDEF";
    successes = new LinkedList<>();
    events = new LinkedList<>();
  }

  public AppUser(AppUser user) {
    name = user.name;
    surname = user.surname;
    nickname = user.nickname;
    password = user.password;
    successes = user.successes;
    events = user.events;
    application = user.application;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Success> getSuccesses() {
    return successes;
  }
  
  public void addSuccess(Success newSuccess) {
    this.successes.add(newSuccess);
  }

  public List<Event> getEvents() {
    return events;
  }

  public void addEvent(Event event) {
    events.add(event);
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
    if (!(object instanceof AppUser) || this.id == null) {
      return false;
    }
    AppUser other = (AppUser)object;
    return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
  }

  @Override
  public String toString() {
    return "com.joyscrum.model.AppUser[id=" + id + "]";
  }
}
