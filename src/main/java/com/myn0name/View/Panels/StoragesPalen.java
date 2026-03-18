package com.myn0name.View.Panels;

import com.myn0name.Controller.StorageControllers.StorageController;
import com.myn0name.Model.Builders.BodyBuilder;
import com.myn0name.Model.Builders.CPUBuilder;
import com.myn0name.Model.Builders.KeyboardBuilder;
import com.myn0name.Model.Products.Body;
import com.myn0name.Model.Products.CPU;
import com.myn0name.Model.Products.Keyboard;
import com.myn0name.Model.Storages.Storage;
import com.myn0name.View.StorageView;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/** StoragesPalen */
public class StoragesPalen extends JPanel {
  public StoragesPalen(
      Storage<CPU> cpuStorage,
      Storage<Keyboard> keyboardStorage,
      Storage<Body> bodyStorage,
      CPUBuilder cpuBuilder,
      KeyboardBuilder keyboardBuilder,
      BodyBuilder bodyBuilder) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    StorageView cpuStorageView = new StorageView();
    StorageView bodyStorageView = new StorageView();
    StorageView keyboardStorageView = new StorageView();

    StorageController<CPU> cpuStorageController =
        new StorageController<>(cpuStorageView, cpuStorage, cpuBuilder);
    StorageController<Body> bodyStorageController =
        new StorageController<>(bodyStorageView, bodyStorage, bodyBuilder);
    StorageController<Keyboard> keyboardStorageController =
        new StorageController<>(keyboardStorageView, keyboardStorage, keyboardBuilder);

    this.add(cpuStorageView);
    this.add(bodyStorageView);
    this.add(keyboardStorageView);
  }
}
