package com.app.backend.common.responses;

public class SuccessResponse extends Response {

  public SuccessResponse(String message, Object data) {
    super(false, message, data);
  }

}
