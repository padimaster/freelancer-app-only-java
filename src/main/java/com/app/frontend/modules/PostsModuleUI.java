package com.app.frontend.modules;

import com.app.backend.posts.controller.PostsController;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.components.posts.PostsComponentUI;
import com.app.frontend.services.PostsServiceUI;

public class PostsModuleUI {
  private PostsComponentUI postsComponentUI;
  private PostsServiceUI postsServiceUI;

  public PostsModuleUI(PostsController postsController) {
    this.postsServiceUI = new PostsServiceUI(postsController);
  }

  public void initPostsComponentUI(UserEntity user) {
    this.postsComponentUI = new PostsComponentUI(user, this.postsServiceUI);
  }

}
