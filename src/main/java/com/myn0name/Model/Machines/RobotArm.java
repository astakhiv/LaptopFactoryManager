package com.myn0name.Model.Machines;

import com.myn0name.Exceptions.MachineFailureException;
import java.util.Random;

public class RobotArm extends Machine {
  public RobotArm(int durability, String factory) {
    super(durability, factory, "Robot Arm");
  }

  @Override
  public boolean needsMaintenance() {
    return this.durability <= 50;
  }

  @Override
  public void work() {
    Random random = new Random();

    if (this.needsMaintenance()) {
      this.setState("Failure");

      String errorMessage =
          String.format(
              "The %s with id %s on %d broke. Needs maintenance.\n",
              this.getType(), this.getFactory(), this.getId());

      throw new MachineFailureException(errorMessage);
    }

    this.setState("Working");
    this.durability -= random.nextInt(11);
  }
}
