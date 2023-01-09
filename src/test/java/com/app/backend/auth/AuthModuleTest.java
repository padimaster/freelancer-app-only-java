package com.app.backend.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.app.backend.auth.controllers.AuthController;
import com.app.backend.auth.dtos.AuthDTO;
import com.app.backend.auth.entities.AuthEntity;
import com.app.backend.auth.repositories.AuthRepository;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.responses.ErrorResponse;
import com.app.backend.common.responses.Response;
import com.app.backend.users.UsersModule;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;

public class AuthModuleTest {
  private UsersModule usersModule;
  private AuthModule authModule;

  private AuthController authController;

  private UsersRepository usersRepository;
  private AuthRepository authRepository;

  @Before
  public void setUp() {
    // Init User Module
    this.usersRepository = UsersRepository.getInstance();
    this.usersRepository.insert(new UserEntity("111111", "Kenny", "kenny@mail.com"));
    this.usersRepository.insert(new UserEntity("222222", "Erick", "erick@mail.com"));

    UsersModule.initInstance(usersRepository);
    this.usersModule = UsersModule.getInstance();

    // Init Auth Module
    this.authRepository = AuthRepository.getInstance();
    this.authRepository.insert(new AuthEntity("auth-1", "kenny@mail.com", "11111111"));
    this.authRepository.insert(new AuthEntity("auth-2", "erick@mail.com", "22222222"));

    AuthModule.initInstance(this.authRepository, usersModule.getUsersService());
    this.authModule = AuthModule.getInstance();

    authController = this.authModule.getAuthController();
  }

  @Test
  public void shouldCreateUser() throws NotFoundException {
    AuthDTO createAuthDTO;
    UserDTO creaUserDTO;
    Response response;
    UserEntity newUser;
    UserEntity expectedUser;

    createAuthDTO = new AuthDTO("alex@mail.com", "123456789");
    creaUserDTO = new UserDTO("Alex", createAuthDTO.getEmail());

    response = authController.register(createAuthDTO, creaUserDTO);
    newUser = (UserEntity) response.getData();

    expectedUser = usersModule.getUsersService().getByEmail(createAuthDTO.getEmail());

    assertEquals(expectedUser, newUser);
  }

  @Test
  public void shouldLoginUser() throws NotFoundException {
    AuthDTO authDTO;
    Response response;
    UserEntity expectedUser;
    UserEntity authUser;

    authDTO = new AuthDTO("erick@mail.com", "22222222");

    // Logging user
    response = authController.login(authDTO.getEmail(), authDTO.getPassword());
    authUser = (UserEntity) response.getData();

    expectedUser = usersModule.getUsersService().getByEmail(authDTO.getEmail());

    assertEquals(expectedUser, authUser);
  }

  @Test
  public void shouldNotLoggingByInvalidCredentials() {
    AuthDTO authDTO;
    Response response;
    Response expectedResponse;

    authDTO = new AuthDTO("erick@mail.com", "11111111");

    // Logging user
    response = authController.login(authDTO.getEmail(), authDTO.getPassword());

    expectedResponse = new ErrorResponse("Invalid Credentials");

    assertEquals(expectedResponse, response);
  }
}
