package com.myn0name.Controller;

import com.myn0name.Model.Factories.QualityChecker;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.QualityCheckerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** QualityCheckerController */
public class QualityCheckerController {
  private QualityChecker qualityChecker;
  private QualityCheckerView qualityCheckerView;
  private Storage<Laptop> laptopStorage;

  public QualityCheckerController(
      QualityChecker qualityChecker,
      QualityCheckerView qualityCheckerView,
      Storage<Laptop> laptopStorage) {
    this.qualityChecker = qualityChecker;
    this.qualityCheckerView = qualityCheckerView;
    this.laptopStorage = laptopStorage;

    this.qualityCheckerView.setName(qualityChecker.getName());
    this.setCheckActionListener();
  }

  private void setCheckActionListener() {
    ActionListener actionListener =
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            try {
              qualityCheckerView.setMessage(
                  qualityChecker.AssesQuality((Laptop) laptopStorage.seeProduct()));
            } catch (Exception err) {
              qualityCheckerView.setMessage(err.getMessage());
            }
          }
        };

    this.qualityCheckerView.setCheckActionListener(actionListener);
  }
}
