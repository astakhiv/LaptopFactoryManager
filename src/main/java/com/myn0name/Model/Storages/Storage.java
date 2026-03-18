package com.myn0name.Model.Storages;

import com.myn0name.Model.Products.Product;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/** Storage */
public class Storage<T extends Product> {
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  private List<T> products;
  private String name;

  public Storage(String name) {
    this.products = new ArrayList<>();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public T seeProduct() {
    if (this.products.isEmpty()) {
      throw new IndexOutOfBoundsException(
          String.format("No products in the %s currently available", this.name));
    }

    return this.products.get(this.products.size() - 1);
  }

  public T getProduct() {
    if (this.products.isEmpty()) {
      throw new IndexOutOfBoundsException(
          String.format("No products in the %s currently available", this.name));
    }

    T product = this.products.remove(products.size() - 1);

    this.pcs.firePropertyChange("product number", this.products.size() + 1, this.products.size());

    return product;
  }

  public void addProduct(T product) {
    this.products.add(product);

    this.pcs.firePropertyChange("product number", this.products.size(), this.products.size() - 1);
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    this.pcs.addPropertyChangeListener(listener);
  }

  public int getNumberOfItemsAvailable() {
    return this.products.size();
  }
}
