package absaliks.leetcode;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class LetterCombinationsOfPhoneNumberTest {

  private LetterCombinationsOfPhoneNumber solution =
      new LetterCombinationsOfPhoneNumber();

  @Test
  void letterCombinations_sizeOf1() {
    final List<String> result = solution.letterCombinations("7");
    final List<String> expectedList = asList("p", "q", "r", "s");
    assertEquals(expectedList, result);
  }

  @Test
  void letterCombinations_sizeOf2() {
    final List<String> result = solution.letterCombinations("23");
    final List<String> expectedList = asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    assertEquals(expectedList, result);
  }

  @Test
  void letterCombinations_sizeOf3() {
    final List<String> result = solution.letterCombinations("238");
    final List<String> expectedList = asList(
        "adt", "adu", "adv",
        "aet", "aeu", "aev",
        "aft", "afu", "afv",
        
        "bdt", "bdu", "bdv",
        "bet", "beu", "bev",
        "bft", "bfu", "bfv",
        
        "cdt", "cdu", "cdv",
        "cet", "ceu", "cev",
        "cft", "cfu", "cfv"
    );
    assertEquals(expectedList, result);
  }

  @Test
  void letterCombinations_nullString() {
    final List<String> result = solution.letterCombinations(null);
    assertEquals(emptySet(), new HashSet<>(result));
  }

  @Test
  void letterCombinations_emptyString() {
    final List<String> result = solution.letterCombinations("");
    assertEquals(emptySet(), new HashSet<>(result));
  }
}