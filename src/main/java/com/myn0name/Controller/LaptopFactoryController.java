package com.myn0name.Controller;

import com.myn0name.Model.Factories.LaptopFactory;
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

  public LaptopFactoryController(
      LaptopFactory laptopFactory,
      LaptopFactoryView laptopFactoryView,
      Storage<Laptop> laptopStorage) {
    this.laptopFactory = laptopFactory;
    this.laptopFactoryView = laptopFactoryView;
    this.laptopStorage = laptopStorage;

    this.laptopFactoryView.setName(laptopFactory.getName());

    this.setProduceActionListener();
  }

  private void setProduceActionListener() {
    ActionListener actionListener =
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            try {
              laptopFactory.setProductName("The Best Laptop");
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
