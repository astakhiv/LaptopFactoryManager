package com.myn0name.Controller.MachineControllers;

import com.myn0name.Model.Machines.Machine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** MaintenanceActionListener */
public class MaintenanceActionListener implements ActionListener {
  private Machine machine;

  public MaintenanceActionListener(Machine machine) {
    this.machine = machine;
  }

  public void actionPerformed(ActionEvent e) {
    machine.fix();
  }
}
