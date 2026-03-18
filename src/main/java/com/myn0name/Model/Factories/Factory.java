package com.myn0name.Model.Factories;

import com.myn0name.Model.Products.Product;

/**
 * Factory
 */
public interface Factory {
    public String getName();
    public void produce(String name);
    public Product getProduct();
}
