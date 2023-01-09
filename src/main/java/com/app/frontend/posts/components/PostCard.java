package com.app.frontend.posts.components;

import com.app.backend.posts.entities.PostEntity;

public class PostCard {
  private PostEntity postEntity;

  public PostCard(PostEntity postEntity) {
    this.postEntity = postEntity;
  }

  public String getPostId() {
    return this.postEntity.getId();
  }
}
