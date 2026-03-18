package com.myn0name.Controller.StorageControllers;

import com.myn0name.Model.Factories.Factory;
import com.myn0name.Model.Products.Product;
import com.myn0name.Model.Storages.Storage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** RefillButtonActionListener */
public class RefillButtonActionListener<T extends Product> implements ActionListener {
  private Storage<T> storage;
  private Factory factory;

  public RefillButtonActionListener(Storage<T> storage, Factory factory) {
    this.storage = storage;
    this.factory = factory;
  }

  public void actionPerformed(ActionEvent e) {
    for (int i = storage.getNumberOfItemsAvailable(); i < 10; i++) {
      factory.produce();
      storage.addProduct((T) factory.getProduct());
    }
  }
}
