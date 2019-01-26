package absaliks.leetcode;

//Runtime: 4 ms, faster than 98.39% of Java online submissions for Valid Parentheses.
public class ValidParentheses {
  public boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    if (s.length() % 2 == 1) {
      return false;
    }

    final int initialLength = Math.min(s.length(), s.length() / 2 + 3);
    final StringBuilder closeQueue = new StringBuilder(initialLength);
    int queueSize = 0;
    for (int i = 0; i < s.length(); i++) {
      final char currentChar = s.charAt(i);
      final char closeParenthesis = getClosingParenthesis(currentChar);
      if (closeParenthesis != Character.UNASSIGNED) {
        queueSize++;
        closeQueue.append(closeParenthesis);
      } else if (queueSize == 0) {
        return false;
      } else if (currentChar == closeQueue.charAt(--queueSize)) {
        closeQueue.deleteCharAt(queueSize);
      } else {
        return false;
      }
    }

    return queueSize == 0;
  }

  private char getClosingParenthesis(char charAt) {
    switch (charAt) {
      case '(': return ')';
      case '{': return '}';
      case '[': return ']';
    }
    return Character.UNASSIGNED;
  }
}
