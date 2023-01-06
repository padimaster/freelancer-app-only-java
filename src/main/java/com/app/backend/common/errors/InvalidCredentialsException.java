package com.app.backend.common.errors;

public class InvalidCredentialsException extends Exception {
  private static final long serialVersionUID = 1L;

  public InvalidCredentialsException() {
    super("Invalid Credentials");
  }
}
