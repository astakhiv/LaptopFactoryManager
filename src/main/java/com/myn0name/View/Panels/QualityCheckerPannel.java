package com.myn0name.View.Panels;

import com.myn0name.View.QualityCheckerView;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/** QualityCheckersPannel */
public class QualityCheckerPannel extends JPanel {
  public QualityCheckerPannel(QualityCheckerView qualityCheckerView) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    this.add(qualityCheckerView);
  }
}
