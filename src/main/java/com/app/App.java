package com.app;

import com.app.apps.UsersApp;
import com.app.backend.database.Database;

public class App {

  public static void main(String[] args) {
    UsersApp usersApp;

    Database.connect();
    usersApp = new UsersApp(Database.getInstance());

    usersApp.getUsersModuleUI().create();
  }
}
