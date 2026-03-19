package com.myn0name.View.Panels;

import com.myn0name.View.StorageView;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/** StoragesPalen */
public class StoragesPalen extends JPanel {
  public StoragesPalen(List<StorageView> storageViews){
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    for (int i = 0; i < storageViews.size(); i++) {
      this.add(storageViews.get(i));
    }
  }
}
