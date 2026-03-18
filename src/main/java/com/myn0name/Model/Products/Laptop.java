package com.myn0name.Model.Products;

public class Laptop extends Product {
  private CPU cpu;
  private Keyboard keyboard;
  private Body body;

  public Laptop(String name, float quality, CPU cpu, Keyboard keyboard, Body body) {
    super(name, "Laptop", quality);

    this.cpu = cpu;
    this.keyboard = keyboard;
    this.body = body;
  }
}
