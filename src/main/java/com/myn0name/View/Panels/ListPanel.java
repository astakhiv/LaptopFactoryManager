package com.myn0name.View.Panels;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/** ListPanel */
public class ListPanel extends JPanel {
  public ListPanel(List<JPanel> panels) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    for (int i = 0; i < panels.size(); i++) {
      this.add(panels.get(i));
    }
  }
}
