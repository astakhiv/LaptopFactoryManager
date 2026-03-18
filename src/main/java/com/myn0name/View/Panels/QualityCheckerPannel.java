package com.myn0name.View.Panels;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.myn0name.Controller.QualityCheckerController;
import com.myn0name.Model.Factories.QualityChecker;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.View.QualityCheckerView;


/**
 * QualityCheckersPannel
 */
public class QualityCheckerPannel extends JPanel {
  public QualityCheckerPannel(QualityChecker qualityChecker, Storage<Laptop> laptopStorage) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    QualityCheckerView qualityCheckerView = new QualityCheckerView();
    QualityCheckerController qualityCheckerController = new QualityCheckerController(qualityChecker, qualityCheckerView, laptopStorage);

    this.add(qualityCheckerView);
  }
}
