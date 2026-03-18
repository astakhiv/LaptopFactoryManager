package com.myn0name.Controller.MachineControllers;

import com.myn0name.Model.Machines.Machine;
import com.myn0name.View.MachineView;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/** MachinePropertyChangeListener */
public class MachinePropertyChangeListener implements PropertyChangeListener {
  private MachineView machineView;
  private Machine machine;

  public MachinePropertyChangeListener(Machine machine, MachineView machineView) {
    this.machine = machine;
    this.machineView = machineView;
  }

  public void propertyChange(PropertyChangeEvent e) {
    String propertyName = e.getPropertyName();

    if ("state".equals(propertyName)) {
      machineView.setState(String.format("State: %s", machine.getState()));

      String needsMaintenaceAns = machine.needsMaintenance() ? "yes" : "no";
      machineView.setNeedsMaintenace(String.format("Needs Maintenace: %s", needsMaintenaceAns));
    }
  }
}
