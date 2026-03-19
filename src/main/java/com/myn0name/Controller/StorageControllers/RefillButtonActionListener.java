package com.myn0name.Controller.StorageControllers;

import com.myn0name.Model.Builders.Builder;
import com.myn0name.Model.Products.Product;
import com.myn0name.Model.Storages.Storage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** RefillButtonActionListener */
public class RefillButtonActionListener<T extends Product> implements ActionListener {
  private Storage<T> storage;
  private Builder<T> builder;

  public RefillButtonActionListener(Storage<T> storage, Builder<T> builder) {
    this.storage = storage;
    this.builder = builder;
  }

  public void actionPerformed(ActionEvent e) {
    for (int i = storage.getNumberOfItemsAvailable(); i < 10; i++) {
      builder.produce();
      storage.addProduct(builder.getProduct());
    }
  }
}
