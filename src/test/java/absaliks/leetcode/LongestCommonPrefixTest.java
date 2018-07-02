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

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LongestCommonPrefixTest {

  @Test
  void twoCharacterPrefix() {
    assertEquals("fl", longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
  }

  @Test
  void shortWordBranch() {
    assertEquals("abc", longestCommonPrefix(new String[] {"abcdef", "abc", "abcdz"}));
  }

  @Test
  void emptyStringBranch() {
    assertEquals("", longestCommonPrefix(new String[] {"abab", "aba", ""}));
  }

  @Test
  void noCommonPrefix() {
    assertEquals("", longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
  }

  @Test
  void wtf() {
    assertEquals("a", longestCommonPrefix(new String[] {"aac", "acab", "aa", "abba", "aa"}));
  }

  @Test
  void emptyArrayBranch() {
    assertEquals("", longestCommonPrefix(new String[] {}));
  }

  // 118 tc = 15 ms, 18.29%
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }

    int maxCommonCID = -1;
    int depth = strs[0].length() - 1;
    char[] chars = strs[0].toCharArray();
    System.out.println(strs[0]);
    for (int sid = 1; sid < strs.length; sid++) {
      String str = strs[sid];
      if (str.length() == 0) {
        return "";
      }
      if (depth > str.length() - 1) {
        depth = str.length() - 1;
      }
      for (int cid = 0; cid <= depth; cid++) {
        if (chars[cid] == str.charAt(cid)) {
          maxCommonCID = cid;
        } else {
          if (maxCommonCID > -1 && maxCommonCID < depth) {
            depth = maxCommonCID;
          }
          if (cid == 0) {
            return "";
          }
          break;
        }
      }
    }
    return new String(Arrays.copyOf(chars, maxCommonCID + 1));
  }
}
