package com.app.backend.auth.controllers;

import com.app.backend.auth.services.AuthService;
import com.app.backend.common.responses.ErrorResponse;
import com.app.backend.common.responses.Response;
import com.app.backend.common.responses.SucessResponse;
import com.app.backend.users.entities.UserEntity;

public class AuthController {
  private static AuthController authController = null;
  private AuthService authService;

  private AuthController() {
    authService = AuthService.getInstance();
  }

  public static AuthController getInstance() {
    if (authController == null) {
      authController = new AuthController();
    }
    return authController;
  }

  public Response login(String id, String password) {
    Response response;
    UserEntity user;

    try {
      user = authService.validateUser(id, password);
      response = new SucessResponse("Successfully", user);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }
}
