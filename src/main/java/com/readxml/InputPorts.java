package com.readxml;

/**
 * Created by mshaik on 1/31/19.
 */
public class InputPorts {
  private String id;
  private String parentGroupId;
  Position PositionObject;
  private String comments;
  private String concurrentlySchedulableTaskCount;
  private String name;
  private String state;
  private String type;


  // Getter Methods

  public String getId() {
    return id;
  }

  public String getParentGroupId() {
    return parentGroupId;
  }

  public Position getPosition() {
    return PositionObject;
  }

  public String getComments() {
    return comments;
  }

  public String getConcurrentlySchedulableTaskCount() {
    return concurrentlySchedulableTaskCount;
  }

  public String getName() {
    return name;
  }

  public String getState() {
    return state;
  }

  public String getType() {
    return type;
  }

  // Setter Methods

  public void setId(String id) {
    this.id = id;
  }

  public void setParentGroupId(String parentGroupId) {
    this.parentGroupId = parentGroupId;
  }

  public void setPosition(Position positionObject) {
    this.PositionObject = positionObject;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public void setConcurrentlySchedulableTaskCount(String concurrentlySchedulableTaskCount) {
    this.concurrentlySchedulableTaskCount = concurrentlySchedulableTaskCount;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setType(String type) {
    this.type = type;
  }
}
