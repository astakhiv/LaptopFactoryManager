package com.myn0name.Model.Products;

public class Keyboard extends Product {
  private String color;
  private String language;

  public Keyboard(String name, float quality, String color, String language) {
    super(name, "Keyboard", quality);

    this.color = color;
    this.language = language;
  }

  public String getColor() {
    return this.color;
  }

  public String getLanguage() {
    return this.language;
  }
}
