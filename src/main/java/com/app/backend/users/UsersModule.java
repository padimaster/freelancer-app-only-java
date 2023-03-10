package com.app.backend.users;

import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.repository.UsersRepository;
import com.app.backend.users.services.UsersService;

public class UsersModule {
  private UsersController usersController;
  protected UsersService usersService;

  private static UsersModule instance = null;

  private UsersModule(UsersRepository usersRepository) {
    UsersService.initInstance(usersRepository);
    this.usersService = UsersService.getInstance();

    UsersController.initInstance(usersService);
    this.usersController = UsersController.getInstance();
  }

  public static void initInstance(UsersRepository usersRepository) {
    instance = new UsersModule(usersRepository);
  }

  public static UsersModule getInstance() {
    if (instance == null) {
      throw new RuntimeException("Users Module not initialized");
    }
    return instance;
  }

  public UsersService getUsersService() {
    return usersService;
  }

  public UsersController getUsersController() {
    return usersController;
  }
}
