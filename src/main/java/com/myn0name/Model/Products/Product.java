package com.myn0name.Model.Products;

public abstract class Product {
  private String name;
  private String type;
  private float quality;

  public Product(String name, String type, float quality) {
    this.name = name;
    this.type = type;
    this.quality = quality;
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public float getQuality() {
    return this.quality;
  }
}
