package com.app.frontend.common.output;

import com.app.backend.common.responses.Response;

public class Output {

  public Output() {
  }

  public void printResponse(Response response) {
    System.out.println(response);
  }
}
