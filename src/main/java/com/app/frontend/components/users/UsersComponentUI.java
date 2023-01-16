package com.app.frontend.components.users;

import com.app.backend.common.responses.Response;
import com.app.backend.users.dtos.UserDTO;
import com.app.frontend.common.input.UserInput;
import com.app.frontend.services.UsersServiceUI;

public class UsersComponentUI {
  private UsersServiceUI usersServicesUI;
  private UserInput userInput;

  // public UsersComponentUI(UserEntity admin, UsersController usersController) {
  // this.usersServicesUI = new UsersServicesUI(usersController);
  // this.userInput = new UserInput();
  // this.userOutput = new UserOutput();
  // this.admin = admin;
  // }

  public UsersComponentUI(UsersServiceUI usersServicesUI) {
    this.userInput = new UserInput();
    this.usersServicesUI = usersServicesUI;
  }

  public void create() {
    Response response;
    UserDTO createUserDTO;

    // Create user dto from user input
    createUserDTO = this.userInput.readUserDTO();

    // Response from users service UI
    response = this.usersServicesUI.create(createUserDTO);

    // Print response
    System.out.println(response);
  }

  public void getById() {
    Response response;
    String userId;

    userId = this.userInput.readString("Enter the user id:");

    response = this.usersServicesUI.getUserById(userId);

    System.out.println(response);
  }

  public void getAll() {
    Response response;

    response = this.usersServicesUI.getAll();

    System.out.println(response);
  }

  public void update() {
    Response response;
    String userId;
    UserDTO updateUserDTO;

    userId = this.userInput.readString("Enter the user id:");
    updateUserDTO = this.userInput.readUserDTO();

    response = this.usersServicesUI.update(userId, updateUserDTO);

    System.out.println(response);
  }

  public void delete() {
    Response response;
    String userId;

    userId = this.userInput.readString("Enter the user id:");

    response = this.usersServicesUI.delete(userId);

    System.out.println(response);
  }
}
