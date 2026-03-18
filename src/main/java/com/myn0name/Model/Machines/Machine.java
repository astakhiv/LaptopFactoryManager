package com.myn0name.Model.Machines;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Machine {
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  private int machine_id;
  private String state;
  private String type;
  private String factory;

  protected int durability;

  public Machine(int durability, String factory, String type) {
    this.durability = durability;
    this.setState("Rest");
    this.machine_id = (int) (Math.random() * 1000000);
    this.factory = factory;
    this.type = type;
  }

  public int getDurability() {
    return this.durability;
  }

  public int getId() {
    return this.machine_id;
  }

  public String getType() {
    return this.type;
  }

  public String getState() {
    return this.state;
  }

  public String getFactory() {
    return this.factory;
  }

  public void setState(String state) {
    String oldState = this.state;
    this.state = state;
    
    this.pcs.firePropertyChange("state", oldState, this.state);
  }

  public abstract boolean needsMaintenance();

  public abstract void work();

  public void fix() {
    if (this.durability < 90) {
      this.durability = 90;
    }
    this.setState("Rest");
  }
  
  public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
  }
}
