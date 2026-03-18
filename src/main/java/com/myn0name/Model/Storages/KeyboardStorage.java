package com.myn0name.Model.Storages;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Product;

/** KeyboardStorage */
public class KeyboardStorage implements Storage {
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  private List<Keyboard> keyboards;

  private String name;

  public KeyboardStorage() {
    this.keyboards = new ArrayList<>();
    this.name = "Keyboard Storage";
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Product getProduct() {
    if (this.keyboards.isEmpty()) {
      throw new IndexOutOfBoundsException("No keyboards currently available");
    }

    Keyboard keyboard = this.keyboards.remove(keyboards.size() - 1);

    this.pcs.firePropertyChange("product number", this.keyboards.size() + 1, this.keyboards.size());

    return keyboard;
  }

  @Override
  public void reFillProducts() {
    Random random = new Random();
    float min = 0.6f;
    float max = 1.0f;
    int oldLength = this.keyboards.size();

    for (int i = keyboards.size(); i < 10; i++) {
      float quality = min + random.nextFloat() * (max - min);

      keyboards.add(new Keyboard("Best Keyboard", quality, "Black", "en-us"));
    }

    this.pcs.firePropertyChange("product number", oldLength, this.keyboards.size());
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    this.pcs.addPropertyChangeListener(listener);
  }

  public int getNumberOfItemsAvailable() {
    return this.keyboards.size();
  }
}
