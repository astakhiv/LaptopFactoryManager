package com.myn0name.Controller.LaptopProductionLineControllers;

import com.myn0name.Model.LaptopProductionLine;
import com.myn0name.View.LaptopProductionLineView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** ProduceActionListener */
public class ProduceActionListener implements ActionListener {
  private LaptopProductionLine laptopProductionLine;
  private LaptopProductionLineView laptopProductionLineView;

  public ProduceActionListener(
      LaptopProductionLine laptopProductionLine,
      LaptopProductionLineView laptopProductionLineView) {

    this.laptopProductionLine = laptopProductionLine;
    this.laptopProductionLineView = laptopProductionLineView;
  }

  public void actionPerformed(ActionEvent e) {
    try {
      this.laptopProductionLine.produce();
      this.laptopProductionLineView.setMessage("Produced succesfuly");
    } catch (Exception err) {
      this.laptopProductionLineView.setMessage(err.getMessage());
    }
  }
}
