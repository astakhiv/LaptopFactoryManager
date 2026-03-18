package com.myn0name.Model.Storages;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Product;

/** CPUStorage */
public class CPUStorage implements Storage {
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  private List<CPU> cpus;
  private String name;

  public CPUStorage() {
    this.cpus = new ArrayList<>();
    this.name = "CPU Storage";
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Product getProduct() {
    if (this.cpus.isEmpty()) {
      throw new IndexOutOfBoundsException("No CPUs currently available");
    }

    CPU cpu = this.cpus.remove(cpus.size() - 1);

    this.pcs.firePropertyChange("product number", this.cpus.size() + 1, this.cpus.size());

    return cpu;
  }

  @Override
  public void reFillProducts() {
    Random random = new Random();
    float min = 0.6f;
    float max = 1.0f;
    int oldLength = this.cpus.size();

    for (int i = cpus.size(); i < 10; i++) {
      float quality = min + random.nextFloat() * (max - min);

      cpus.add(new CPU("Best CPU", quality, 8));
    }
    this.pcs.firePropertyChange("product number", oldLength, this.cpus.size());
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    this.pcs.addPropertyChangeListener(listener);
  }

  public int getNumberOfItemsAvailable() {
    return this.cpus.size();
  }
}
