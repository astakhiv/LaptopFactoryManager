package com.myn0name.View.Panels;

import com.myn0name.Controller.LaptopFactoryController;
import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.LaptopFactoryView;
import javax.swing.JPanel;

/** LaptopFactoryPanel */
public class LaptopFactoryPanel extends JPanel {
  public LaptopFactoryPanel(LaptopFactory laptopFactory, Storage<Laptop> laptopStorage) {
    LaptopFactoryView laptopFactoryView = new LaptopFactoryView();
    LaptopFactoryController laptopFactoryController =
        new LaptopFactoryController(laptopFactory, laptopFactoryView, laptopStorage);

    this.add(laptopFactoryView);
  }
}
