package com.app.frontend.users;

import com.app.backend.users.controllers.UsersController;
import com.app.frontend.users.components.UsersComponentUI;
import com.app.frontend.users.services.UsersServicesUI;

/**
 * Hello world!
 *
 */
public class UsersModuleUI {
    UsersController usersController;
    UsersServicesUI usersServicesUI;
    UsersComponentUI usersComponentUI;

    public UsersModuleUI(UsersController usersController) {
        this.usersController = usersController;
        this.usersServicesUI = new UsersServicesUI(this.usersController);
        this.usersComponentUI = new UsersComponentUI(this.usersServicesUI);
    }

    public void create() {
        this.usersComponentUI.create();
    }
}
