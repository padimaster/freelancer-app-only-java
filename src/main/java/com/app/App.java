package com.app;

import com.app.apps.UsersApp;

public class App {

  public static void main(String[] args) {
    UsersApp usersApp;

    usersApp = new UsersApp();

    usersApp.getUsersModuleUI().create();
  }
}
