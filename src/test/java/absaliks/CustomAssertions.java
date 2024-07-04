package absaliks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class CustomAssertions {

    public static <T extends Comparable<T>, C extends Collection<T>, CC extends Collection<C>> void assertContainsInAnyOrder(
            CC expected, CC actual) {

        var sortedExpected = expected.stream()
                .map(Utils::sortedClone)
                .collect(Collectors.toSet());
        var sortedActual = actual.stream()
                .map(Utils::sortedClone)
                .collect(Collectors.toSet());

        if (expected.size() != actual.size()){
            fail("""
                    Size mismatch => expected = %d, actual = %d
                    ---
                    Expected: %s
                    Actual: %s
                    """.formatted(
                    expected.size(),
                    actual.size(),
                    sortedExpected,
                    sortedActual));
        }

        assertEquals(sortedExpected, sortedActual);

    }

    @Test
    void contains() {
        assertContainsInAnyOrder(
                List.of(List.of(5, 1, 9), List.of(3, 1, 2, 0)),
                List.of(List.of(1, 5, 9), List.of(0, 1, 2, 3)));
    }
}
