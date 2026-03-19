package com.myn0name.Model;

import com.myn0name.Model.Builders.LaptopBuilder;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;

/** LaptopProductionLine */
public class LaptopProductionLine {
  private LaptopBuilder laptopBuilder;
  private Storage<CPU> cpuStorage;
  private Storage<Body> bodyStorage;
  private Storage<Keyboard> keyboardStorage;
  private Storage<Laptop> laptopStorage;
  private String name;

  public static class LaptopProductionLineBuilder {
    private LaptopBuilder laptopBuilder;
    private Storage<CPU> cpuStorage;
    private Storage<Body> bodyStorage;
    private Storage<Keyboard> keyboardStorage;
    private Storage<Laptop> laptopStorage;

    public LaptopProductionLine build() {
      return new LaptopProductionLine(this);
    }

    public LaptopProductionLineBuilder laptopBuilder(LaptopBuilder laptopBuilder) {
      this.laptopBuilder = laptopBuilder;
      return this;
    }

    public LaptopProductionLineBuilder cpuStorage(Storage<CPU> cpuStorage) {
      this.cpuStorage = cpuStorage;
      return this;
    }

    public LaptopProductionLineBuilder bodyStorage(Storage<Body> bodyStorage) {
      this.bodyStorage = bodyStorage;
      return this;
    }

    public LaptopProductionLineBuilder laptopStorage(Storage<Laptop> laptopStorage) {
      this.laptopStorage = laptopStorage;
      return this;
    }

    public LaptopProductionLineBuilder keyboardStorage(Storage<Keyboard> keyboardStorage) {
      this.keyboardStorage = keyboardStorage;
      return this;
    }
  }

  public LaptopProductionLine(LaptopProductionLineBuilder laptopProductionLineBuilder) {
    this.name = "Laptop Production Line";
    this.laptopBuilder = laptopProductionLineBuilder.laptopBuilder;
    this.laptopStorage = laptopProductionLineBuilder.laptopStorage;
    this.cpuStorage = laptopProductionLineBuilder.cpuStorage;
    this.bodyStorage = laptopProductionLineBuilder.bodyStorage;
    this.keyboardStorage = laptopProductionLineBuilder.keyboardStorage;
  }

  public void produce() {
    try {
      laptopBuilder.setProductName("The Best Laptop");
      if (laptopBuilder.needCPU()) {
        laptopBuilder.setCPU(cpuStorage.getProduct());
      }

      if (laptopBuilder.needBody()) {
        laptopBuilder.setBody(bodyStorage.getProduct());
      }

      if (laptopBuilder.needKeyboard()) {
        laptopBuilder.setKeyboard(keyboardStorage.getProduct());
      }

      laptopBuilder.produce();
      laptopStorage.addProduct(laptopBuilder.getProduct());

    } catch (Exception e) {
      throw e;
    }
  }

  public String getName() {
    return this.name;
  }
}
