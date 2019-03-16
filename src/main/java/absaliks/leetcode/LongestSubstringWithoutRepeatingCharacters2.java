package absaliks.leetcode;

import java.util.HashMap;

/**
 * Runtime: 20 ms, faster than 89.10% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 39.9 MB, less than 15.02% of Java online submissions for Longest Substring Without Repeating Characters.
 */
public class LongestSubstringWithoutRepeatingCharacters2 implements LongestSubstringWithoutRepeatingCharacters {

  @Override
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int maxLength = 0, sequenceHead = 0;
    StringBuilder builder = new StringBuilder(s);
    final HashMap<Character, Integer> chars = new HashMap<>(builder.length() / 2 + 1);
    for (int i = 0; i < builder.length(); i++) {
      final Character c = builder.charAt(i);
      final Integer lastIndex = chars.put(c, i);
      if (lastIndex != null) {
        if (maxLength < chars.size()) {
          maxLength = chars.size();
        }
        if (builder.length() - lastIndex - 1 <= maxLength) {
          return maxLength;
        }
        for (int j = sequenceHead; j < lastIndex; j++) {
          chars.remove(builder.charAt(j));
        }
        sequenceHead = lastIndex + 1;
      }
    }
    return chars.size();
  }
}
