/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.fest.assertions.error;

import java.util.Set;

/**
 * Creates an error message indicating that an assertion that verifies a map contains some values failed. TODO : move to
 * fest-assert-core to replace {@link ShouldContainValue}
 * 
 * @author Joel Costigliola
 */
public class ShouldContainValues extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldContainValues}</code>.
   * 
   * @param actual the actual value in the failed assertion.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldContainValues(Object actual, Object[] values, Set<?> valuesNotFound) {
    return values.length == 1 ? new ShouldContainValues(actual, values[0]) : new ShouldContainValues(actual, values,
        valuesNotFound);
  }

  private ShouldContainValues(Object actual, Object value) {
    super("expecting:\n<%s>\n to contain value:\n<%s>", actual, value);
  }

  private ShouldContainValues(Object actual, Object[] values, Set<?> valuesNotFound) {
    super("expecting:\n<%s>\n to contain values:\n<%s>\n but could not find:\n<%s>", actual, values, valuesNotFound);
  }
}
