package com.myn0name.Model.Factories;

import com.myn0name.Model.Machines.Line;
import com.myn0name.Model.Machines.RobotArm;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Products.Product;
import com.myn0name.Model.Storages.Storage;

/** LaptopFactory */
public class LaptopFactory implements Factory {
  private String name;
  private Laptop laptop;
  private RobotArm robotArm;
  private Line line;
  private Storage<CPU> cpuStorage;
  private Storage<Keyboard> keyboardStorage;
  private Storage<Body> bodyStorage;

  private String productName;
  private CPU cpu;
  private Keyboard keyboard;
  private Body body;

  public LaptopFactory(
      RobotArm robotArm,
      Line line,
      Storage<CPU> cpuStorage,
      Storage<Keyboard> keyboardStorage,
      Storage<Body> bodyStorage) {
    this.robotArm = robotArm;
    this.line = line;
    this.name = "Laptop Factory";

    this.cpuStorage = cpuStorage;
    this.keyboardStorage = keyboardStorage;
    this.bodyStorage = bodyStorage;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getName() {
    return name;
  }

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

  public void produce() {

    try {
      getCPU();
      getKeyboard();
      getBody();
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

  private void getCPU() {
    if (this.cpu == null) {
      this.cpu = (CPU) this.cpuStorage.getProduct();
    }
  }

  private void getKeyboard() {
    if (this.keyboard == null) {
      this.keyboard = (Keyboard) this.keyboardStorage.getProduct();
    }
  }

  private void getBody() {
    if (this.body == null) {
      this.body = (Body) this.bodyStorage.getProduct();
    }
  }
}
