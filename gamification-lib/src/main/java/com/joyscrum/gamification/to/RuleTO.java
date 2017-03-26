package com.joyscrum.gamification.to;

import java.io.Serializable;

/**
 * Rule transfert object. This class is used to transfer to the api user, create
 * or update rules remotly or via jax-rs api.
 *
 * @author Gaël Jobin
 */
public class RuleTO implements Serializable {

    private String id;

    private String name;

    private String description;

    private int goalPoints;

    private String actionID;

    public RuleTO() {
    }

    public RuleTO(String ruleId, String name, String description, int goalPoints, String actionID) {
        this.id = ruleId;
        this.name = name;
        this.description = description;
        this.goalPoints = goalPoints;
        this.actionID = actionID;
    }

    public String getId() {
        return id;
    }

    public void setId(String ruleId) {
        this.id = ruleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGoalPoints() {
        return goalPoints;
    }

    public void setGoalPoints(int goalPoints) {
        this.goalPoints = goalPoints;
    }

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }
}
