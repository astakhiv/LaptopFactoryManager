package com.myn0name.Model.Factories;

import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.Product;
import java.util.Random;

/** BodyFactory */
public class BodyFactory implements Factory {
  private Body body;
  private String name;
  private String productName;
  private String material;
  private String color;

  public BodyFactory() {
    this.name = "Body Factory";

    this.productName = null;
    this.material = null;
    this.color = null;
  }

  public void produce() {
    Random random = new Random();
    float max = 1f;
    float min = 0.6f;
    float quality = min + random.nextFloat() * (max - min);

    this.body = new Body(productName, quality, color, material);
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Product getProduct() {
    return this.body;
  }

  public String getName() {
    return this.name;
  }
}
