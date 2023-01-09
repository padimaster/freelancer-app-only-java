package com.app.frontend.posts.components;

import com.app.backend.common.responses.Response;
import com.app.backend.posts.controller.PostsController;
import com.app.backend.posts.dtos.PostDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.output.Output;
import com.app.frontend.posts.services.PostsServiceUI;
import com.app.frontend.posts.utils.input.PostsInput;

public class PostsComponentUI {
  private PostsController postsController;
  private PostsServiceUI postsServiceUI;
  private PostsInput postsInput;
  private UserEntity user;
  private Output output;

  public PostsComponentUI(UserEntity user, PostsController postsController) {
    this.postsServiceUI = new PostsServiceUI(postsController);
    this.postsInput = new PostsInput();
    this.output = new Output();
    this.user = user;
  }

  public void create() {
    Response response;
    PostDTO createPostDTO;

    createPostDTO = this.postsInput.readPostDTO();

    response = this.postsServiceUI.create(createPostDTO);

    this.output.printResponse(response);
  }

  public void getById() {
    Response response;
    String userId;

    userId = this.postsInput.readString("Enter the post id:");

    response = this.postsServiceUI.getPostById(userId);

    this.output.printResponse(response);
  }

  public void getAll() {
    Response response;

    response = this.postsServiceUI.getAll();

    this.output.printResponse(response);
  }

  public void update() {
    Response response;
    String userId;
    PostDTO updatePostDTO;

    userId = this.postsInput.readString("Enter the user id:");
    updatePostDTO = this.postsInput.readPostDTO();

    response = this.postsServiceUI.update(userId, updatePostDTO);

    this.output.printResponse(response);
  }

  public void delete() {
    Response response;
    String userId;

    userId = this.postsInput.readString("Enter the user id:");

    response = this.postsServiceUI.delete(userId);

    this.output.printResponse(response);
  }
}
