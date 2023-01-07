package com.app.apps;

import com.app.backend.users.UsersModule;
import com.app.backend.users.controllers.UsersController;
import com.app.frontend.users.UsersModuleUI;

public class UsersApp {
  private UsersModule usersModule;
  private UsersModuleUI usersModuleUI;

  public UsersApp() {
    UsersController usersController;

    UsersModule.initInstance();
    this.usersModule = UsersModule.getInstance();

    usersController = this.usersModule.getUsersController();
    this.usersModuleUI = new UsersModuleUI(usersController);
  }

  public UsersModule getUsersModule() {
    return this.usersModule;
  }

  public UsersModuleUI getUsersModuleUI() {
    return this.usersModuleUI;
  }
}
