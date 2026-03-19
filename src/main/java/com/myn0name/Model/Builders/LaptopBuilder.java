package com.myn0name.Model.Builders;

import com.myn0name.Model.Machines.Line;
import com.myn0name.Model.Machines.RobotArm;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;

/** LaptopBuilder */
public class LaptopBuilder implements Builder<Laptop> {
  private String name;
  private Laptop laptop;
  private RobotArm robotArm;
  private Line line;

  private String productName;
  private CPU cpu;
  private Keyboard keyboard;
  private Body body;

  public LaptopBuilder(RobotArm robotArm, Line line) {
    this.robotArm = robotArm;
    this.line = line;
    this.name = "Laptop Builder";
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getName() {
    return name;
  }

  public void produce() {
    try {
      robotArm.work();
      line.work();
    } catch (Exception e) {
      throw e;
    }

    float quality = (cpu.getQuality() + keyboard.getQuality() + body.getQuality()) / 3;

    this.laptop = new Laptop(productName, quality, cpu, keyboard, body);
    this.cpu = null;
    this.keyboard = null;
    this.body = null;
  }

  public Laptop getProduct() {
    return this.laptop;
  }

  public boolean needCPU() {
    return this.cpu == null;
  }

  public void setCPU(CPU cpu) {
    this.cpu = cpu;
  }

  public boolean needKeyboard() {
    return this.keyboard == null;
  }

  public void setKeyboard(Keyboard keyboard) {
    this.keyboard = keyboard;
  }

  public boolean needBody() {
    return this.body == null;
  }

  public void setBody(Body body) {
    this.body = body;
  }
}
