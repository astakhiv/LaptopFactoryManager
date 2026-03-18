package com.myn0name.Model.Factories;

import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Product;
import java.util.Random;

/** KeyboardFactory */
public class KeyboardFactory implements Factory {
  private Keyboard keyboard;
  private String name;
  private String productName;
  private String color;
  private String language;

  public KeyboardFactory() {
    this.name = "Keyboard Factory";

    this.productName = null;
    this.color = null;
    this.language = null;
  }

  public void produce() {
    Random random = new Random();
    float max = 1f;
    float min = 0.6f;
    float quality = min + random.nextFloat() * (max - min);

    this.keyboard = new Keyboard(productName, quality, color, language);
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Product getProduct() {
    return this.keyboard;
  }

  public String getName() {
    return this.name;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}
