package com.app.backend.posts.dtos;

public class PostDto {
  private String title;
  private String content;
  private String authorId;

  public PostDto(String title, String content, String authorId) {
    this.title = title;
    this.content = content;
    this.authorId = authorId;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getAuthorId() {
    return authorId;
  }
}
