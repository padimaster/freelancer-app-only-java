package com.app.backend.database;

public class DatabaseModule {
  private static DatabaseModule instance = null;

  private DatabaseModule() {
  }

  public static DatabaseModule getInstance() {
    if (instance == null) {
      instance = new DatabaseModule();
    }
    return instance;
  }

  public void connect() {
    System.out.println("Connecting to database...");
  }

  public void disconnect() {
    System.out.println("Disconnecting from database...");
  }

  public void insert(String insert) {
    System.out.println("Inserting into database: " + insert);
  }

  public void query(String query) {
    System.out.println("Querying database: " + query);
  }

  public void update(String update) {
    System.out.println("Updating database: " + update);
  }

  public void delete(String delete) {
    System.out.println("Deleting from database: " + delete);
  }
}
