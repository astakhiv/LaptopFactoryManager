package com.myn0name.View.Panels;

import com.myn0name.Controller.LaptopProductionLineControllers.LaptopProductionLineController;
import com.myn0name.Model.LaptopProductionLine;
import com.myn0name.View.LaptopProductionLineView;
import javax.swing.JPanel;

/** LaptopProductionLinePanel */
public class LaptopProductionLinePanel extends JPanel {
  public LaptopProductionLinePanel(LaptopProductionLine laptopProductionLine) {
    LaptopProductionLineView laptopProductionLineView = new LaptopProductionLineView();
    LaptopProductionLineController laptopBuilderController =
        new LaptopProductionLineController(laptopProductionLine, laptopProductionLineView);

    this.add(laptopProductionLineView);
  }
}
