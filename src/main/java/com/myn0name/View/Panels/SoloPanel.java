package com.myn0name.View.Panels;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/** SoloPanel */
public class SoloPanel extends JPanel {
  public SoloPanel(JPanel panel) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    this.add(panel);
  }
}
