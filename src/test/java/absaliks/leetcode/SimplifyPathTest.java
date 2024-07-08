package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://leetcode.com/problems/simplify-path
public class SimplifyPathTest {

    public String simplifyPath(String path) {
        String[] segments = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 1; i < segments.length; i++) {
            String segment = segments[i];
            switch (segment) {
                case ".." -> {
                    if (!stack.isEmpty())
                        stack.pop();
                }
                case "", "." -> {}
                default -> stack.push(segment);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        for (String segment : stack) {
            builder.append('/').append(segment);
        }
        return builder.toString();
    }

    public static Stream<Arguments> _default() {
        return Stream.of(
                Arguments.of("/home/", "/home"),
                Arguments.of("/home//foo/", "/home/foo"),
                Arguments.of("/home/user/Documents/../Pictures", "/home/user/Pictures"),
                Arguments.of("/../", "/"),
                Arguments.of("/.../a/../b/c/../d/./", "/.../b/d"));
    }

    @ParameterizedTest
    @MethodSource
    void _default(String given, String expected) {
        assertEquals(
                expected,
                simplifyPath(given));
    }
}
