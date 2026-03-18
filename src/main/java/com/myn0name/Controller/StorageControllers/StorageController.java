package com.myn0name.Controller.StorageControllers;

import com.myn0name.Model.Builders.Builder;
import com.myn0name.Model.Products.Product;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.StorageView;

/** StorageController */
public class StorageController<T extends Product> {
  public StorageController(StorageView storageView, Storage<T> storage, Builder factory) {
    storageView.setName(storage.getName());
    storageView.setNumberOfProducts(
        String.format("Number of items: %d", storage.getNumberOfItemsAvailable()));

    storageView.setRefillButtonActionListener(new RefillButtonActionListener<T>(storage, factory));
    storage.addPropertyChangeListener(new StorageProperyChangeListener<T>(storage, storageView));
  }
}
