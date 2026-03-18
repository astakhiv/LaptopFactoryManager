package com.myn0name.Model.Storages;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.Product;

/** BodyStorage */
public class BodyStorage implements Storage {
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  private List<Body> bodies;
  private String name;

  public BodyStorage() {
    this.bodies = new ArrayList<>();
    this.name = "Body Storage";
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Product getProduct() {
    if (this.bodies.isEmpty()) {
      throw new IndexOutOfBoundsException("No bodies currently available");
    }

    Body body = this.bodies.remove(bodies.size() - 1);

    this.pcs.firePropertyChange("product number", this.bodies.size() + 1, this.bodies.size());

    return body;
  }

  @Override
  public void reFillProducts() {
    Random random = new Random();
    float min = 0.6f;
    float max = 1.0f;
    int oldLength = this.bodies.size();

    for (int i = bodies.size(); i < 10; i++) {
      float quality = min + random.nextFloat() * (max - min);

      bodies.add(new Body("Best Body", quality, "Silver", "Aluminium"));
    }

    this.pcs.firePropertyChange("product number", oldLength, this.bodies.size());
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    this.pcs.addPropertyChangeListener(listener);
  }

  public int getNumberOfItemsAvailable() {
    return this.bodies.size();
  }
}
