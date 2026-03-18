package com.myn0name.Controller.StorageControllers;

import com.myn0name.Model.Factories.Factory;
import com.myn0name.Model.Products.Product;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.StorageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/** StorageController */
public class StorageController<T extends Product> {
  private StorageView storageView;
  private Storage<T> storage;
  private Factory factory;

  public StorageController(StorageView storageView, Storage<T> storage, Factory factory) {
    this.storageView = storageView;
    this.storage = storage;
    this.factory = factory;

    this.storageView.setName(storage.getName());
    this.storageView.setNumberOfProducts(getNumberOfItemsString());

    this.setRefillButtonActionListener();
    storage.addPropertyChangeListener(
        new PropertyChangeListener() {
          public void propertyChange(PropertyChangeEvent e) {
            String propertyName = e.getPropertyName();

            if ("product number".equals(propertyName)) {
              storageView.setNumberOfProducts(getNumberOfItemsString());
            }
          }
        });
  }

  private void setRefillButtonActionListener() {
    ActionListener actionListener =
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            for (int i = storage.getNumberOfItemsAvailable(); i < 10; i++) {
              factory.produce();
              storage.addProduct((T) factory.getProduct());
            }
          }
        };
    this.storageView.setRefillButtonActionListener(actionListener);
  }

  private String getNumberOfItemsString() {
    return String.format("Number of items: %d", storage.getNumberOfItemsAvailable());
  }
}
