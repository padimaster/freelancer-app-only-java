package com.app.frontend.modules;

import com.app.backend.users.controllers.UsersController;
import com.app.frontend.components.users.UsersComponentUI;
import com.app.frontend.services.UsersServiceUI;

public class UsersModuleUI {
    UsersServiceUI usersServicesUI;
    UsersComponentUI usersComponentUI;

    public UsersModuleUI(UsersController usersController) {
        this.usersServicesUI = new UsersServiceUI(usersController);
        this.usersComponentUI = new UsersComponentUI(this.usersServicesUI);
    }

    public UsersComponentUI getUsersComponentUI() {
        return this.usersComponentUI;
    }

    public UsersServiceUI getUsersServicesUI() {
        return this.usersServicesUI;
    }
}
