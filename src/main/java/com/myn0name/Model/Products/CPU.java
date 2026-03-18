package com.myn0name.Model.Products;

public class CPU extends Product {
  private int numberOfCores;

  public CPU(String name, float quality, int numberOfCores) {
    super(name, "CPU", quality);

    this.numberOfCores = numberOfCores;
  }

  public int getNumberOfCores() {
    return this.numberOfCores;
  }
}
