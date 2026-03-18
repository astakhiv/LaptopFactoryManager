package com.myn0name.Controller.MachineControllers;

import com.myn0name.Model.Machines.Machine;
import com.myn0name.View.MachineView;

/** MachineController */
public class MachineController {
  public MachineController(MachineView machineView, Machine machine) {
    machineView.setName(machine.getType());
    machineView.setState(String.format("State: %s", machine.getState()));

    String needsMaintenaceAns = machine.needsMaintenance() ? "yes" : "no";
    machineView.setNeedsMaintenace(String.format("Needs Maintenace: %s", needsMaintenaceAns));

    machine.addPropertyChangeListener(new MachinePropertyChangeListener(machine, machineView));

    machineView.setMaintainActionListener(new MaintenanceActionListener(machine));
  }
}
