package com.app.backend.common.utils;

import com.app.backend.users.dtos.UserDTO;

public class Cleaner {
  public static UserDTO cleanBlanks(UserDTO userDTO) {
    String name;
    String email;
    String password;

    name = userDTO.getName();
    email = userDTO.getEmail();
    password = userDTO.getPassword();

    if (name != null && name.isBlank()) {
      userDTO.setName(null);
    }

    if (email != null && email.isBlank()) {
      userDTO.setEmail(null);
    }

    if (password != null && password.isBlank()) {
      userDTO.setPassword(null);
    }

    return userDTO;
  }
}
