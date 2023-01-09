package com.app.backend.auth;

import com.app.backend.auth.controllers.AuthController;
import com.app.backend.auth.repositories.AuthRepository;
import com.app.backend.auth.services.AuthService;
import com.app.backend.users.services.UsersService;

public class AuthModule {
  private AuthController authController;
  private AuthService authService;

  private static AuthModule instance = null;

  private AuthModule(AuthRepository authRepository, UsersService usersService) {
    AuthService.initInstance(authRepository, usersService);
    this.authService = AuthService.getInstance();

    AuthController.initInstance(authService);
    this.authController = AuthController.getInstance();
  }

  public static void initInstance(AuthRepository authRepository, UsersService usersService) {
    instance = new AuthModule(authRepository, usersService);
  }

  public static AuthModule getInstance() {
    if (instance == null) {
      throw new RuntimeException("Auth Module not initialized");
    }
    return instance;
  }

  public AuthService getAuthService() {
    return authService;
  }

  public AuthController getAuthController() {
    return authController;
  }
}
