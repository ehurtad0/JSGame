package ch.heigvd.gamification.to;

import java.io.Serializable;

/**
 * Action transfert object. This class is used to transfer to the api user,
 * create or update actions remotly or via jax-rs api.
 *
 * @author Gaël Jobin
 */
public class AppActionTO implements Serializable {

  private String id;

  private String title;

  private int points;

  private String description;

  public AppActionTO() {
  }

  public AppActionTO(String id, String title, int points, String description) {
    this.id = id;
    this.title = title;
    this.points = points;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
}
