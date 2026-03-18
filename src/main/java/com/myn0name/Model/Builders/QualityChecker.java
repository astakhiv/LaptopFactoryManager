package com.myn0name.Model.Builders;

import com.myn0name.Model.Products.Laptop;

/** QualityChecker */
public interface QualityChecker {
  public String AssesQuality(Laptop laptop);

  public String getName();
}
