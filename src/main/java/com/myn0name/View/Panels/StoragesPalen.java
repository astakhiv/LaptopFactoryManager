package com.myn0name.View.Panels;

import com.myn0name.Controller.StorageControllers.StorageController;
import com.myn0name.Model.Factories.BodyFactory;
import com.myn0name.Model.Factories.CPUFactory;
import com.myn0name.Model.Factories.KeyboardFactory;
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
      CPUFactory cpuFactory,
      KeyboardFactory keyboardFactory,
      BodyFactory bodyFactory) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    StorageView cpuStorageView = new StorageView();
    StorageView bodyStorageView = new StorageView();
    StorageView keyboardStorageView = new StorageView();

    StorageController<CPU> cpuStorageController =
        new StorageController<>(cpuStorageView, cpuStorage, cpuFactory);
    StorageController<Body> bodyStorageController =
        new StorageController<>(bodyStorageView, bodyStorage, bodyFactory);
    StorageController<Keyboard> keyboardStorageController =
        new StorageController<>(keyboardStorageView, keyboardStorage, keyboardFactory);

    this.add(cpuStorageView);
    this.add(bodyStorageView);
    this.add(keyboardStorageView);
  }
}
