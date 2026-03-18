package com.myn0name.Controller.MachineControllers;

import com.myn0name.Model.Machines.Machine;
import com.myn0name.View.MachineView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/** MachineController */
public class MachineController {
  private MachineView machineView;
  private Machine machine;

  public MachineController(MachineView machineView, Machine machine) {
    this.machineView = machineView;
    this.machine = machine;

    machineView.setName(String.format("%s", machine.getType()));
    machineView.setState(getStateString());
    machineView.setNeedsMaintenace(getNeedsMaintenanceString());

    machine.addPropertyChangeListener(
        new PropertyChangeListener() {
          public void propertyChange(PropertyChangeEvent e) {
            String propertyName = e.getPropertyName();

            if ("state".equals(propertyName)) {
              machineView.setState(getStateString());
              machineView.setNeedsMaintenace(getNeedsMaintenanceString());
            }
          }
        });

    setMaintainActionListener();
  }

  private void setMaintainActionListener() {
    ActionListener actionListener =
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            machine.fix();
          }
        };

    machineView.setMaintainActionListener(actionListener);
  }

  private String getStateString() {
    return String.format("State: %s", machine.getState());
  }

  private String getNeedsMaintenanceString() {
    String needsMaintenaceAns = machine.needsMaintenance() ? "yes" : "no";
    return String.format("Needs Maintenace: %s", needsMaintenaceAns);
  }
}
