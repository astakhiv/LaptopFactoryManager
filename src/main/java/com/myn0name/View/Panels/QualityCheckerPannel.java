package com.myn0name.View.Panels;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.myn0name.Controller.LaptopFactoryController;
import com.myn0name.Controller.QualityCheckerController;
import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Factories.QualityChecker;
import com.myn0name.View.QualityCheckerView;


/**
 * QualityCheckersPannel
 */
public class QualityCheckerPannel extends JPanel {
  public QualityCheckerPannel(QualityChecker qualityChecker, LaptopFactory laptopFactory) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    QualityCheckerView qualityCheckerView = new QualityCheckerView();
    QualityCheckerController qualityCheckerController = new QualityCheckerController(qualityChecker, qualityCheckerView, laptopFactory);

    this.add(qualityCheckerView);
  }
}
