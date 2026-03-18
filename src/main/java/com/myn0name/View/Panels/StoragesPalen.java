package com.myn0name.View.Panels;

import com.myn0name.Controller.StorageController;
import com.myn0name.Model.Storages.BodyStorage;
import com.myn0name.Model.Storages.CPUStorage;
import com.myn0name.Model.Storages.KeyboardStorage;
import com.myn0name.View.StorageView;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/** StoragesPalen */
public class StoragesPalen extends JPanel {
  public StoragesPalen(
      CPUStorage cpuStorage, KeyboardStorage keyboardStorage, BodyStorage bodyStorage) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    StorageView cpuStorageView = new StorageView();
    StorageView bodyStorageView = new StorageView();
    StorageView keyboardStorageView = new StorageView();

    StorageController cpuStorageController = new StorageController(cpuStorageView, cpuStorage);
    StorageController bodyStorageController = new StorageController(bodyStorageView, bodyStorage);
    StorageController keyboardStorageController =
        new StorageController(keyboardStorageView, keyboardStorage);

    this.add(cpuStorageView);
    this.add(bodyStorageView);
    this.add(keyboardStorageView);
  }
}
