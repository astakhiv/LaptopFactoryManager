package com.myn0name.View.Panels;

import com.myn0name.Model.Builders.QualityChecker;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/** QualityCheckersPannel */
public class QualityCheckersPannel extends JPanel {
  public QualityCheckersPannel(
      List<QualityChecker> qualityCheckers, Storage<Laptop> laptopStorage) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    for (int i = 0; i < qualityCheckers.size(); i++) {
      QualityCheckerPannel qualityCheckerPannel =
          new QualityCheckerPannel(qualityCheckers.get(i), laptopStorage);

      this.add(qualityCheckerPannel);
    }
  }
}
