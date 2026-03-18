package com.myn0name.View;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** LaptopFactoryView */
public class LaptopFactoryView extends JPanel {
  private JLabel name;
  private JLabel message;
  private JButton produce;

  public LaptopFactoryView() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    this.name = new JLabel();
    this.message = new JLabel();
    this.produce = new JButton("Produce");

    this.add(name);
    this.add(message);
    this.add(produce);
  }

  public void setName(String name) {
    this.name.setText(name);
  }

  public void setMessage(String message) {
    this.message.setText(message);
  }

  public void setProduceActionListener(ActionListener actionListener) {
    this.produce.addActionListener(actionListener);
  }
}
