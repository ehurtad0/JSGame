package ch.heigvd.gamification.to;

import java.io.Serializable;

/**
 * Ranked user transfert object. This class is used to transfer to the api user
 * users remotly or via jax-rs api. The users are ranked, that means the total
 * number of acquired points is computed. This transfert object is typically
 * used with the leaderboard.
 *
 * @author Alexandre Perusset
 */
public class RankedAppUserTO implements Serializable {

  private String id;

  private int points;

  private String name;

  private String surname;

  private String nickname;

  public RankedAppUserTO() {
  }

  public RankedAppUserTO(String id, int points, String name, String surname, String nickname) {
    this.id = id;
    this.points = points;
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

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
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
