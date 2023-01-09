package com.app.frontend.users.utils.input;

import com.app.backend.users.dtos.UserDTO;
import com.app.frontend.common.input.Input;

public class UserInput extends Input {
  public UserInput() {
    super();
  }

  public UserDTO readUserDTO() {
    UserDTO userDTO;
    String name;
    String email;

    name = this.readString("Enter the name:");
    email = this.readString("Enter the email:");

    userDTO = new UserDTO(name, email);

    return userDTO;
  }
}
