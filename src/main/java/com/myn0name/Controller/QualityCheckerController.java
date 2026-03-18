package com.myn0name.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Factories.QualityChecker;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.View.LaptopFactoryView;
import com.myn0name.View.QualityCheckerView;


/**
 * QualityCheckerController
 */
public class QualityCheckerController {
  private QualityChecker qualityChecker;
  private QualityCheckerView qualityCheckerView;
  private LaptopFactory laptopFactory;

  public QualityCheckerController(QualityChecker qualityChecker, QualityCheckerView qualityCheckerView, LaptopFactory laptopFactory) {
    this.qualityChecker = qualityChecker;
    this.qualityCheckerView = qualityCheckerView;
    this.laptopFactory = laptopFactory;

    this.qualityCheckerView.setName(qualityChecker.getName());
    this.setCheckActionListener();
  }

  private void setCheckActionListener() {
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          try {
            qualityCheckerView.setMessage(qualityChecker.AssesQuality((Laptop) laptopFactory.getProduct()));
          } catch (Exception err) {
            qualityCheckerView.setMessage(err.getMessage());
          }
      }
    };

    this.qualityCheckerView.setCheckActionListener(actionListener);
  }
}
