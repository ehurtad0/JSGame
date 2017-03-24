package com.joyscrum.gamification.to;

import java.io.Serializable;

/**
 * This is a generic TO when you want to pass through JSON a simple ID and not
 * the whole representation.
 *
 * @author Gaël Jobin
 */
public class GenericOnlyIDTO implements Serializable {

  private String id;

  public GenericOnlyIDTO() {
  }

  public GenericOnlyIDTO(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
