package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Got tired")
class MultiplyStringsTest {

  private MultiplyStrings solution = new MultiplyStrings();

  @Test
  void mutiply_2times3_equals6() {
    assertMutiply(2, 3);
  }

  @Test
  void mutiply_0timesX_equals0() {
    assertMutiply(123, 0);
    assertMutiply(0, 123);
    assertMutiply(0, 0);
    assertMutiply(2, 0);
    assertMutiply(0, 4);
  }

  @Test
  void mutiply_123times456_equals56088() {
    assertMutiply(123, 456);
  }

  @Test
  void mutiply_99times99_equals9801() {
    assertMutiply(99, 99);
  }

  private void assertMutiply(int a, int b) {
    assertEquals(Integer.toString(a * b),
        solution.multiply(Integer.toString(a), Integer.toString(b)));
  }

  @Test
  void n() {
    final LocalDate begin = LocalDate.now().minusDays(3481);
    final LocalDate temple = LocalDate.of(2018, 6, 8);
    System.out.println(begin);
    System.out.println(java.time.Period.between(begin, temple));
  }
}