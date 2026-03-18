package com.myn0name.Controller;

import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.LaptopFactoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** LaptopFactoryController */
public class LaptopFactoryController {
  private LaptopFactory laptopFactory;
  private LaptopFactoryView laptopFactoryView;
  private Storage<Laptop> laptopStorage;
  private Storage<CPU> cpuStorage;
  private Storage<Body> bodyStorage;
  private Storage<Keyboard> keyboardStorage;

  public LaptopFactoryController(
      LaptopFactory laptopFactory,
      LaptopFactoryView laptopFactoryView,
      Storage<Laptop> laptopStorage,
      Storage<CPU> cpuStorage,
      Storage<Body> bodyStorage,
      Storage<Keyboard> keyboardStorage) {
    this.laptopFactory = laptopFactory;
    this.laptopFactoryView = laptopFactoryView;
    this.laptopStorage = laptopStorage;
    this.cpuStorage = cpuStorage;
    this.bodyStorage = bodyStorage;
    this.keyboardStorage = keyboardStorage;
    

    this.laptopFactoryView.setName(laptopFactory.getName());

    this.setProduceActionListener();
  }

  private void setProduceActionListener() {
    ActionListener actionListener =
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            try {
              laptopFactory.setProductName("The Best Laptop");
              if (laptopFactory.needCPU()) {
                laptopFactory.setCPU((CPU) cpuStorage.getProduct());
              }

              if (laptopFactory.needBody()) {
               laptopFactory.setBody((Body) bodyStorage.getProduct());
              }

              if (laptopFactory.needKeyboard()) {
                laptopFactory.setKeyboard((Keyboard) keyboardStorage.getProduct());
              }

              laptopFactory.produce();
              laptopStorage.addProduct((Laptop) laptopFactory.getProduct());

              laptopFactoryView.setMessage("Produced successfuly");
            } catch (Exception err) {
              laptopFactoryView.setMessage(err.getMessage());
            }
          }
        };

    this.laptopFactoryView.setProduceActionListener(actionListener);
  }
}
