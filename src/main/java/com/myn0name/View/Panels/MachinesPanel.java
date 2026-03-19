package com.myn0name.View.Panels;

import com.myn0name.View.MachineView;

import java.util.List;

import javax.swing.JPanel;

/** MachinesPanel */
public class MachinesPanel extends JPanel {
  public MachinesPanel(List<MachineView> machineViews) {
    for (int i = 0; i < machineViews.size(); i++) {
      this.add(machineViews.get(i));
    }
  }
}
