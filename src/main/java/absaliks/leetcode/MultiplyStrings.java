package absaliks.leetcode;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    if (isEmptyOrZero(num1) || isEmptyOrZero(num2)) {
      return "0";
    }
    if (num1.length() < num2.length()) {
      final String temp = num2;
      num2 = num1;
      num1 = temp;
    }

    final byte[] result = new byte[num1.length() * num2.length() + 1];
    final byte[] preResult = new byte[num1.length() + 1];
    for (int i = num2.length() - 1; i >= 0; i--) {
      multiply(num1, getDigitAtIndex(num2, i), preResult);

      result[i] = preResult[preResult.length - 1];
      /*for (int j = 0; j < preResult.length && preResult[j]; j++) {

      }*/
    }
    return result.toString();
  }

  private void multiply(String num, byte multiplier, byte[] result) {
    int remainder = 0;
    for (int j = num.length() - 1; j >= 0; j++) {
      byte currentDigit = getDigitAtIndex(num, j);
      final int preResult = currentDigit * multiplier + remainder;

      if (preResult > 9) {
        remainder = preResult / 10;
        result[j] = (byte) (preResult - remainder * 10);
      } else
        result[j] = (byte) preResult;
    }
    if (remainder != 0) {
      result[0] = (byte) remainder;
    }
  }

  private byte getDigitAtIndex(String num1, int index) {
    return (byte) (num1.charAt(index) - 48);
  }

  private boolean isEmptyOrZero(String num) {
    return num == null || num.length() == 0 || num.equals("0");
  }
}
