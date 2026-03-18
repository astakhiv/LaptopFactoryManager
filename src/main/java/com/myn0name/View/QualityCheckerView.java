package com.myn0name.View;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * QualityCheckerView
 */
public class QualityCheckerView extends JPanel {
  private JLabel name;
  private JLabel message;
  private JButton check;


  public QualityCheckerView() {
    this.name = new JLabel();
    this.message = new JLabel();
    this.check = new JButton("Check");

    this.add(name);
    this.add(message);
    this.add(check);
  }

  public void setName(String name) {
    this.name.setText(name);
  }

  public void setMessage(String message) {
    this.message.setText(message);
  }

  public void setCheckActionListener(ActionListener actionListener) {
    this.check.addActionListener(actionListener);
  }
}
