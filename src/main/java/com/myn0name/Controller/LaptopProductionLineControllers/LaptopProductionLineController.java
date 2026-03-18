package com.myn0name.Controller.LaptopProductionLineControllers;

import com.myn0name.Model.LaptopProductionLine;
import com.myn0name.View.LaptopProductionLineView;

/** LaptopProductionLineController */
public class LaptopProductionLineController {
  public LaptopProductionLineController(
      LaptopProductionLine laptopProductionLine,
      LaptopProductionLineView laptopProductionLineView) {

    laptopProductionLineView.setName(laptopProductionLine.getName());

    laptopProductionLineView.setProduceActionListener(
        new ProduceActionListener(laptopProductionLine, laptopProductionLineView));
  }
}
