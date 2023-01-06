package com.app.backend.common.responses;

public class Response {
  protected boolean error;
  protected String message;
  protected Object data;

  public Response(boolean error, String message, Object data) {
    this.error = error;
    this.message = message;
    this.data = data;
  }

  public boolean getError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @Override
  public String toString() {
    String response;

    response = "{\n";
    response += "\tid: " + error + ", \n";
    response += "\tname: " + message + ", \n";
    response += "\temail: " + data + ", \n";
    response += "}";

    return response;
  }

}
