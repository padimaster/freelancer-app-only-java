package com.app.backend.users.services;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;
import com.app.backend.users.services.UsersService;

public class UsersServicesTest {
  private UsersService usersService;
  private UserEntity userTest;

  @Before
  public void setUp() {
    this.usersService = UsersService.getInstance();
    this.userTest = new UserEntity("999999", "Alex Padilla", "alex@mail.com", "222222");

    UsersRepository.getInstance().insert(this.userTest);
  }

  @After
  public void tearDown() {
    UsersRepository.getInstance().deleteAll();
  }

  @Test
  public void shouldCreateUser() throws BadRequestException {
    int initialRespositorySize;
    UserDTO userDto;
    UserEntity userCreated;

    userDto = new UserDTO("Erick", "erick@mail.com", "123456");
    initialRespositorySize = this.usersService.getAll().size();
    userCreated = usersService.create(userDto);

    assertTrue(this.usersService.getAll().size() == initialRespositorySize + 1);
    System.out.println(userCreated);
  }

  @Test
  public void shouldGetUserById() throws NotFoundException {
    String userId;
    UserEntity userToFind;

    userId = this.userTest.getId();
    userToFind = this.usersService.getById(userId);

    assertTrue(userToFind.equals(this.userTest));
  }

  @Test
  public void shouldUpdateUser() throws NotFoundException, BadRequestException {
    String userId;
    UserDTO dataToUpdate;
    UserEntity userUpdated;
    UserEntity expectedUserUpdated;

    userId = this.userTest.getId();
    dataToUpdate = new UserDTO("Kenny Pinchao", "kenny@mail.com", "888888");

    userUpdated = this.usersService.update(userId, dataToUpdate);
    expectedUserUpdated = new UserEntity(userId, dataToUpdate);

    assertTrue(userUpdated.equals(expectedUserUpdated));
  }

  @Test
  public void shouldUpdateUserEmail() throws NotFoundException, BadRequestException {
    String userId;
    UserDTO dataToUpdate;
    UserEntity userUpdated;
    UserEntity expectedUserUpdated;

    userId = this.userTest.getId();
    dataToUpdate = new UserDTO(null, "kenny@mail.com", null);

    userUpdated = this.usersService.update(userId, dataToUpdate);
    expectedUserUpdated = new UserEntity(userId, this.userTest.getName(), dataToUpdate.getEmail(),
        this.userTest.getPassword());

    assertTrue(userUpdated.equals(expectedUserUpdated));
  }

  @Test
  public void shouldUpdateUserNameAndPassword() throws NotFoundException, BadRequestException {
    String userId;
    UserDTO dataToUpdate;
    UserEntity userUpdated;
    UserEntity expectedUserUpdated;

    userId = this.userTest.getId();
    dataToUpdate = new UserDTO("Alex Padilla", null, "4567891");

    userUpdated = this.usersService.update(userId, dataToUpdate);
    expectedUserUpdated = new UserEntity(userId, dataToUpdate.getName(), this.userTest.getEmail(),
        dataToUpdate.getPassword());

    assertTrue(userUpdated.equals(expectedUserUpdated));
  }

  @Test
  public void shouldDeleteUser() {
    int initialRespositorySize;
    String userId;
    UserEntity userDeleted;

    userId = this.userTest.getId();
    initialRespositorySize = this.usersService.getAll().size();

    userDeleted = this.usersService.delete(userId);

    assertTrue(this.usersService.getAll().size() == initialRespositorySize - 1);
    assertTrue(userDeleted.equals(this.userTest));
  }

  @Test(expected = BadRequestException.class)
  public void shouldThrowsBadRequestException() throws BadRequestException {
    UserDTO userDto;

    userDto = new UserDTO(null, "erick@mail.com", "123456");
    usersService.create(userDto);
  }

  @Test(expected = NotFoundException.class)
  public void shouldThrowsNotFoundException() throws NotFoundException {
    this.usersService.getById("inventedId");
  }
}
