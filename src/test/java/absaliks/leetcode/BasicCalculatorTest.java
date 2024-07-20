package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://leetcode.com/problems/basic-calculator
// CPU 8ms | Beats 74.15%
// RAM 43.30MB | Beats 87.71%
public class BasicCalculatorTest {

    public int calculate(String s) {
        int result = 0;
        byte sign = 1;
        byte signMod = 1;
        int value = 0;
        var stack = new Stack<Byte>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == ' ')
                continue;

            if (Character.isDigit(chr)) {
                value = value * 10 + chr - '0';
                continue;
            }

            if (value > 0) {
                result += sign * value;
                value = 0;
                sign = signMod;
            }

            if (chr == '+') {
                sign = signMod;
            } else if (chr == '-') {
                sign = (byte) -signMod;
            } else if (chr == '(' && (sign == -1 || !stack.isEmpty())) {
                stack.add(signMod);
                signMod = sign;
            } else if (chr == ')' && !stack.isEmpty()) {
                signMod = stack.pop();
            }
        }
        result += sign * value;
        return result;
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of("10+1", 11),
                Arguments.of("1 + 1", 2),
                Arguments.of("2-1 + 2", 3),
                Arguments.of("(1+(4+5+2)-3)+(6+8)", 23),
                Arguments.of("-(2+1)", -3),
                Arguments.of("-(-(2+1))", 3),
                Arguments.of("(7)-(0)+(4)", 11));
    }

    @ParameterizedTest
    @MethodSource
    void test(String given, int expected) {
        assertEquals(expected, calculate(given));
    }
}
