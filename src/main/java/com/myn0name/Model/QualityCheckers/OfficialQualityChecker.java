package com.myn0name.Model.QualityCheckers;

import com.myn0name.Model.Products.Laptop;

public class OfficialQualityChecker implements QualityChecker {
  private String name;

  public OfficialQualityChecker() {
    this.name = "OfficialQualityChecker";
  }

  public String AssesQuality(Laptop laptop) {
    if (laptop == null) {
      throw new NullPointerException("No Laptop was provided.");
    }

    float quality = laptop.getQuality();

    if (quality >= 0.9) {
      return "High";
    } else if (quality >= 0.7) {
      return "Medium";
    } else {
      return "Low";
    }
  }

  public String getName() {
    return this.name;
  }
}
