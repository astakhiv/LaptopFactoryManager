package com.myn0name.View.Panels;

import com.myn0name.View.QualityCheckerView;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/** QualityCheckersPannel */
public class QualityCheckersPannel extends JPanel {
  public QualityCheckersPannel(List<QualityCheckerView> qualityCheckerViews) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    for (int i = 0; i < qualityCheckerViews.size(); i++) {
      this.add(qualityCheckerViews.get(i));
    }
  }
}
