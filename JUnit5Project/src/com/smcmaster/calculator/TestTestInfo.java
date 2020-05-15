package com.smcmaster.calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import java.util.logging.Logger;

class TestTestInfo {

  private static final Logger logger = Logger.getLogger("TestTestInfo");
  
  @BeforeAll
  static void classSetUp(TestInfo testInfo) {
    logger.info("Before class " + testInfo.getDisplayName());
  }
  
  @BeforeEach
  void setUp(TestInfo testInfo) {
    logger.info("Before " + testInfo.getDisplayName());    
  }
  
  @Test
  void testSomething(TestInfo testInfo) {
    logger.info("Running " + testInfo.getDisplayName());
  }

  @Test
  @DisplayName("Something Else Test")
  void testSomethingElse(TestInfo testInfo) {
    logger.info("Running " + testInfo.getDisplayName());
  }

  @AfterAll
  static void classTearDown(TestInfo testInfo) {
    logger.info("After class " + testInfo.getDisplayName());
  }
  
  @AfterEach
  void tearDown(TestInfo testInfo) {
    logger.info("After " + testInfo.getDisplayName());    
  } 
}
