package com.myn0name.Model.Products;

public class Body extends Product {
  private String color;
  private String material;

  public Body(String name, float quality, String color, String material) {
    super(name, "Body", quality);

    this.color = color;
    this.material = material;
  }

  public String getColor() {
    return this.color;
  }

  public String getMaretial() {
    return this.material;
  }
}
