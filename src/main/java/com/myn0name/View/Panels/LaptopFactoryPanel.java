package com.myn0name.View.Panels;

import javax.swing.JPanel;

import com.myn0name.Controller.LaptopFactoryController;
import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.View.LaptopFactoryView;


/**
 * LaptopFactoryPanel
 */
public class LaptopFactoryPanel extends JPanel{
  public LaptopFactoryPanel(LaptopFactory laptopFactory) {
    LaptopFactoryView laptopFactoryView = new LaptopFactoryView();
    LaptopFactoryController laptopFactoryController = new LaptopFactoryController(laptopFactory, laptopFactoryView);

    this.add(laptopFactoryView);
  }
}
