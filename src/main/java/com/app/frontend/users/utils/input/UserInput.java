package com.app.frontend.users.utils.input;

import com.app.backend.users.dtos.UserDTO;
import com.app.frontend.common.input.Input;

public class UserInput extends Input {
  public UserDTO readUserDTO() {
    UserDTO userDTO;
    String name;
    String email;
    String password;

    name = this.readString("Enter the name:");
    email = this.readString("Enter the email:");
    password = this.readString("Enter the password:");

    userDTO = new UserDTO(name, email, password);

    return userDTO;
  }
}
