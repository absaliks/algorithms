package absaliks.other;

import static absaliks.other.DataStructures.isPermutation;
import static absaliks.other.DataStructures.isUniqueCharSet;
import static absaliks.other.DataStructures.toURL;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DataStructuresTest {

  @Test
  void testIsUnique() {
    assertTrue(isUniqueCharSet("1489"));
    assertTrue(isUniqueCharSet("132"));
    assertFalse(isUniqueCharSet("122"));
    assertFalse(isUniqueCharSet("44"));
  }

  @Test
  void testIsPermutation() {
    assertTrue(isPermutation("ab", "ba"));
    assertTrue(isPermutation("abbde", "baedb"));
    assertFalse(isPermutation("e", "baedb"));
    assertFalse(isPermutation("a", "c"));
    assertFalse(isPermutation("zxcv", "czxb"));
  }

  @Test
  void testToURL() {
    assertToUrl("Hello%20World!", "Hello World!  ");
    assertToUrl("What%20is%20going%20on", "What is going on      ");
    assertToUrl("Nevermind", "Nevermind");
  }

  private void assertToUrl(final String expected, final String given) {
    final char[] givenArray = given.toCharArray();
    toURL(givenArray);
    assertArrayEquals(expected.toCharArray(), givenArray);
  }
}