package com.app.backend.common.responses;

public class ErrorResponse extends Response {

  public ErrorResponse(String message) {
    super(true, message, null);
  }
}
