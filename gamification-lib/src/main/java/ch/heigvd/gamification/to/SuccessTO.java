package ch.heigvd.gamification.to;

import java.io.Serializable;

/**
 * Success transfert object. This class is used to transfer to the api user,
 * create or update successes remotly or via jax-rs api.
 *
 * @author Alexandre Perusset
 */
public class SuccessTO implements Serializable {

  private String id;

  private String name;

  private String badge;

  public SuccessTO() {
  }

  public SuccessTO(String id, String name, String badge) {
    this.id = id;
    this.name = name;
    this.badge = badge;
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

  public String getBadge() {
    return badge;
  }

  public void setBadge(String badge) {
    this.badge = badge;
  }
}
