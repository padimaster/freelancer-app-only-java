package com.app.backend.common.errors;

public class BadRequestException extends Exception {
  private static final long serialVersionUID = 1L;

  public BadRequestException() {
    super("Bad Request");
  }
}
