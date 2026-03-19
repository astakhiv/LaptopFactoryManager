package com.myn0name.Controller.QualityCheckerControllers;

import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.QualityCheckers.QualityChecker;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.QualityCheckerView;

/** QualityCheckerController */
public class QualityCheckerController {
  public QualityCheckerController(
      QualityChecker qualityChecker,
      QualityCheckerView qualityCheckerView,
      Storage<Laptop> laptopStorage) {

    qualityCheckerView.setName(qualityChecker.getName());
    qualityCheckerView.setCheckActionListener(
        new CheckActionListener(qualityChecker, laptopStorage, qualityCheckerView));
  }
}
