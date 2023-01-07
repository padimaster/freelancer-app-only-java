package com.app.backend.common.validators;

import com.app.backend.users.dtos.UserDTO;
import com.app.common.validators.ClassValidator;

public class UserValidator {
  public static boolean isCreateUserDTO(UserDTO user) {
    String name;
    String email;
    String password;

    if (user == null) {
      return false;
    }

    name = user.getName();
    email = user.getEmail();
    password = user.getPassword();

    if (!ClassValidator.isString(name)) {
      return false;
    }

    if (!ClassValidator.isEmail(email)) {
      return false;
    }

    if (!ClassValidator.isString(password)) {
      return false;
    }

    return true;
  }

  public static boolean isUpdateUserDTO(UserDTO userDTO) {
    String name;
    String email;
    String password;

    if (userDTO == null) {
      return false;
    }

    name = userDTO.getName();
    email = userDTO.getEmail();
    password = userDTO.getPassword();

    if (name != null && !name.isBlank() && !ClassValidator.isString(name)) {
      return false;
    }

    if (email != null && !email.isBlank() && !ClassValidator.isEmail(email)) {
      return false;
    }

    if (password != null && !password.isBlank() && !ClassValidator.isString(password)) {
      return false;
    }

    return true;
  }
}
