package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Single Number II - https://leetcode.com/problems/single-number-ii
// CPU 4ms | Beats 54.82%
// RAM 45.36MB | Beats 40.90%
public class SingleNumber2Test {

    public static int singleNumber(int... nums) {
        var map = new HashMap<Integer, Integer>(nums.length / 3 + 1);
        for (int num : nums) {
            var count = map.getOrDefault(num, 0);
            if (count == 3) {
                map.remove(num);
            } else {
                map.put(num, count + 1);
            }
        }
        return map.keySet().iterator().next();
    }

    public static Stream<Arguments> name() {
        return Stream.of(
                Arguments.of(new int[]{2,2,3,2}, 3),
                Arguments.of(new int[]{0,1,0,1,0,1,99}, 99));
    }

    @ParameterizedTest
    @MethodSource
    void name(int[] given, int expected) {
        assertEquals(expected, singleNumber(given));
    }
}
