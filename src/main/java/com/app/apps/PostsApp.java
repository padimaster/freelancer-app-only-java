package com.app.apps;

import com.app.backend.database.Database;
import com.app.backend.posts.PostsModule;
import com.app.frontend.modules.PostsModuleUI;

public class PostsApp {
  private PostsModule postsModule;
  private PostsModuleUI postsModuleUI;

  public PostsApp(Database database) {
    // Posts Module Instance (Backend)
    PostsModule.initInstance(database);
    this.postsModule = PostsModule.getInstance();

    // Posts Module UI Instance (Frontend)
    this.postsModuleUI = new PostsModuleUI(this.postsModule.getPostsController());
  }
}
