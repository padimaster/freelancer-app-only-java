package com.app.frontend.posts.utils.input;

import com.app.backend.posts.dtos.PostDTO;
import com.app.frontend.common.input.Input;

public class PostsInput extends Input {
  public PostDTO readPostDTO() {
    PostDTO postDTO;
    String title;
    String content;

    title = this.readString("Enter the title:");
    content = this.readString("Enter the email:");

    postDTO = new PostDTO(title, content, null);

    return postDTO;
  }
}
