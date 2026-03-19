package com.myn0name.View;

import com.myn0name.Model.Builders.BodyBuilder;
import com.myn0name.Model.Builders.CPUBuilder;
import com.myn0name.Model.Builders.KeyboardBuilder;
import com.myn0name.Model.Builders.LaptopBuilder;
import com.myn0name.Model.QualityCheckers.FriendQualityChecker;
import com.myn0name.Model.QualityCheckers.OfficialQualityChecker;
import com.myn0name.Model.QualityCheckers.QualityChecker;
import com.myn0name.Model.LaptopProductionLine;
import com.myn0name.Model.Machines.Line;
import com.myn0name.Model.Machines.RobotArm;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.Panels.LaptopProductionLinePanel;
import com.myn0name.View.Panels.MachinesPanel;
import com.myn0name.View.Panels.QualityCheckersPannel;
import com.myn0name.View.Panels.StoragesPalen;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/** LaptopProductionLineManager */
public class LaptopProductionLineManager {
  private LaptopProductionLine laptopProductionLine;
  private LaptopBuilder laptopBuilder;
  private CPUBuilder cpuBuilder;
  private BodyBuilder bodyBuilder;
  private KeyboardBuilder keyboardBuilder;
  private Storage<CPU> cpuStorage;
  private Storage<Keyboard> keyboardStorage;
  private Storage<Body> bodyStorage;
  private Storage<Laptop> laptopStorage;
  private RobotArm robotArm;
  private Line line;

  public LaptopProductionLineManager() {
    this.robotArm = new RobotArm(100, "LaptopBuilder");
    this.line = new Line(100, "LaptopBuilder");
    this.cpuStorage = new Storage<>("CPU Storage");
    this.keyboardStorage = new Storage<>("Keyboard Storage");
    this.bodyStorage = new Storage<>("Body Storage");
    this.laptopStorage = new Storage<>("laptopStorage");
    this.laptopBuilder = new LaptopBuilder(robotArm, line);
    this.cpuBuilder = new CPUBuilder();
    cpuBuilder.setNumberOfCores(8);
    this.bodyBuilder = new BodyBuilder();
    bodyBuilder.setColor("Silver");
    bodyBuilder.setMaterial("Aluminium");
    this.keyboardBuilder = new KeyboardBuilder();
    keyboardBuilder.setColor("Black");
    keyboardBuilder.setLanguage("en-us");
    this.laptopProductionLine = new LaptopProductionLine.LaptopProductionLineBuilder()
      .laptopBuilder(laptopBuilder)
      .bodyStorage(bodyStorage)
      .cpuStorage(cpuStorage)
      .laptopStorage(laptopStorage)
      .keyboardStorage(keyboardStorage).build();
  }

  public void startUI() {
    JFrame frame = new JFrame("LaptopBuilderManager");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(new GridLayout(1, 3));

    OfficialQualityChecker officialQualityChecker = new OfficialQualityChecker();
    FriendQualityChecker friendQualityChecker = new FriendQualityChecker();

    List<QualityChecker> qualityCheckers = new ArrayList<>();
    qualityCheckers.add(officialQualityChecker);
    qualityCheckers.add(friendQualityChecker);

    frame.add(new MachinesPanel(robotArm, line));
    frame.add(new LaptopProductionLinePanel(laptopProductionLine));
    frame.add(new QualityCheckersPannel(qualityCheckers, laptopStorage));
    frame.add(
        new StoragesPalen(
            cpuStorage, keyboardStorage, bodyStorage, cpuBuilder, keyboardBuilder, bodyBuilder));

    frame.pack();

    frame.setVisible(true);
  }
}
