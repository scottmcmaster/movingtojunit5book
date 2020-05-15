package com.smcmaster.calculator;

import java.io.File;
import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EnabledIfFileCondition implements ExecutionCondition {

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    AnnotatedElement element = context.getElement()
        .orElseThrow(IllegalStateException::new);
    EnabledIfFile annotation = element.getAnnotation(EnabledIfFile.class);
    if (annotation == null) {
      return ConditionEvaluationResult.enabled("EnabledIfFileCondition not found");
    }
    if (annotation.filename() == null) {
      return ConditionEvaluationResult.disabled("no file given");
    }
    File file = new File(annotation.filename());
    boolean enabled = file.exists();
    if (enabled) {
      return ConditionEvaluationResult.enabled("file exists");
    }
    return ConditionEvaluationResult.disabled("file does not exist");
  }
}
