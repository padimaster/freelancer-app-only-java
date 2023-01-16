package com.app.frontend.components.posts;

import com.app.backend.common.responses.Response;
import com.app.backend.posts.controller.PostsController;
import com.app.backend.posts.dtos.PostDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.PostsInput;
import com.app.frontend.services.PostsServiceUI;

public class PostsComponentUI {
  private PostsController postsController;
  private PostsServiceUI postsServiceUI;
  private PostsInput postsInput;
  private UserEntity user;

  public PostsComponentUI(UserEntity user, PostsController postsController) {
    this.postsServiceUI = new PostsServiceUI(postsController);
    this.postsInput = new PostsInput();
    this.user = user;
  }

  public void create() {
    Response response;
    PostDTO createPostDTO;

    createPostDTO = this.postsInput.readPostDTO();

    response = this.postsServiceUI.create(createPostDTO);

    System.out.println(response);
  }

  public void getById() {
    Response response;
    String userId;

    userId = this.postsInput.readString("Enter the post id:");

    response = this.postsServiceUI.getPostById(userId);

    System.out.println(response);
  }

  public void getAll() {
    Response response;

    response = this.postsServiceUI.getAll();

    System.out.println(response);
  }

  public void update() {
    Response response;
    String userId;
    PostDTO updatePostDTO;

    userId = this.postsInput.readString("Enter the user id:");
    updatePostDTO = this.postsInput.readPostDTO();

    response = this.postsServiceUI.update(userId, updatePostDTO);

    System.out.println(response);
  }

  public void delete() {
    Response response;
    String userId;

    userId = this.postsInput.readString("Enter the user id:");

    response = this.postsServiceUI.delete(userId);

    System.out.println(response);
  }
}
