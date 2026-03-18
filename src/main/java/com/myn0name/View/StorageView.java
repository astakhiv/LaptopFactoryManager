package com.myn0name.View;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** StorageView */
public class StorageView extends JPanel {
  private JLabel name;
  private JButton refillButton;
  private JLabel numberOfProducts;

  public StorageView() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.name = new JLabel();
    this.refillButton = new JButton("Refill");
    this.numberOfProducts = new JLabel();

    this.add(name);
    this.add(refillButton);
    this.add(numberOfProducts);
  }

  public void setName(String name) {
    this.name.setText(name);
  }

  public void setNumberOfProducts(String numberOfProducts) {
    this.numberOfProducts.setText(numberOfProducts);
  }

  public void setRefillButtonActionListener(ActionListener actionListener) {
    this.refillButton.addActionListener(actionListener);
  }
}
