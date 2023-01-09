package com.app.backend.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.responses.Response;
import com.app.backend.common.responses.SuccessResponse;
import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;

public class UsersModuleTest {
  private UsersModule usersModule;
  private UsersController usersController;
  private UsersRepository usersRepository;

  @Before
  public void setUp() {
    // Init User Module
    this.usersRepository = UsersRepository.getInstance();
    this.usersRepository.insert(new UserEntity("111111", "Kenny", "kenny@mail.com"));
    this.usersRepository.insert(new UserEntity("222222", "Erick", "erick@mail.com"));

    UsersModule.initInstance(usersRepository);
    this.usersModule = UsersModule.getInstance();

    this.usersController = this.usersModule.getUsersController();
  }

  @Test
  public void shouldCreateUser() {
    UserDTO createUserDTO;
    Response response;
    UserEntity newUser;
    UserEntity expectedUser;

    createUserDTO = new UserDTO("Alex", "alex@mail.com");
    response = usersController.create(createUserDTO);
    newUser = (UserEntity) response.getData();

    expectedUser = new UserEntity(newUser.getId(), "Alex", "alex@mail.com");

    assertEquals(expectedUser, newUser);
  }

  @Test
  public void shouldGetUser() {
    Response response;
    UserEntity user;
    UserEntity expectedUser;

    response = usersController.getById("222222");
    user = (UserEntity) response.getData();

    expectedUser = new UserEntity("222222", "Erick", "erick@mail.com");

    assertEquals(expectedUser, user);
  }

  @Test
  public void shouldUpdateUser() {
    UserDTO updateUserDTO;
    Response response;
    Response expectedResponse;
    UserEntity expectedUser;

    updateUserDTO = new UserDTO("KennyPinchao", "new@mail.com");
    response = usersController.update("111111", updateUserDTO);

    expectedUser = new UserEntity("111111", "KennyPinchao", "new@mail.com");
    expectedResponse = new SuccessResponse("User updated", expectedUser);

    assertEquals(expectedResponse, response);
  }

  @Test(expected = NotFoundException.class)
  public void shouldDeleteUser() throws NotFoundException {
    Response response;
    Response expectedResponse;
    UserEntity deletedUser;
    UserEntity userToDeleted;

    // Create user to delete
    userToDeleted = (UserEntity) (this.usersController.create(new UserDTO("Alex", "alex@mail.com"))).getData();

    // Delete user
    deletedUser = this.usersModule.getUsersService().getById(userToDeleted.getId());
    response = usersController.delete(userToDeleted.getId());

    expectedResponse = new SuccessResponse("User deleted", deletedUser);

    assertEquals(expectedResponse, response);

    // Get user again to check if it was deleted (should throw NotFoundException)
    this.usersModule.getUsersService().getById(userToDeleted.getId());
  }
}
