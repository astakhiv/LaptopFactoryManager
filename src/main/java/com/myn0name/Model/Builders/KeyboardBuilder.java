package com.myn0name.Model.Builders;

import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Product;
import java.util.Random;

/** KeyboardBuilder */
public class KeyboardBuilder implements Builder {
  private Keyboard keyboard;
  private String name;
  private String productName;
  private String color;
  private String language;

  public KeyboardBuilder() {
    this.name = "Keyboard Builder";

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
