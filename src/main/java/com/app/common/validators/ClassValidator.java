package com.app.common.validators;

public class ClassValidator {
  public static boolean isString(String value) {
    return value != null && value.length() > 0;
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
    String regex;
    boolean isValid;

    regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    isValid = value != null && value.matches(regex);

    return isValid;
  }
}
