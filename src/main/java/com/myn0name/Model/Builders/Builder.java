package com.myn0name.Model.Builders;

import com.myn0name.Model.Products.Product;

/** Builder */
public interface Builder<T extends Product> {
  public String getName();

  public void setProductName(String productName);

  public void produce();

  public T getProduct();
}
