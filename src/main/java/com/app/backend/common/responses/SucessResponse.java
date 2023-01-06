package com.app.backend.common.responses;

public class SucessResponse extends Response {

  public SucessResponse(String message, Object data) {
    super(false, message, data);
  }

  @Override
  public String toString() {
    String data;

    data = "{\n";
    data += "\tmessage: " + this.message + ", \n";
    data += "\tdata: " + this.data + ", \n";
    data += "}";

    return data;
  }
}
