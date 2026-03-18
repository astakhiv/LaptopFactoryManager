package com.myn0name.View.Panels;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Factories.QualityChecker;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.Model.Products.Laptop;


/**
 * QualityCheckersPannel
 */
public class QualityCheckersPannel extends JPanel {
  public QualityCheckersPannel(List<QualityChecker> qualityCheckers, Storage<Laptop> laptopStorage) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    for (int i = 0; i < qualityCheckers.size(); i++) {
      QualityCheckerPannel qualityCheckerPannel = new QualityCheckerPannel(qualityCheckers.get(i), laptopStorage);

      this.add(qualityCheckerPannel);
    }
  }
}
