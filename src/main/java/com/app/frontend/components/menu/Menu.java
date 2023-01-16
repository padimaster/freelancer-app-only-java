package com.app.frontend.components.menu;

import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.Input;
import com.app.frontend.components.auth.AuthComponentUI;
import com.app.frontend.components.users.UsersComponentUI;

public class Menu {
  private UsersComponentUI usersComponentUI;
  private AuthComponentUI authComponentUI;
  private Input input;

  public Menu(UsersComponentUI usersComponentUI, AuthComponentUI authComponentUI) {
    this.usersComponentUI = usersComponentUI;
    this.authComponentUI = authComponentUI;
  }

  public void show(UserEntity userEntity) {

  }

  public void login() {
    String output;
    int option;

    output = "Netnow App\n";
    output += "Select an option:\n";
    output += "\t1. Login\n";
    output += "\t2. Sign Up\n";
    output += "\t3. Exit\n";

    do {
      System.out.println(output);
      option = this.input.readInt("Enter the option:");

      switch (option) {
        case 1:
          System.out.println("Login\n");
          this.authComponentUI.login();
          break;
        case 2:
          System.out.println("Sign Up\n");
          this.authComponentUI.register();
          break;
        case 3:
          System.out.println("Exit\n");
          break;
        case -1:
          System.out.println("Invalid option");
          break;
      }
    } while (option != 3);
  }
}
