package com.app.backend.auth.services;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.InvalidCredentialsException;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;
import com.app.backend.users.services.UsersService;

public class AuthServiceTest {

  private AuthService authService;
  private UsersService usersService;
  private UserEntity user;

  @Before
  public void setUp() throws BadRequestException {
    UserDTO userDto;

    this.authService = AuthService.getInstance();
    this.usersService = UsersService.getInstance();
    userDto = new UserDTO("Erick", "erick@mail.com", "123456");

    this.user = this.usersService.create(userDto);
  }

  @After
  public void tearDown() {
    UsersRepository.getInstance().deleteAll();
  }

  @Test
  public void shouldValidateUser() throws InvalidCredentialsException {
    String id;
    String password;
    UserEntity authenticatedUser;

    id = user.getId();
    password = user.getPassword();

    authenticatedUser = this.authService.validateUser(id, password);

    assertTrue(authenticatedUser.equals(this.user));
  }

  @Test(expected = InvalidCredentialsException.class)
  public void shouldNotValidateUser() throws InvalidCredentialsException {
    String id;
    String password;

    id = user.getId();
    password = "randomPassword";

    this.authService.validateUser(id, password);
  }

}
