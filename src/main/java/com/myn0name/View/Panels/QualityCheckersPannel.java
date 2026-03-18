package com.myn0name.View.Panels;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Factories.QualityChecker;


/**
 * QualityCheckersPannel
 */
public class QualityCheckersPannel extends JPanel {
  public QualityCheckersPannel(List<QualityChecker> qualityCheckers, LaptopFactory laptopFactory) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    for (int i = 0; i < qualityCheckers.size(); i++) {
      QualityCheckerPannel qualityCheckerPannel = new QualityCheckerPannel(qualityCheckers.get(i), laptopFactory);

      this.add(qualityCheckerPannel);
    }
  }
}
