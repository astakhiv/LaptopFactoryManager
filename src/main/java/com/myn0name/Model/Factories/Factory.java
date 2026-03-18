package com.myn0name.Model.Factories;

import com.myn0name.Model.Products.Product;

/** Factory */
public interface Factory {
  public String getName();

  public void setProductName(String productName);

  public void produce();

  public Product getProduct();
}
