/*********************************************************************
 * Copyright 2005-2020 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.test.constraints;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import net.sf.oval.constraint.NotBlankCheck;

/**
 * @author Sebastian Thomschke
 */
public class NotBlankTest extends AbstractContraintsTest {

   @Test
   public void testNotBlank() {
      final NotBlankCheck check = new NotBlankCheck();
      super.testCheck(check);
      assertThat(check.isSatisfied(null, null, null)).isTrue();

      assertThat(check.isSatisfied(null, "bla", null)).isTrue();
      assertThat(check.isSatisfied(null, true, null)).isTrue();
      assertThat(check.isSatisfied(null, 1, null)).isTrue();
      assertThat(check.isSatisfied(null, "", null)).isFalse();
      assertThat(check.isSatisfied(null, ' ', null)).isFalse();
      assertThat(check.isSatisfied(null, " ", null)).isFalse();
      assertThat(check.isSatisfied(null, "                  ", null)).isFalse();
   }
}
