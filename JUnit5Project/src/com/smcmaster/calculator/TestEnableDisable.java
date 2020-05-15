package com.smcmaster.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class TestEnableDisable {
  @EnabledOnOs(OS.WINDOWS)
  @Test
  void testOnWindows() {
    System.out.println("Hello on Windows");
  }
  
  @EnabledOnOs(OS.MAC)
  @Test
  void testOnMac() {
    System.out.println("Hello on Mac");
  }
  
  @DisabledOnOs(OS.LINUX)
  @Test
  void testNotOnLinux() {
    System.out.println("Hello on Mac or Windows not Linux");    
  }
  
  @EnabledIfFile(filename = "data.csv")
  @Test
  void testFileCondition() {
    System.out.println("Running test because file exists");
  }
}
