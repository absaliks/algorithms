package absaliks.leetcode;

import static absaliks.CustomAssertions.assertContainsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/group-anagrams
public class GroupAnagramsTest {

    public List<List<String>> groupAnagrams(String... strs) {
        HashMap<HashKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            HashKey key = new HashKey(str);
            List<String> group = map.get(key);
            if (group == null) {
                group = new ArrayList<>(Math.min(16, strs.length));
                map.put(key, group);
            }
            group.add(str);
        }
        return List.copyOf(map.values());
    }

    private final class HashKey {
        private final char[] chars;

        public HashKey(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            this.chars = chars;
        }

        @Override
        public boolean equals(Object object) {
            return Arrays.equals(chars, ((HashKey) object).chars);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(chars);
        }
    }

    @Test
    void case1() {
        assertContainsInAnyOrder(
                List.of(
                        List.of("bat"),
                        List.of("nat","tan"),
                        List.of("ate","eat","tea")),
                groupAnagrams("eat","tea","tan","ate","nat","bat"));
    }

    @Test
    void case2() {
        assertEquals(
                List.of(List.of("")),
                groupAnagrams(""));
    }

    @Test
    void case3() {
        assertEquals(
            List.of(List.of("a")),
            groupAnagrams("a"));
    }
}
