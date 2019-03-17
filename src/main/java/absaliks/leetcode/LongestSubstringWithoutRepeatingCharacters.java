package absaliks.leetcode;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * Runtime: 20 ms, faster than 88.93% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 39.6 MB, less than 17.71% of Java online submissions for Longest Substring Without Repeating Characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int maxLength = 0, sequenceHead = 0;
    final HashSet<Character> chars = new HashSet<>(s.length() * 3 / 4);
    for (int i = 0; i < s.length(); i++) {
      final char currentChar = s.charAt(i);
      if (!chars.add(currentChar)) {
        if (maxLength < chars.size()) {
          maxLength = chars.size();
        }
        if (s.length() - sequenceHead - 1 <= maxLength) {
          return maxLength;
        }
        char expiredChar;
        while ((expiredChar = s.charAt(sequenceHead++)) != currentChar) {
          chars.remove(expiredChar);
        }
      }
    }
    return Math.max(chars.size(), maxLength);
  }
}
