package com.myn0name.Model.Builders;

import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Product;
import java.util.Random;

/** CPUBuilder */
public class CPUBuilder implements Builder {
  private CPU cpu;
  private String name;
  private String productName;
  private int numberOfCores;

  public CPUBuilder() {
    this.name = "CPU Builder";

    this.productName = null;
    this.numberOfCores = 0;
  }

  public void produce() {
    Random random = new Random();
    float max = 1f;
    float min = 0.6f;
    float quality = min + random.nextFloat() * (max - min);

    this.cpu = new CPU(productName, quality, numberOfCores);
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setNumberOfCores(int numberOfCores) {
    this.numberOfCores = numberOfCores;
  }

  public Product getProduct() {
    return this.cpu;
  }

  public String getName() {
    return this.name;
  }
}
