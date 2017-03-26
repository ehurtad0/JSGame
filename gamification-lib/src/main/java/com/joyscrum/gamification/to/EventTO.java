package com.joyscrum.gamification.to;

import java.io.Serializable;

/**
 * Event transfert object. This class is used to transfer to the api user or
 * create events remotly or via jax-rs api. It is not possible to update an
 * existing event.
 *
 * @author Alexandre Perusset
 */
public class EventTO implements Serializable {

  private String id;

  private String userId;

  private String actionId;

  private long timestamp;

  public EventTO() {
  }

  public EventTO(String id, String userId, String actionId, long timestamp) {
    this.id = id;
    this.userId = userId;
    this.actionId = actionId;
    this.timestamp = timestamp;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getActionId() {
    return actionId;
  }

  public void setActionId(String actionId) {
    this.actionId = actionId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
