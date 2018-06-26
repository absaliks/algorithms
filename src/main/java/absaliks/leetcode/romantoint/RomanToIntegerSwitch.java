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

package absaliks.leetcode.romantoint;

public class RomanToIntegerSwitch implements RomanToInteger { // 33.16% - 137 ms

  @Override
  public int convert(String s) {
    int sum = 0, previousValue = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      int value;
      switch (s.charAt(i)) {
        case 'I': value = 1; break;
        case 'V': value = 5; break;
        case 'X': value = 10; break;
        case 'L': value = 50; break;
        case 'C': value = 100; break;
        case 'D': value = 500; break;
        case 'M': value = 1000; break;
        default:
          throw new IllegalArgumentException();
      }
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
