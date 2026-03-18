package com.myn0name.Model.Machines;

import com.myn0name.Exceptions.MachineFailureException;
import java.util.Random;

public class Line extends Machine {
  public Line(int durability, String factory) {
    super(durability, factory, "Line");
  }

  @Override
  public boolean needsMaintenance() {
    return this.durability <= 40;
  }

  @Override
  public void work() {
    if (this.needsMaintenance()) {
      this.setState("Failure");

      String errorMessage =
          String.format(
              "The %s with id %s on %d broke. Needs maintenance.\n",
              this.getType(), this.getFactory(), this.getId());
      throw new MachineFailureException(errorMessage);
    }

    Random random = new Random();
    this.setState("Working");
    this.durability -= random.nextInt(6);
  }
}
