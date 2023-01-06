package com.app.backend.common.validators;

public class ClassValidator {
  public static boolean isString(String value) {
    return value != null && !value.isEmpty();
  }

  public static boolean isInteger(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean isEmail(String value) {
    return value != null && value.matches("^[A-Za-z0-9+_.-]+@(.+)$");
  }
}
