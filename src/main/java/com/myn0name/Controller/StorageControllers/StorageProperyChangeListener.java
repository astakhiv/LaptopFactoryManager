package com.myn0name.Controller.StorageControllers;

import com.myn0name.Model.Products.Product;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.StorageView;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/** StorageProperyChangeListener */
public class StorageProperyChangeListener<T extends Product> implements PropertyChangeListener {
  private Storage<T> storage;
  private StorageView storageView;

  public StorageProperyChangeListener(Storage<T> storage, StorageView storageView) {
    this.storageView = storageView;
    this.storage = storage;
  }

  public void propertyChange(PropertyChangeEvent e) {
    String propertyName = e.getPropertyName();

    if ("product number".equals(propertyName)) {
      storageView.setNumberOfProducts(
          String.format("Number of items: %d", storage.getNumberOfItemsAvailable()));
    }
  }
}
