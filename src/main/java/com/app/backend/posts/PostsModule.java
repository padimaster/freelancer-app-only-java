package com.app.backend.posts;

import com.app.backend.posts.controller.PostsController;
import com.app.backend.posts.repositories.PostsRepository;
import com.app.backend.posts.services.PostsService;

public class PostsModule {
  private PostsController usersController;
  protected PostsService usersService;
  private static PostsModule instance = null;

  private PostsModule() {
    PostsService.initInstance(PostsRepository.getInstance());
    this.usersService = PostsService.getInstance();

    PostsController.initInstance(usersService);
    this.usersController = PostsController.getInstance();
  }

  public static void initInstance() {
    instance = new PostsModule();
  }

  public static PostsModule getInstance() {
    if (instance == null) {
      throw new RuntimeException("Posts Module not initialized");
    }
    return instance;
  }

  public PostsService getUsersService() {
    return usersService;
  }

  public PostsController getUsersController() {
    return usersController;
  }

}
