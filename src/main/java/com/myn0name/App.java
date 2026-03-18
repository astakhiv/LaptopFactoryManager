package com.myn0name;

import com.myn0name.View.LaptopProductionLineManager;
import javax.swing.SwingUtilities;

public class App {
  public static void main(String[] args) {
    LaptopProductionLineManager laptopFactoryManager = new LaptopProductionLineManager();

    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            laptopFactoryManager.startUI();
          }
        });
  }
}
