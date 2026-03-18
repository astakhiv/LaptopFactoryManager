package com.myn0name.View;

import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Factories.QualityChecker;
import com.myn0name.Model.Machines.Line;
import com.myn0name.Model.Machines.RobotArm;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.BodyStorage;
import com.myn0name.Model.Storages.CPUStorage;
import com.myn0name.Model.Storages.KeyboardStorage;
import com.myn0name.View.Panels.LaptopFactoryPanel;
import com.myn0name.View.Panels.MachinesPanel;
import com.myn0name.View.Panels.QualityCheckersPannel;
import com.myn0name.View.Panels.StoragesPalen;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/** LaptopFactoryManager */
public class LaptopFactoryManager {
  private LaptopFactory laptopFactory;
  private CPUStorage cpuStorage;
  private KeyboardStorage keyboardStorage;
  private BodyStorage bodyStorage;
  private RobotArm robotArm;
  private Line line;

  public LaptopFactoryManager() {
    this.robotArm = new RobotArm(100, "LaptopFactory");
    this.line = new Line(100, "LaptopFactory");
    this.cpuStorage = new CPUStorage();
    this.keyboardStorage = new KeyboardStorage();
    this.bodyStorage = new BodyStorage();
    this.laptopFactory =
        new LaptopFactory(robotArm, line, cpuStorage, keyboardStorage, bodyStorage);
  }

  public void startUI() {
    JFrame frame = new JFrame("LaptopFactoryManager");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(new GridLayout(1, 3));

    LaptopFactory.OfficialQualityChecker officialQualityChecker =
        new LaptopFactory.OfficialQualityChecker();
    QualityChecker friendQualityChecker =
        new QualityChecker() {
          public String AssesQuality(Laptop laptop) {
            if (laptop == null) {
              throw new NullPointerException("No Laptop was provided.");
            }

            float quality = laptop.getQuality();

            if (quality >= 0.9) {
              return "WHERE DID U FIND THAT";
            } else if (quality >= 0.5) {
              return "Just... Perfect!..";
            } else {
              return "Well, I may run Minecraft on that... I guess...";
            }
          }

          public String getName() {
            return "Friend's Quality Checker";
          }
        };

    List<QualityChecker> qualityCheckers = new ArrayList<>();
    qualityCheckers.add(officialQualityChecker);
    qualityCheckers.add(friendQualityChecker);

    frame.add(new MachinesPanel(robotArm, line));
    frame.add(new LaptopFactoryPanel(laptopFactory));
    frame.add(new QualityCheckersPannel(qualityCheckers, laptopFactory));
    frame.add(new StoragesPalen(cpuStorage, keyboardStorage, bodyStorage));

    frame.pack();

    frame.setVisible(true);
  }
}
