package com.myn0name.View;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** MachineView */
public class MachineView extends JPanel {
  private JLabel name;
  private JLabel state;
  private JLabel needsMaintenance;
  private JButton maintain;

  public MachineView() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    this.name = new JLabel();
    this.state = new JLabel();
    this.needsMaintenance = new JLabel();
    this.maintain = new JButton("Maintain");

    this.add(name);
    this.add(state);
    this.add(needsMaintenance);
    this.add(maintain);
  }

  public void setName(String name) {
    this.name.setText(name);
  }

  public void setState(String state) {
    this.state.setText(state);
  }

  public void setNeedsMaintenace(String needsMaintenance) {
    this.needsMaintenance.setText(needsMaintenance);
  }

  public void setMaintainActionListener(ActionListener actionListener) {
    this.maintain.addActionListener(actionListener);
  }
}
