package com.myn0name;

import com.myn0name.Controller.LaptopProductionLineControllers.ProduceActionListener;
import com.myn0name.Controller.MachineControllers.MachinePropertyChangeListener;
import com.myn0name.Controller.MachineControllers.MaintenanceActionListener;
import com.myn0name.Controller.QualityCheckerControllers.CheckActionListener;
import com.myn0name.Controller.StorageControllers.RefillButtonActionListener;
import com.myn0name.Controller.StorageControllers.StorageProperyChangeListener;
import com.myn0name.Model.Builders.BodyBuilder;
import com.myn0name.Model.Builders.CPUBuilder;
import com.myn0name.Model.Builders.KeyboardBuilder;
import com.myn0name.Model.Builders.LaptopBuilder;
import com.myn0name.Model.LaptopProductionLine;
import com.myn0name.Model.Machines.Line;
import com.myn0name.Model.Machines.RobotArm;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Products.Laptop;
import com.myn0name.Model.QualityCheckers.FriendQualityChecker;
import com.myn0name.Model.QualityCheckers.OfficialQualityChecker;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.LaptopProductionLineManagerView;
import com.myn0name.View.LaptopProductionLineView;
import com.myn0name.View.MachineView;
import com.myn0name.View.Panels.ListPanel;
import com.myn0name.View.Panels.SoloPanel;
import com.myn0name.View.QualityCheckerView;
import com.myn0name.View.StorageView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App {
  public static void main(String[] args) {
    LaptopProductionLineManagerView laptopProductionLineManagerView =
        new LaptopProductionLineManagerView();

    // Model initialization
    RobotArm robotArm = new RobotArm(100, "LaptopBuilder");
    Line line = new Line(100, "LaptopBuilder");
    Storage<CPU> cpuStorage = new Storage<>("CPU Storage");
    Storage<Keyboard> keyboardStorage = new Storage<>("Keyboard Storage");
    Storage<Body> bodyStorage = new Storage<>("Body Storage");
    Storage<Laptop> laptopStorage = new Storage<>("laptopStorage");
    LaptopBuilder laptopBuilder = new LaptopBuilder(robotArm, line);
    CPUBuilder cpuBuilder = new CPUBuilder();
    cpuBuilder.setNumberOfCores(8);
    BodyBuilder bodyBuilder = new BodyBuilder();
    bodyBuilder.setColor("Silver");
    bodyBuilder.setMaterial("Aluminium");
    KeyboardBuilder keyboardBuilder = new KeyboardBuilder();
    keyboardBuilder.setColor("Black");
    keyboardBuilder.setLanguage("en-us");
    LaptopProductionLine laptopProductionLine =
        new LaptopProductionLine.LaptopProductionLineBuilder()
            .laptopBuilder(laptopBuilder)
            .bodyStorage(bodyStorage)
            .cpuStorage(cpuStorage)
            .laptopStorage(laptopStorage)
            .keyboardStorage(keyboardStorage)
            .build();
    OfficialQualityChecker officialQualityChecker = new OfficialQualityChecker();
    FriendQualityChecker friendQualityChecker = new FriendQualityChecker();

    // View initialization
    List<JPanel> machineViews = new ArrayList<>();
    MachineView robotArmView = new MachineView();
    MachineView lineView = new MachineView();
    machineViews.add(robotArmView);
    machineViews.add(lineView);
    ListPanel machinesPanel = new ListPanel(machineViews);

    LaptopProductionLineView laptopProductionLineView = new LaptopProductionLineView();
    SoloPanel laptopProductionLinePanel = new SoloPanel(laptopProductionLineView);

    List<JPanel> qualityCheckerViews = new ArrayList<>();
    QualityCheckerView officialQualityCheckerView = new QualityCheckerView();
    QualityCheckerView friendQualityCheckerView = new QualityCheckerView();
    qualityCheckerViews.add(officialQualityCheckerView);
    qualityCheckerViews.add(friendQualityCheckerView);
    ListPanel qualityCheckersPannel = new ListPanel(qualityCheckerViews);

    List<JPanel> storageViews = new ArrayList<>();
    StorageView cpuStorageView = new StorageView();
    StorageView bodyStorageView = new StorageView();
    StorageView keyboardStorageView = new StorageView();
    storageViews.add(cpuStorageView);
    storageViews.add(bodyStorageView);
    storageViews.add(keyboardStorageView);
    ListPanel storagesPalen = new ListPanel(storageViews);

    laptopProductionLineManagerView.addPanel(machinesPanel);
    laptopProductionLineManagerView.addPanel(laptopProductionLinePanel);
    laptopProductionLineManagerView.addPanel(qualityCheckersPannel);
    laptopProductionLineManagerView.addPanel(storagesPalen);

    // View setup
    robotArmView.setName(robotArm.getType());
    robotArmView.setState(String.format("State: %s", robotArm.getState()));

    String needsMaintenaceAns = robotArm.needsMaintenance() ? "yes" : "no";
    robotArmView.setNeedsMaintenace(String.format("Needs Maintenace: %s", needsMaintenaceAns));

    lineView.setName(line.getType());
    lineView.setState(String.format("State: %s", line.getState()));

    needsMaintenaceAns = line.needsMaintenance() ? "yes" : "no";
    lineView.setNeedsMaintenace(String.format("Needs Maintenace: %s", needsMaintenaceAns));

    laptopProductionLineView.setName(laptopProductionLine.getName());
    officialQualityCheckerView.setName(officialQualityChecker.getName());
    friendQualityCheckerView.setName(friendQualityChecker.getName());

    cpuStorageView.setName(cpuStorage.getName());
    cpuStorageView.setNumberOfProducts(
        String.format("Products available: %d", cpuStorage.getNumberOfItemsAvailable()));
    bodyStorageView.setName(bodyStorage.getName());
    bodyStorageView.setNumberOfProducts(
        String.format("Products available: %d", bodyStorage.getNumberOfItemsAvailable()));
    keyboardStorageView.setName(keyboardStorage.getName());
    keyboardStorageView.setNumberOfProducts(
        String.format("Products available: %d", keyboardStorage.getNumberOfItemsAvailable()));

    // Controller setup
    robotArm.addPropertyChangeListener(new MachinePropertyChangeListener(robotArm, robotArmView));
    robotArmView.setMaintainActionListener(new MaintenanceActionListener(robotArm));

    line.addPropertyChangeListener(new MachinePropertyChangeListener(line, lineView));
    lineView.setMaintainActionListener(new MaintenanceActionListener(line));

    laptopProductionLineView.setProduceActionListener(
        new ProduceActionListener(laptopProductionLine, laptopProductionLineView));

    officialQualityCheckerView.setCheckActionListener(
        new CheckActionListener(officialQualityChecker, laptopStorage, officialQualityCheckerView));
    friendQualityCheckerView.setCheckActionListener(
        new CheckActionListener(friendQualityChecker, laptopStorage, friendQualityCheckerView));

    cpuStorage.addPropertyChangeListener(
        new StorageProperyChangeListener<>(cpuStorage, cpuStorageView));
    cpuStorageView.setRefillButtonActionListener(
        new RefillButtonActionListener<>(cpuStorage, cpuBuilder));
    bodyStorage.addPropertyChangeListener(
        new StorageProperyChangeListener<>(bodyStorage, bodyStorageView));
    bodyStorageView.setRefillButtonActionListener(
        new RefillButtonActionListener<>(bodyStorage, bodyBuilder));
    keyboardStorage.addPropertyChangeListener(
        new StorageProperyChangeListener<>(keyboardStorage, keyboardStorageView));
    keyboardStorageView.setRefillButtonActionListener(
        new RefillButtonActionListener<>(keyboardStorage, keyboardBuilder));

    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            laptopProductionLineManagerView.startUI();
          }
        });
  }
}
