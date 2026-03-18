package com.myn0name.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.View.LaptopFactoryView;


/**
 * LaptopFactoryController
 */
public class LaptopFactoryController {
  private LaptopFactory laptopFactory;
  private LaptopFactoryView laptopFactoryView;

  public LaptopFactoryController(LaptopFactory laptopFactory, LaptopFactoryView laptopFactoryView) {
    this.laptopFactory = laptopFactory;
    this.laptopFactoryView = laptopFactoryView;

    this.laptopFactoryView.setName(laptopFactory.getName());

    this.setProduceActionListener();
  }

  private void setProduceActionListener() {
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          laptopFactory.produce("The Best Laptop");
          laptopFactoryView.setMessage("Produced successfuly");
        } catch (Exception err) {
          laptopFactoryView.setMessage(err.getMessage());
        }
      }
    };

    this.laptopFactoryView.setProduceActionListener(actionListener);
  }
}
