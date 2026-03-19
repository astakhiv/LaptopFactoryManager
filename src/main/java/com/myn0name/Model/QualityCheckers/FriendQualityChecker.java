package com.myn0name.Model.QualityCheckers;

import com.myn0name.Model.Products.Laptop;

/**
 * FriendQualityChecker
 */
public class FriendQualityChecker implements QualityChecker {
  private String name;

  public FriendQualityChecker() {
    this.name = "Friend's Quality Checker";
  }

  public String AssesQuality(Laptop laptop) {
    if (laptop == null) {
      throw new NullPointerException("No Laptop was provided.");
    }

    float quality = laptop.getQuality();

    if (quality >= 0.9) {
      return "WHERE DID U FIND THAT";
    } else if (quality >= 0.5) {
      return "Just... Perfect!..";
    } else {
      return "Well, I may run Minecraft on that... I guess...";
    }
  }

  public String getName() {
    return this.name;
  }
}
