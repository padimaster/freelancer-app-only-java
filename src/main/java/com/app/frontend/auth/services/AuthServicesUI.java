package com.app.frontend.auth.services;

import com.app.backend.auth.controllers.AuthController;

public class AuthServicesUI {
  AuthController authController;

  public AuthServicesUI(AuthController authController) {
    this.authController = authController;
  }

  public void login(String email, String password) {
    this.authController.login(email, password);
  }

}
