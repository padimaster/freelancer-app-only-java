package com.app.frontend.common.input;

import java.util.Scanner;

public class Input {

  public Input() {
  }

  public String readString(String message) {
    String input;
    Scanner scanner;

    scanner = new Scanner(System.in);
    System.out.println(message);
    input = scanner.nextLine();

    scanner.close();
    return input;
  }
}
