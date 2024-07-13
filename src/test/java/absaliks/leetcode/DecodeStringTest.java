package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://leetcode.com/problems/decode-string
public class DecodeStringTest {

    public String decodeString(String s) {
        return new Decoder(s).decode();
    }

    static class Decoder {
        private final String source;
        private final StringBuilder builder;
        private int readCursor = 0;

        public Decoder(String source) {
            this.source = source;
            this.builder = new StringBuilder((int) (source.length() * 1.5));
        }

        public String decode() {
            while (readCursor < source.length()) {
                char c = source.charAt(readCursor);
                if (Character.isDigit(c)) {
                    expand();
                } else {
                    builder.append(c);
                }
                readCursor++;
            }
            return builder.toString();
        }

        private void expand() {
            int multiplier = 0;
            final int writeCursorStartIndex = builder.length();
            char chr;

            while ((chr = source.charAt(readCursor++)) != '[')
                multiplier = multiplier * 10 + chr - '0';

            while ((chr = source.charAt(readCursor)) != ']') {
                if (Character.isDigit(chr))
                    expand();
                else
                    builder.append(chr);
                readCursor++;
            }
            repeat(writeCursorStartIndex, builder.length(), multiplier - 1);
        }

        private void repeat(int startIndex, int endIndex, int times) {
            for (int i = 0; i < times; i++)
                for (int j = startIndex; j < endIndex; j++)
                    builder.append(builder.charAt(j));
        }
    }

    public static Stream<Arguments> _default() {
        return Stream.of(
                Arguments.of("3[x]", "xxx"),
                Arguments.of("3[a]2[bc]", "aaabcbc"),
                Arguments.of("3[a2[c]]", "accaccacc"),
                Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef"));
    }

    @ParameterizedTest
    @MethodSource
    void _default(String given, String expected) {
        assertEquals(expected, decodeString(given));
    }
}
