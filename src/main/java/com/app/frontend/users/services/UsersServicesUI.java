package com.app.frontend.users.services;

import com.app.backend.common.responses.Response;
import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.dtos.UserDTO;

public class UsersServicesUI {
  private UsersController usersController;

  public UsersServicesUI() {
    this.usersController = UsersController.getInstance();
  }

  public Response createUser(UserDTO creaUserDTO) {
    Response response;
    response = this.usersController.create(creaUserDTO);

    return response;
  }

  public Response getUserById(String userId) {
    Response response;
    response = this.usersController.getById(userId);

    return response;
  }

  public Response getAllUsers() {
    Response response;
    response = this.usersController.getAll();

    return response;
  }

  public Response updateUser(String userId, UserDTO updateUserDTO) {
    Response response;
    response = this.usersController.update(userId, updateUserDTO);

    return response;
  }

  public Response deleteUser(String userId) {
    Response response;
    response = this.usersController.delete(userId);

    return response;
  }
}
