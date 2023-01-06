package com.app.frontend.users.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.common.responses.Response;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;

public class UsersServicesUITest {
  private UsersServicesUI usersServicesUI;
  private UserDTO userDTO;

  @Before
  public void setUp() {
    this.usersServicesUI = new UsersServicesUI();
    this.userDTO = new UserDTO("Alex Padilla", "alex@mail.com", "password");
  }

  @After
  public void tearDown() {
    UsersRepository.getInstance().deleteAll();
  }

  @Test
  public void shouldCreateUser() {
    Response response;

    response = this.usersServicesUI.createUser(this.userDTO);

    assertFalse(response.getError());
  }

  @Test
  public void shouldGetUserById() {
    Response response;
    String userId;

    response = this.usersServicesUI.createUser(this.userDTO);
    userId = ((UserEntity) response.getData()).getId();

    response = this.usersServicesUI.getUserById(userId);

    assertFalse(response.getError());
  }

  @Test
  public void shouldGetAllUsers() {
    Response response;

    this.usersServicesUI.createUser(this.userDTO);
    response = this.usersServicesUI.getAllUsers();

    assertFalse(response.getError());
  }

  @Test
  public void shouldUpdateAllUserData() {
    Response response;
    String userId;
    UserDTO updatedUserDTO;

    response = this.usersServicesUI.createUser(this.userDTO);
    userId = ((UserEntity) response.getData()).getId();

    updatedUserDTO = new UserDTO("Erick Erazo", "erick@mail.com", "newPassword");

    response = this.usersServicesUI.updateUser(userId, updatedUserDTO);

    assertFalse(response.getError());
  }

  @Test
  public void shouldUpdateUserNameAndPassword() {
    Response response;
    String userId;
    UserDTO updatedUserDTO;
    UserEntity userBeforeUpdate;
    UserEntity expectedUserUpdated;

    response = this.usersServicesUI.createUser(this.userDTO);
    userId = ((UserEntity) response.getData()).getId();
    userBeforeUpdate = (UserEntity) response.getData();

    updatedUserDTO = new UserDTO("Erick Erazo", "", "newPassword");
    response = this.usersServicesUI.updateUser(userId, updatedUserDTO);

    expectedUserUpdated = new UserEntity(userBeforeUpdate.getId(), "Erick Erazo", userBeforeUpdate.getEmail(),
        "newPassword");

    assertEquals(response.getData(), expectedUserUpdated);
  }

  @Test
  public void shouldDeleteUser() {
    Response response;
    String userId;

    response = this.usersServicesUI.createUser(this.userDTO);
    userId = ((UserEntity) response.getData()).getId();

    response = this.usersServicesUI.deleteUser(userId);

    assertFalse(response.getError());
  }

  @Test
  public void shouldNotCreateUser() {
    Response response;
    UserDTO currentUserDTO;

    currentUserDTO = new UserDTO("Erick", "", "password");
    response = this.usersServicesUI.createUser(currentUserDTO);

    assertTrue(response.getError());
  }

  @Test
  public void shouldNotGetUserById() {
    Response response;

    this.usersServicesUI.createUser(this.userDTO);
    response = this.usersServicesUI.getUserById("randomId");

    assertTrue(response.getError());
  }
}
