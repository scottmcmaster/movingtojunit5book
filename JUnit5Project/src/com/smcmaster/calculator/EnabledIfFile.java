package com.smcmaster.calculator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * A custom condition annotation to enable a test only when
 * a given file exists.
 */
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(EnabledIfFileCondition.class)
public @interface EnabledIfFile {
  String filename();
}
