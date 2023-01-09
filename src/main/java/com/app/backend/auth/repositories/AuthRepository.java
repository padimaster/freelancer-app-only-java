package com.app.backend.auth.repositories;

import java.util.ArrayList;

import com.app.backend.auth.entities.AuthEntity;

public class AuthRepository {
  private ArrayList<AuthEntity> collection;
  private static AuthRepository instance = null;

  private AuthRepository() {
    this.collection = new ArrayList<AuthEntity>();
  }

  public static AuthRepository getInstance() {
    if (instance == null) {
      instance = new AuthRepository();
    }
    return instance;
  }

  public AuthEntity insert(AuthEntity userAuth) {
    if (this.getByEmail(userAuth.getEmail()) != null) {
      return null;
    }

    this.collection.add(userAuth);

    return userAuth;
  }

  public AuthEntity getByEmail(String email) {
    for (AuthEntity user : this.collection) {
      if (user.getEmail().equals(email)) {
        return user;
      }
    }

    return null;
  }

  public AuthEntity update(String email, AuthEntity userData) {
    AuthEntity currentUser;
    AuthEntity updatedUser;

    currentUser = this.getByEmail(email);

    if (currentUser == null) {
      return null;
    }

    int index = this.collection.indexOf(currentUser);
    updatedUser = new AuthEntity(userData);
    this.collection.set(index, userData);

    return updatedUser;
  }
}
