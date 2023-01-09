package com.app.backend.common.models;

import java.util.ArrayList;

public abstract class Repository<T, U> {
  protected ArrayList<T> collection;

  protected Repository() {
    this.collection = new ArrayList<T>();
  }

  protected abstract T insert(T item);

  protected abstract ArrayList<T> getAll();

  protected abstract T getById(String id);

  protected abstract T update(String id, U item);

  protected abstract T delete(String id);
}
