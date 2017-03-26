package com.joyscrum.gamification.to;

import java.io.Serializable;

/**
 * Application transfert object. This class is used to transfer to the api user,
 * create or update applications remotly or via jax-rs api.
 *
 * @author Thomas Moegli
 */
public class ApplicationTO implements Serializable {

  private String id;

  private String name;

  public ApplicationTO() {
  }

  public ApplicationTO(String id, String name) {
    this.id = id;
    this.name = name;
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
}
