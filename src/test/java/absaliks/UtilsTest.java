package absaliks;

import static absaliks.Utils.groupElements;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void groupElements_primitiveElements() {
        int[] source = { 1, 2, 3, 4, 5, 6 };

        assertArrayEquals(
                new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } },
                (int[][]) groupElements(2, source));

        assertArrayEquals(
                new int[][] { { 1, 2, 3 }, { 4, 5, 6 } },
                (int[][]) groupElements(3, source));
    }

    @Test
    void groupElements_objectElements() {
        String[] source = { "a", "b", "c", "d", "e", "f" };

        assertArrayEquals(
                new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } },
                (String[][]) groupElements(2, source));

        assertArrayEquals(
                new String[][] { { "a", "b", "c" }, { "d", "e", "f" } },
                (String[][]) groupElements(3, source));
    }

    @Test
    void groupElements_canHandleEmpty() {
        int[] source = {};

        assertArrayEquals(new int[][] {}, (int[][]) groupElements(2, source));

        assertArrayEquals(new int[][] {}, (int[][]) groupElements(3, source));
    }
}