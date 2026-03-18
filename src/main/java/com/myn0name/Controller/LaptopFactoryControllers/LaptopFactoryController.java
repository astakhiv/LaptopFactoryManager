package com.myn0name.Controller.LaptopFactoryControllers;

import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.LaptopFactoryView;

/** LaptopFactoryController */
public class LaptopFactoryController {
  public LaptopFactoryController(
      LaptopFactory laptopFactory,
      LaptopFactoryView laptopFactoryView,
      Storage<Laptop> laptopStorage,
      Storage<CPU> cpuStorage,
      Storage<Body> bodyStorage,
      Storage<Keyboard> keyboardStorage) {

    laptopFactoryView.setName(laptopFactory.getName());

    laptopFactoryView.setProduceActionListener(
        new ProduceActionListener(
            laptopFactory,
            laptopFactoryView,
            laptopStorage,
            cpuStorage,
            bodyStorage,
            keyboardStorage));
  }
}
