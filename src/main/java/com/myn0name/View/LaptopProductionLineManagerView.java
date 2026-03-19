package com.myn0name.View;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** LaptopProductionLineManager */
public class LaptopProductionLineManagerView {
  private JFrame frame;

  public LaptopProductionLineManagerView() {
    this.frame = new JFrame("LaptopBuilderManager");
  }

  public void startUI() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(new GridLayout(1, 3));

    frame.pack();

    frame.setVisible(true);
  }

  public void addPanel(JPanel panel) {
    frame.add(panel);
  }
}
