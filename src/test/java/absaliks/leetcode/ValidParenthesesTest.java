package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

  private ValidParentheses solution = new ValidParentheses();

  @Test
  void testNullStringValid() {
    assertTrue(solution.isValid(null));
  }

  @Test
  void testEmptyStringValid() {
    assertTrue(solution.isValid(""));
  }

  @Test
  void test1() {
    assertTrue(solution.isValid("()"));
  }

  @Test
  void test2() {
    assertTrue(solution.isValid("()[]{}"));
  }

  @Test
  void test3() {
    assertFalse(solution.isValid("(]"));
  }

  @Test
  void test4() {
    assertFalse(solution.isValid("([)]"));
  }

  @Test
  void test5() {
    assertTrue(solution.isValid("{[]}"));
  }

  @Test
  void testOpenOnly() {
    assertFalse(solution.isValid("{[(("));
  }

  @Test
  void testComplex() {
    assertTrue(solution.isValid("{[(())()]}"));
  }

}