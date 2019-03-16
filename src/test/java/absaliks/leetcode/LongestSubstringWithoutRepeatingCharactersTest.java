package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

  LongestSubstringWithoutRepeatingCharacters solution =
      new LongestSubstringWithoutRepeatingCharacters2();

  @Test
  void abcabcbb() {
    assertResult(3, "abcabcbb");
  }

  @Test
  void bbbbb() {
    assertResult(1, "bbbbb");
  }

  @Test
  void pwwkew() {
    assertResult(3, "pwwkew");
  }

  @Test
  void dvdf() {
    assertResult(3, "dvdf");
  }

  @Test
  void kdgjkjhglfp() {
    assertResult(7, "kdgjkjhglfp");
  }

  private void assertResult(int expectedResult, String string) {
    assertEquals(expectedResult, solution.lengthOfLongestSubstring(string));
  }
}
