package com.app.backend.users.services;

import java.util.ArrayList;

import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.utils.Cleaner;
import com.app.backend.common.validators.UserValidator;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;

public class UsersService {
  private UsersRepository repository;
  private static UsersService instance = null;

  private UsersService(UsersRepository repository) {
    this.repository = repository;
  }

  public static void initInstance(UsersRepository repository) {
    instance = new UsersService(repository);
  }

  public static UsersService getInstance() {
    if (instance == null) {
      throw new RuntimeException("Users Service not initialized");
    }
    return instance;
  }

  public UserEntity create(UserDTO userDTO) throws BadRequestException {
    String id;
    UserEntity newUser;

    if (!UserValidator.isCreateUserDTO(userDTO)) {
      throw new BadRequestException();
    }

    id = this.repository.generateId();

    newUser = new UserEntity(id, userDTO.getName(), userDTO.getEmail(),
        userDTO.getPassword());

    this.repository.insert(newUser);

    return newUser;
  }

  public ArrayList<UserEntity> getAll() {
    return this.repository.getAll();
  }

  public UserEntity getById(String id) throws NotFoundException {
    UserEntity user;

    user = this.repository.getById(id);

    if (user == null) {
      throw new NotFoundException();
    }

    return user;
  }

  public UserEntity update(String id, UserDTO userDTO) throws NotFoundException, BadRequestException {
    UserEntity userToUpdate;
    UserEntity dataToUpdate;
    UserEntity userUpdated;

    if (!UserValidator.isUpdateUserDTO(userDTO)) {
      throw new BadRequestException();
    }

    userToUpdate = this.getById(id);

    Cleaner.cleanBlanks(userDTO);

    dataToUpdate = new UserEntity(
        id,
        userDTO.getName() != null ? userDTO.getName() : userToUpdate.getName(),
        userDTO.getEmail() != null ? userDTO.getEmail() : userToUpdate.getEmail(),
        userDTO.getPassword() != null ? userDTO.getPassword() : userToUpdate.getPassword());

    userUpdated = this.repository.update(id, dataToUpdate);

    return userUpdated;
  }

  public UserEntity delete(String id) throws NotFoundException {
    UserEntity userDeleted;

    this.getById(id);
    userDeleted = this.repository.delete(id);

    return userDeleted;
  }
}
