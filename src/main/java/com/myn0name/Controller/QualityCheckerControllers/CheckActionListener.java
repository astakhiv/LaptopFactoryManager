package com.myn0name.Controller.QualityCheckerControllers;

import com.myn0name.Model.QualityCheckers.QualityChecker;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.QualityCheckerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** CheckActionListener */
public class CheckActionListener implements ActionListener {
  private QualityChecker qualityChecker;
  private Storage<Laptop> laptopStorage;
  private QualityCheckerView qualityCheckerView;

  public CheckActionListener(
      QualityChecker qualityChecker,
      Storage<Laptop> laptopStorage,
      QualityCheckerView qualityCheckerView) {

    this.qualityChecker = qualityChecker;
    this.qualityCheckerView = qualityCheckerView;
    this.laptopStorage = laptopStorage;
  }

  public void actionPerformed(ActionEvent e) {
    try {
      qualityCheckerView.setMessage(
          qualityChecker.AssesQuality((Laptop) laptopStorage.seeProduct()));
    } catch (Exception err) {
      qualityCheckerView.setMessage(err.getMessage());
    }
  }
}
