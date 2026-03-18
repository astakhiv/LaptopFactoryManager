package com.myn0name.Model.Storages;

import com.myn0name.Model.Products.Product;
import java.beans.PropertyChangeListener;

/** Storage */
public interface Storage {
  public String getName();

  public Product getProduct();

  public void reFillProducts();

  public void addPropertyChangeListener(PropertyChangeListener listener);

  public int getNumberOfItemsAvailable();
}
