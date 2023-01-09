package com.app.frontend.users.components;

import com.app.backend.common.responses.Response;
import com.app.backend.users.dtos.UserDTO;
import com.app.frontend.users.services.UsersServicesUI;
import com.app.frontend.users.utils.input.UserInput;
import com.app.frontend.users.utils.output.UserOutput;

public class UsersComponentUI {
  private UsersServicesUI usersServicesUI;
  private UserInput userInput;
  private UserOutput userOutput;

  // public UsersComponentUI(UserEntity admin, UsersController usersController) {
  // this.usersServicesUI = new UsersServicesUI(usersController);
  // this.userInput = new UserInput();
  // this.userOutput = new UserOutput();
  // this.admin = admin;
  // }

  public UsersComponentUI(UsersServicesUI usersServicesUI) {
    this.userInput = new UserInput();
    this.usersServicesUI = usersServicesUI;
    this.userOutput = new UserOutput();
  }

  public void create() {
    Response response;
    UserDTO createUserDTO;

    createUserDTO = this.userInput.readUserDTO();

    response = this.usersServicesUI.create(createUserDTO);

    this.userOutput.printResponse(response);
  }

  public void getById() {
    Response response;
    String userId;

    userId = this.userInput.readString("Enter the user id:");

    response = this.usersServicesUI.getUserById(userId);

    this.userOutput.printResponse(response);
  }

  public void getAll() {
    Response response;

    response = this.usersServicesUI.getAll();

    this.userOutput.printResponse(response);
  }

  public void update() {
    Response response;
    String userId;
    UserDTO updateUserDTO;

    userId = this.userInput.readString("Enter the user id:");
    updateUserDTO = this.userInput.readUserDTO();

    response = this.usersServicesUI.update(userId, updateUserDTO);

    this.userOutput.printResponse(response);
  }

  public void delete() {
    Response response;
    String userId;

    userId = this.userInput.readString("Enter the user id:");

    response = this.usersServicesUI.delete(userId);

    this.userOutput.printResponse(response);
  }
}
