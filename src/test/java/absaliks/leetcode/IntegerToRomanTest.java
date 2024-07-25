package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// https://leetcode.com/problems/integer-to-roman
// CPU 3ms | Beats 97.79%
// RAM 44.34MB | Beats 51.74%
public class IntegerToRomanTest {

    private static final char[][] charDictionary = { { 'I', 'V' }, { 'X', 'L' }, { 'C', 'D' }, { 'M' } };
    private static final int[][] numDictionary = { { 1, 5 }, { 10, 50 }, { 100, 500 }, { 1000 } };

    public String intToRoman(int num) {
        var builder = new StringBuilder();
        while (num > 0) {
            var dictIndex = dictionaryIndex(num);
            var firstDigit = firstDigit(num);
            if (firstDigit == 9 || firstDigit == 4) {
                builder.append(charDictionary[dictIndex][0]);
                num += numDictionary[dictIndex][0];
            } else if (firstDigit < 4) {
                builder.repeat(charDictionary[dictIndex][0], firstDigit);
                num -= firstDigit * numDictionary[dictIndex][0];
            } else {
                builder.append(charDictionary[dictIndex][1]);
                num -= numDictionary[dictIndex][1];
                if (firstDigit > 5) {
                    int times = firstDigit - 5;
                    builder.repeat(charDictionary[dictIndex][0], times);
                    num -= times * numDictionary[dictIndex][0];
                }
            }
        }
        return builder.toString();
    }

    private int dictionaryIndex(int number) {
        if (number < 10)
            return 0;

        if (number < 100)
            return 1;

        if (number < 1000)
            return 2;

        return 3;
    }

    private int firstDigit(int i) {
        while (i > 9)
            i /= 10;
        return i;
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
               1, I
               5, V
              10, X
              50, L
             100, C
             500, D
            1000, M
            """)
    void romanDigits(int dec, String roman) {
        assertEquals(roman, intToRoman(dec));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
               9, IX
              99, XCIX
             900, CM
             999, CMXCIX
            """)
    void nines(int dec, String roman) {
        assertEquals(roman, intToRoman(dec));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            3749, MMMDCCXLIX
              58, LVIII
            1994, MCMXCIV
            """)
    void compositeNumbers(int dec, String roman) {
        assertEquals(roman, intToRoman(dec));
    }
}
