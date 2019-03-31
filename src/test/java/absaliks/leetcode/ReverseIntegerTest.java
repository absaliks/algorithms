package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReverseIntegerTest {

  private ReverseInteger solution = new ReverseInteger();

  @Test
  void reverse123() {
    assertReversion(321, 123);
    assertReversion(-321, -123);
    assertReversion(21, 120);
    assertReversion(0, Integer.MAX_VALUE);
  }

  private void assertReversion(int expected, int input) {
    assertEquals(expected, solution.reverse(input));
  }
}