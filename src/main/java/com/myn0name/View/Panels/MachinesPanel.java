package com.myn0name.View.Panels;

import javax.swing.JPanel;

import com.myn0name.Controller.MachineController;
import com.myn0name.Model.Machines.Line;
import com.myn0name.Model.Machines.RobotArm;
import com.myn0name.View.MachineView;

/** MachinesPanel */
public class MachinesPanel extends JPanel {
  public MachinesPanel(RobotArm robotArm, Line line) {
    MachineView robotArmView = new MachineView();
    MachineController robotArmController = new MachineController(robotArmView, robotArm);

    MachineView lineView = new MachineView();
    MachineController lineController = new MachineController(lineView, line);

    this.add(robotArmView);
    this.add(lineView);
  }
}
