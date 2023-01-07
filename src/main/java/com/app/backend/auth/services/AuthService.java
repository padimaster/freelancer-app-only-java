package com.app.backend.auth.services;

import com.app.backend.common.errors.InvalidCredentialsException;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.services.UsersService;

public class AuthService {
  private static AuthService instance;
  private UsersService usersService;

  private AuthService(UsersService usersService) {
    this.usersService = usersService;
  }

  public static void initInstance(UsersService usersService) {
    instance = new AuthService(usersService);
  }

  public static AuthService getInstance() {
    if (instance == null) {
      throw new RuntimeException("Users Service not initialized");
    }
    return instance;
  }

  public UserEntity validateUser(String id, String password) throws InvalidCredentialsException {
    UserEntity user;

    try {
      user = usersService.getById(id);
    } catch (Exception e) {
      throw new InvalidCredentialsException();
    }

    if (!user.getPassword().equals(password)) {
      throw new InvalidCredentialsException();
    }

    return user;
  }
}
