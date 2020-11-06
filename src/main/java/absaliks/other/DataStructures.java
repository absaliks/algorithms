package absaliks.other;

class DataStructures {

  // Can't use additional data structures
  static boolean isUniqueCharSet(String text) {
    for (int i = 0; i < text.length(); i++) {
      char charI = text.charAt(i);
      for (int j = i + 1; j < text.length(); j++) {
        if (charI == text.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }

  static boolean isPermutation(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    if (str1.equals(str2)) {
      return true;
    }
    final StringBuilder builder = new StringBuilder(str1);
    for (int cursor = builder.length() - 1; cursor >= 0; cursor--) {
      char charAtCursor = builder.charAt(cursor);
      if (str2.indexOf(charAtCursor) != -1) {
        builder.deleteCharAt(cursor);
      }
    }
    return builder.length() == 0;
  }

  /**
   * Replaces non-trailing spaces with "%20" in the char array in place.
   * Given char array has right amount of extra space.
   */
  static void toURL(final char[] chars) {
    int readCursor = chars.length - 1;
    int writeCursor = readCursor;
    while (readCursor >= 0 && chars[readCursor] == ' ') {
      readCursor--;
    }
    for (; readCursor >= 0; readCursor--) {
      char rc = chars[readCursor];
      if (rc == ' ') {
        chars[writeCursor--] = '0';
        chars[writeCursor--] = '2';
        chars[writeCursor--] = '%';
      } else {
        chars[writeCursor--] = rc;
      }
    }
  }
}
