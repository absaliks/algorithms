package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedArrayTest {

  private final RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

  @Test
  void testSolution() {
    assertSolution(new int[]{1, 2}, new int[]{1,1,2});
    assertSolution(new int[]{0, 1, 2, 3, 4}, new int[]{0,0,1,1,1,2,2,3,3,4});
    assertSolution(new int[]{}, new int[]{});
    assertSolution(new int[]{8}, new int[]{8});
  }

  private void assertSolution(final int[] expectedResult, final int[] input) {
    assertEquals(expectedResult.length, solution.removeDuplicates(input),
        "Returned length does not match");
    assertArrayEquals(expectedResult, Arrays.copyOf(input, expectedResult.length));
  }
}