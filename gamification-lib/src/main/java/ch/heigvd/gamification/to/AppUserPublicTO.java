package ch.heigvd.gamification.to;

import java.io.Serializable;

/**
 * Public user transfert object. This class is used to transfert users to the
 * api user remotly or via jax-rs api.
 *
 * @author Alexandre Perusset
 */
public class AppUserPublicTO implements Serializable {

  private String id;

  private String name;

  private String surname;

  private String nickname;

  public AppUserPublicTO() {
  }

  public AppUserPublicTO(String id, String name, String surname, String nickname) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
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
}
