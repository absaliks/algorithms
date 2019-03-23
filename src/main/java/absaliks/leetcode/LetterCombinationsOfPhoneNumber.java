package absaliks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
 * Memory Usage: 37.4 MB, less than 9.79% of Java online submissions for Letter Combinations of a Phone Number.
 */
public class LetterCombinationsOfPhoneNumber {

  private static final char[][] MAPPING = {
      null, null,
      {'a', 'b', 'c'},
      {'d', 'e', 'f'},
      {'g', 'h', 'i'},
      {'j', 'k', 'l'},
      {'m', 'n', 'o'},
      {'p', 'q', 'r', 's'},
      {'t', 'u', 'v'},
      {'w', 'x', 'y', 'z'}
  };

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return Collections.emptyList();
    }

    // Convert digits string to int[] and calculate total combinations for result list initial size
    int totalCombinations = 1;
    final int[] input = new int[digits.length()];
    for (int i = 0; i < digits.length(); i++) {
      final int digit = digits.charAt(i) - 48;
      input[i] = digit;
      totalCombinations *= digit;
    }

    final List<String> combinations = new ArrayList<>(totalCombinations);
    final byte[] positions = new byte[digits.length()];
    final char[] combination = new char[digits.length()];
    final int maxCursorPosition = digits.length() - 1;

    char[] mapping = null;
    int cursor = -1, position = 0;

    // Init first chars
    while (cursor < digits.length() - 1) {
      cursor++;
      mapping = MAPPING[input[cursor]];
      combination[cursor] = mapping[0];
    }

    while (true) {
      combinations.add(new String(combination));

      if (mapping.length - 1 > position) {
        position = ++positions[cursor];
        combination[cursor] = mapping[position];
      } else {
        do {
          cursor--;
          if (cursor == -1) return combinations;
          mapping = MAPPING[input[cursor]];
        } while (mapping.length - 1 == positions[cursor]);
        combination[cursor] = mapping[++positions[cursor]];
      }
      while (cursor < maxCursorPosition) {
        cursor++;
        position = positions[cursor] = 0;
        mapping = MAPPING[input[cursor]];
        combination[cursor] = mapping[0];
      }
    }
  }
}
