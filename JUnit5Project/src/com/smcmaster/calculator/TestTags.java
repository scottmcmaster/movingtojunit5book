package com.smcmaster.calculator;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestTags {
  @Test
  @Tag("development")
  public void testDevelopment() {
    System.out.println("development environment");
  }

  @Test
  @Tag("staging")
  public void testStaging() {
    System.out.println("staging environment");
  }

  @Test
  @Tag("development")
  @Tag("staging")
  public void testAllEnvironments() {
    System.out.println("both environments");
  }
}
