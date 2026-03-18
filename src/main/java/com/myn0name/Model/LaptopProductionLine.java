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

  public LaptopProductionLine(
      LaptopBuilder laptopBuilder,
      Storage<CPU> cpuStorage,
      Storage<Body> bodyStorage,
      Storage<Keyboard> keyboardStorage,
      Storage<Laptop> laptopStorage) {
    this.name = "Laptop Production Line";
    this.laptopBuilder = laptopBuilder;
    this.laptopStorage = laptopStorage;
    this.cpuStorage = cpuStorage;
    this.bodyStorage = bodyStorage;
    this.keyboardStorage = keyboardStorage;
  }

  public void produce() {
    try {
      laptopBuilder.setProductName("The Best Laptop");
      if (laptopBuilder.needCPU()) laptopBuilder.setCPU((CPU) cpuStorage.getProduct());

      if (laptopBuilder.needBody()) laptopBuilder.setBody((Body) bodyStorage.getProduct());

      if (laptopBuilder.needKeyboard())
        laptopBuilder.setKeyboard((Keyboard) keyboardStorage.getProduct());

      laptopBuilder.produce();
      laptopStorage.addProduct((Laptop) laptopBuilder.getProduct());

    } catch (Exception e) {
      throw e;
    }
  }

  public String getName() {
    return this.name;
  }
}
