package org.testngmetadatalibs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.testngmetadatalibs.enums.TestSeverity;

/**
 * Annotation used to define the severity level of a test method.
 *
 * <p>The severity value must be selected from the {@link TestSeverity} enum.
 * Users can only use the predefined values:
 * <ul>
 *   <li>{@code HIGH}</li>
 *   <li>{@code MEDIUM}</li>
 *   <li>{@code LOW}</li>
 * </ul>
 *
 * <p>This restriction ensures type safety and prevents invalid severity values
 * during compilation. The annotation is retained at runtime so it can be
 * accessed via reflection for reporting, filtering, or prioritization logic.
 *
 * <p>Example usage:
 * <pre>
 * {@code
 * @Severity(severity = TestSeverity.HIGH)
 * public void testLogin() {
 *     // test logic
 * }
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Severity {

  /**
   * Defines the severity level of the test.
   *
   * @return severity level restricted to {@link TestSeverity#HIGH},
   * {@link TestSeverity#MEDIUM}, or {@link TestSeverity#LOW}.
   */
  TestSeverity severity();
}
