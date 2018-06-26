/*
 * Copyright (C) 2018  Shamil Absalikov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import absaliks.leetcode.romantoint.RomanToInteger;
import absaliks.leetcode.romantoint.RomanToIntegerHashMap;
import absaliks.leetcode.romantoint.RomanToIntegerSwitch;

class RomanToIntegerTest {

  private RomanToInteger converter = new RomanToIntegerHashMap();

  @Test
  void testSingleDigitValue() {
    String[] romanDigits = {"I", "V", "X", "L", "C", "D", "M"};
    int[] expectedValues = new int[]{1, 5, 10, 50, 100, 500, 1000};
    for (int i = 0; i < romanDigits.length; i++)
      assertRomanToInt(expectedValues[i], romanDigits[i]);
  }

  @Test
  void testII_equals_2() {
    assertRomanToInt(2, "II");
  }

  @Test
  void testIII() {
    assertRomanToInt(3, "III");
  }

  @Test
  void testXV_equals_15() {
    assertRomanToInt(15, "XV");
  }

  @Test
  void testIX_equals_9() {
    assertRomanToInt(9, "IX");
  }

  @Test
  void testIV() {
    assertRomanToInt(4, "IV");
  }

  @Test
  void testLVIII() {
    assertRomanToInt(58, "LVIII");
  }

  @Test
  void testMCMXCIV() {
    assertRomanToInt(1994, "MCMXCIV");
  }

  @Test
  void loadTest() {
    IntStream.of(100000).forEach((i) -> {
      assertRomanToInt(4, "IV");
      assertRomanToInt(58, "LVIII");
      assertRomanToInt(1994, "MCMXCIV");
      assertRomanToInt(2603, "MCMXCIVXVIDMXCIVIIIVV");
    });
  }

  private void assertRomanToInt(int expectedOutput, String input) {
    int actualValue = converter.convert(input);
    assertEquals(expectedOutput, actualValue,
        "Expected Value of " + input + " to be " + expectedOutput + ", but was " + actualValue);
  }
}