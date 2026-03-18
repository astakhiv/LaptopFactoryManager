package com.myn0name.Controller;

import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.StorageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/** StorageController */
public class StorageController {
  private StorageView storageView;
  private Storage storage;

  public StorageController(StorageView storageView, Storage storage) {
    this.storageView = storageView;
    this.storage = storage;

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
            storage.reFillProducts();
          }
        };
    this.storageView.setRefillButtonActionListener(actionListener);
  }

  private String getNumberOfItemsString() {
    return String.format("Number of items: %d", storage.getNumberOfItemsAvailable());
  }
}
