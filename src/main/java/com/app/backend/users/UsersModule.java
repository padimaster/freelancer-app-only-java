package com.app.backend.users;

import com.app.backend.database.Database;
import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.repository.UsersRepository;
import com.app.backend.users.services.UsersService;

public class UsersModule {
  private UsersController usersController;
  private UsersService usersService;
  private UsersRepository usersRepository;

  private static UsersModule instance = null;

  private UsersModule(Database database) {
    UsersRepository.initInstance(database);
    this.usersRepository = UsersRepository.getInstance();

    UsersService.initInstance(this.usersRepository);
    this.usersService = UsersService.getInstance();

    UsersController.initInstance(usersService);
    this.usersController = UsersController.getInstance();
  }

  public static void initInstance(Database database) {
    instance = new UsersModule(database);
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
