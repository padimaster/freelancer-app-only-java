package com.app.backend.users.repository;

import java.util.ArrayList;
import java.util.UUID;

import com.app.backend.users.entities.UserEntity;

public class UsersRepository {
  ArrayList<UserEntity> users = new ArrayList<UserEntity>();

  private static UsersRepository instance = null;

  private UsersRepository() {
  }

  public static UsersRepository getInstance() {
    if (instance == null) {
      instance = new UsersRepository();
    }
    return instance;
  }

  public UserEntity insert(UserEntity user) {
    this.users.add(user);

    return user;
  }

  public ArrayList<UserEntity> getAll() {
    return this.users;
  }

  public UserEntity getById(String id) {
    for (UserEntity user : this.users) {
      if (user.getId().equals(id)) {
        return user;
      }
    }

    return null;
  }

  public UserEntity update(String id, UserEntity userData) {
    UserEntity currentUser;
    UserEntity updatedUser;

    currentUser = this.getById(id);

    if (currentUser == null) {
      System.out.println("User not found!");
      return null;
    }

    int index = this.users.indexOf(currentUser);
    updatedUser = new UserEntity(userData);
    this.users.set(index, userData);

    return updatedUser;
  }

  public UserEntity delete(String id) {
    UserEntity user = this.getById(id);

    if (user == null) {
      System.out.println("User not found!");
      return null;
    }

    this.users.remove(user);
    return user;
  }

  public boolean deleteAll() {
    this.users.clear();

    return true;
  }

  public String generateId() {
    UUID id = UUID.randomUUID();

    return id.toString();
  }
}
