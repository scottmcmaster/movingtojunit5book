package com.smcmaster.calculator;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestCategories {
  @Test
  @Category(DevelopmentEnv.class)
  public void testDevelopment() {
    System.out.println("development environment");
  }

  @Test
  @Category(StagingEnv.class)
  public void testStaging() {
    System.out.println("staging environment");
  }

  @Test
  @Category({DevelopmentEnv.class, StagingEnv.class})
  public void testAllEnvironments() {
    System.out.println("both environments");
  }
}
