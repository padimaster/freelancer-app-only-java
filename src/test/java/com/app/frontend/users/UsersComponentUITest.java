package com.app.frontend.users;

import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.repository.UsersRepository;
import com.app.frontend.users.services.UsersServicesUI;

public class UsersComponentUITest {
  private UsersServicesUI usersServicesUI;
  private UsersComponentUI usersComponentUI;
  private UserDTO userDTO;

  @Before
  public void setUp() {
    this.usersServicesUI = mock(UsersServicesUI.class);
    setMock(usersServicesUI);
    this.usersComponentUI = new UsersComponentUI(usersServicesUI);
  }

  private void setMock(UsersServicesUI mock) {
    try {
      Field instance = UsersServicesUI.class.getDeclaredField("instance");
      instance.setAccessible(true);
      instance.set(instance, mock);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // @Test
  // public void shouldCreateUser() {
  // this.usersComponentUI.createUser();
  // }

}
