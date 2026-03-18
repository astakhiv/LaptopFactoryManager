package com.myn0name.Model.Factories;

import com.myn0name.Model.Machines.Line;
import com.myn0name.Model.Machines.RobotArm;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Products.Product;

/** LaptopFactory */
public class LaptopFactory implements Factory {

  public static class OfficialQualityChecker implements QualityChecker {
    private String name;

    public OfficialQualityChecker() {
      this.name = "OfficialQualityChecker";
    }

    public String AssesQuality(Laptop laptop) {
      if (laptop == null) {
        throw new NullPointerException("No Laptop was provided.");
      }

      float quality = laptop.getQuality();

      if (quality >= 0.9) {
        return "High";
      } else if (quality >= 0.7) {
        return "Medium";
      } else {
        return "Low";
      }
    }

    public String getName() {
      return this.name;
    }
  }

  private String name;
  private Laptop laptop;
  private RobotArm robotArm;
  private Line line;

  private String productName;
  private CPU cpu;
  private Keyboard keyboard;
  private Body body;

  public LaptopFactory(RobotArm robotArm, Line line) {
    this.robotArm = robotArm;
    this.line = line;
    this.name = "Laptop Factory";
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

  public Product getProduct() {
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
