package com.myn0name;

import javax.swing.SwingUtilities;

import com.myn0name.View.LaptopFactoryManager;

public class App {
  public static void main(String[] args) {
    LaptopFactoryManager laptopFactoryManager = new LaptopFactoryManager();

    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        laptopFactoryManager.startUI();
      }
    });
  }
}
