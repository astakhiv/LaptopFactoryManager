package com.myn0name.View;

import com.myn0name.Model.Factories.BodyFactory;
import com.myn0name.Model.Factories.CPUFactory;
import com.myn0name.Model.Factories.KeyboardFactory;
import com.myn0name.Model.Factories.LaptopFactory;
import com.myn0name.Model.Factories.QualityChecker;
import com.myn0name.Model.Machines.Line;
import com.myn0name.Model.Machines.RobotArm;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.Storages.Storage;
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
  private CPUFactory cpuFactory;
  private BodyFactory bodyFactory;
  private KeyboardFactory keyboardFactory;
  private Storage<CPU> cpuStorage;
  private Storage<Keyboard> keyboardStorage;
  private Storage<Body> bodyStorage;
  private Storage<Laptop> laptopStorage;
  private RobotArm robotArm;
  private Line line;

  public LaptopFactoryManager() {
    this.robotArm = new RobotArm(100, "LaptopFactory");
    this.line = new Line(100, "LaptopFactory");
    this.cpuStorage = new Storage<>("CPU Storage");
    this.keyboardStorage = new Storage<>("Keyboard Storage");
    this.bodyStorage = new Storage<>("Body Storage");
    this.laptopStorage = new Storage<>("laptopStorage");
    this.laptopFactory =
        new LaptopFactory(robotArm, line, cpuStorage, keyboardStorage, bodyStorage);
    this.cpuFactory = new CPUFactory();
    cpuFactory.setNumberOfCores(8);
    this.bodyFactory = new BodyFactory();
    bodyFactory.setColor("Silver");
    bodyFactory.setMaterial("Aluminium");
    this.keyboardFactory = new KeyboardFactory();
    keyboardFactory.setColor("Black");
    keyboardFactory.setLanguage("en-us");
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
    frame.add(new LaptopFactoryPanel(laptopFactory, laptopStorage));
    frame.add(new QualityCheckersPannel(qualityCheckers, laptopFactory));
    frame.add(
        new StoragesPalen(
            cpuStorage, keyboardStorage, bodyStorage, cpuFactory, keyboardFactory, bodyFactory));

    frame.pack();

    frame.setVisible(true);
  }
}
