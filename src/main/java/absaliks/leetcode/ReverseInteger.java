package absaliks.leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/submissions/
 * Runtime: 2 ms, faster than 95.91% of Java online submissions for Reverse Integer.
 * Memory Usage: 32.5 MB, less than 100.00% of Java online submissions for Reverse Integer.
 */
public class ReverseInteger {
  public int reverse(int x) {
    final String str = Integer.toString(x);
    final StringBuilder builder = new StringBuilder(str.length());
    if (str.charAt(0) == '-') {
      builder.append('-');
    }
    final int minDigitPosition = builder.length();
    for (int i = str.length() - 1; i >= minDigitPosition; i--) {
      builder.append(str.charAt(i));
    }
    long longResult = Long.parseLong(builder.toString());
    int intResult = (int) longResult;
    if (longResult != intResult) {
      return 0;
    }
    return intResult;
  }
}
