package absaliks.leetcode;

import java.util.HashMap;

/**
 * Runtime: 177 ms, faster than 7.10% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 71.7 MB, less than 5.00% of Java online submissions for Longest Substring Without Repeating Characters.
 */
public class LongestSubstringWithoutRepeatingCharacters1 implements LongestSubstringWithoutRepeatingCharacters {

  @Override
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    return lengthOfLongestSubstring(new StringBuilder(s), 0);
  }

  private int lengthOfLongestSubstring(final StringBuilder builder, final int startPos) {
    final HashMap<Character, Integer> chars = new HashMap<>(builder.length() / 2 + 1);
    for (int i = startPos; i < builder.length(); i++) {
      final Character c = builder.charAt(i);
      final Integer lastIndex = chars.put(c, i);
      if (lastIndex != null) {
        return Math.max(chars.size(), lengthOfLongestSubstring(builder, lastIndex + 1));
      }
    }
    return chars.size();
  }
}
