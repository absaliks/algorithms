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

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  private static final Map<Character, Integer> ROMANIAN_DIGITS;
  static {
    ROMANIAN_DIGITS = new HashMap<>(7);
    ROMANIAN_DIGITS.put('I', 1);
    ROMANIAN_DIGITS.put('V', 5);
    ROMANIAN_DIGITS.put('X', 10);
    ROMANIAN_DIGITS.put('L', 50);
    ROMANIAN_DIGITS.put('C', 100);
    ROMANIAN_DIGITS.put('D', 500);
    ROMANIAN_DIGITS.put('M', 1000);
  }

  public static int convert(String s) {
    int sum = 0, previousValue = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      int value = ROMANIAN_DIGITS.get(s.charAt(i));
      if (previousValue <= value) {
        sum += value;
      } else {
        sum -= value;
      }
      previousValue = value;
    }
    return sum;
  }
}
