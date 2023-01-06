package com.app.frontend.users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.repository.UsersRepository;

public class UsersComponentUITest {
  private UsersComponentUI usersComponentUI;
  private UserDTO userDTO;

  @Before
  public void setUp() {
    this.usersComponentUI = new UsersComponentUI();
    this.userDTO = new UserDTO("Alex Padilla", "alex@mail.com", "password");
  }

  @After
  public void tearDown() {
    UsersRepository.getInstance().deleteAll();
  }

  // @Test
  // public void shouldCreateUser() {
  // this.usersComponentUI.createUser();
  // }

}
