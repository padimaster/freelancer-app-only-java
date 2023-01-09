package com.app.apps;

import com.app.backend.users.UsersModule;
import com.app.backend.users.repository.UsersRepository;
import com.app.frontend.users.UsersModuleUI;

public class UsersApp {
  private UsersModule usersModule;
  private UsersModuleUI usersModuleUI;

  public UsersApp() {
    UsersRepository usersRepository;

    // Users DB-Collection Instance
    usersRepository = UsersRepository.getInstance();

    // Users Module Instance
    UsersModule.initInstance(usersRepository);
    this.usersModule = UsersModule.getInstance();

    // Users Module UI Instance
    this.usersModuleUI = new UsersModuleUI(this.usersModule.getUsersController());
  }

  public UsersModule getUsersModule() {
    return this.usersModule;
  }

  public UsersModuleUI getUsersModuleUI() {
    return this.usersModuleUI;
  }
}
