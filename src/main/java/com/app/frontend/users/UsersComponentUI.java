package com.app.frontend.users;

import com.app.backend.common.responses.Response;
import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.users.services.UsersServicesUI;
import com.app.frontend.users.utils.input.UserInput;
import com.app.frontend.users.utils.output.UserOutput;

public class UsersComponentUI {
  private UsersServicesUI usersServicesUI;
  private UserInput userInput;
  private UserOutput userOutput;
  private UserEntity admin;

  // public UsersComponentUI(UserEntity admin, UsersController usersController) {
  // this.usersServicesUI = new UsersServicesUI(usersController);
  // this.userInput = new UserInput();
  // this.userOutput = new UserOutput();
  // this.admin = admin;
  // }

  public UsersComponentUI(UsersServicesUI usersServicesUI) {
    this.usersServicesUI = usersServicesUI;
    this.userInput = new UserInput();
    this.userOutput = new UserOutput();
  }

  public void createUser() {
    Response response;
    UserDTO createUserDTO;

    createUserDTO = this.userInput.readUserDTO();

    response = this.usersServicesUI.createUser(createUserDTO);

    this.userOutput.printResponse(response);
  }

  public void getUserById() {
    Response response;
    String userId;

    userId = this.userInput.readString("Enter the user id:");

    response = this.usersServicesUI.getUserById(userId);

    this.userOutput.printResponse(response);
  }

  public void getAllUsers() {
    Response response;

    response = this.usersServicesUI.getAll();

    this.userOutput.printResponse(response);
  }

  public void updateUser() {
    Response response;
    String userId;
    UserDTO updateUserDTO;

    userId = this.userInput.readString("Enter the user id:");
    updateUserDTO = this.userInput.readUserDTO();

    response = this.usersServicesUI.update(userId, updateUserDTO);

    this.userOutput.printResponse(response);
  }

  public void deleteUser() {
    Response response;
    String userId;

    userId = this.userInput.readString("Enter the user id:");

    response = this.usersServicesUI.delete(userId);

    this.userOutput.printResponse(response);
  }
}
