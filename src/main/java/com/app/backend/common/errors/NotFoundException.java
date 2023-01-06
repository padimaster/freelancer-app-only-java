package com.app.backend.common.errors;

public class NotFoundException extends Exception {
  private static final long serialVersionUID = 1L;

  public NotFoundException() {
    super("Not Found");
  }
}
