package com.app.backend.users.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.common.responses.Response;
import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;

public class UsersControllerTest {
  private UsersController usersController;
  private UserEntity userTest;

  @Before
  public void setUp() {
    this.usersController = UsersController.getInstance();
    this.userTest = new UserEntity("999999", "Alex Padilla", "alex@mail.com", "222222");
    UsersRepository.getInstance().insert(this.userTest);
  }

  @After
  public void tearDown() {
    UsersRepository.getInstance().deleteAll();
  }

  @Test
  public void shouldCreateUser() {
    UserDTO userDto;
    Response response;
    UserEntity userCreated;

    userDto = new UserDTO("Erick", "erick@mail.com", "123456");
    response = this.usersController.create(userDto);
    userCreated = (UserEntity) response.getData();

    assertNotEquals(userCreated, null);
  }

  @Test
  public void shouldGetUserById() {
    String userId;
    Response response;
    UserEntity userToFind;

    userId = this.userTest.getId();
    response = this.usersController.getById(userId);
    userToFind = (UserEntity) response.getData();

    assertEquals(userToFind, this.userTest);
  }

  @Test
  public void shouldUpdateUser() {
    String userId;
    UserDTO userDto;
    Response response;
    UserEntity userUpdated;

    userId = this.userTest.getId();
    userDto = new UserDTO("Kenny Pinchao", "kenny@mail.com", "888888");

    response = this.usersController.update(userId, userDto);
    userUpdated = (UserEntity) response.getData();

    assertNotEquals(userUpdated, null);
  }

  @Test
  public void shouldDeleteUser() {
    String userId;
    Response response;
    UserEntity userDeleted;

    userId = this.userTest.getId();
    response = this.usersController.delete(userId);
    userDeleted = (UserEntity) response.getData();

    assertNotEquals(userDeleted, null);
  }

  @Test
  public void shouldGetAllUsers() {
    Response response;
    ArrayList<UserEntity> users;

    response = this.usersController.getAll();
    users = (ArrayList<UserEntity>) response.getData();

    assertNotEquals(users, null);
  }
}
