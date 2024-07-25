package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// https://leetcode.com/problems/integer-to-roman
// CPU 3ms | Beats 97.79%
// RAM 43.99MB | Beats 91.04%
public class IntegerToRomanTest {

    private static final char[][] charDictionary = { { 'I', 'V' }, { 'X', 'L' }, { 'C', 'D' }, { 'M' } };
    private static final int[][] numDictionary = { { 1, 5 }, { 10, 50 }, { 100, 500 }, { 1000 } };

    public String intToRoman(int num) {
        var builder = new StringBuilder();
        int reminder = num;
        if (num >= 1000) {
            builder.repeat("M", num / 1000);
            reminder = num % 1000;
        }
        while (reminder > 0) {
            var dictIndex = dictionaryIndex(reminder);
            var firstDigit = firstDigit(reminder);
            if (firstDigit == 9 || firstDigit == 4) {
                builder.append(charDictionary[dictIndex][0]);
                reminder += numDictionary[dictIndex][0];
                if (firstDigit == 9) {
                    builder.append(charDictionary[dictIndex + 1][0]);
                    reminder -= numDictionary[dictIndex + 1][0];
                } else {
                    builder.append(charDictionary[dictIndex][1]);
                    reminder -= numDictionary[dictIndex][1];
                }
            } else if (firstDigit < 4) {
                var times = firstDigit;
                builder.repeat(charDictionary[dictIndex][0], times);
                reminder -= times * numDictionary[dictIndex][0];
            } else {
                builder.append(charDictionary[dictIndex][1]);
                reminder -= numDictionary[dictIndex][1];
                if (firstDigit > 5) {
                    int times = firstDigit - 5;
                    builder.repeat(charDictionary[dictIndex][0], times);
                    reminder -= times * numDictionary[dictIndex][0];
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

        return 2;
    }

    private int firstDigit(int i) {
        while (i > 9)
            i /= 10;
        return i;
    }

    @Test
    void name() {
        assertEquals("V", intToRoman(5));
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
            3749, MMMDCCXLIX
              58, LVIII
            1994, MCMXCIV
            """)
    void compositeNumbers(int dec, String roman) {
        assertEquals(roman, intToRoman(dec));
    }
}
