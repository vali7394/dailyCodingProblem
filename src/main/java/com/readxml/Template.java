package com.readxml;

/**
 * Created by mshaik on 1/31/19.
 */public class Template {
  private String description;
  private String groupId;
  private String name;
  Snippet SnippetObject;
  private String timestamp;
  /*private String _encoding - version;*/


  // Getter Methods

  public String getDescription() {
    return description;
  }

  public String getGroupId() {
    return groupId;
  }

  public String getName() {
    return name;
  }

  public Snippet getSnippet() {
    return SnippetObject;
  }

  public String getTimestamp() {
    return timestamp;
  }

  /*public String get_encoding - version() {
    return _encoding - version;
  }*/

  // Setter Methods

  public void setDescription(String description) {
    this.description = description;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSnippet(Snippet snippetObject) {
    this.SnippetObject = snippetObject;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  /*public void set_encoding - version(String _encoding - version) {
    this._encoding - version = _encoding - version;
  }*/
}
