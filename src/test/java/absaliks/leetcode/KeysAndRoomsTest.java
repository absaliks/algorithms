package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://leetcode.com/problems/keys-and-rooms
// 35m
// CPU | 1ms     | Beats 77.83%
// RAM | 44.54MB | Beats 10.92%
public class KeysAndRoomsTest {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return new RoomVisitor(rooms).canVisitAllRooms();
    }

    static class RoomVisitor {
        private final BitSet visitedRooms;
        private final List<List<Integer>> rooms;

        public RoomVisitor(List<List<Integer>> rooms) {
            this.rooms = rooms;
            this.visitedRooms = new BitSet(rooms.size());
        }

        public boolean canVisitAllRooms() {
            visitRoom(0);
            return isVisitedAllRooms();
        }

        private boolean isVisitedAllRooms() {
            for (int i = 0; i < rooms.size(); i++) {
                if (!visitedRooms.get(i)) {
                    return false;
                }
            }
            return true;
        }

        private void visitRoom(int room) {
            visitedRooms.set(room, true);
            List<Integer> keys = rooms.get(room);
            for (Integer roomKey : keys) {
                if (!visitedRooms.get(roomKey)) {
                    visitRoom(roomKey);
                }
            }
        }
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(true, List.of(List.of(1), List.of(2), List.of(3), List.of())),
                Arguments.of(false, List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of())),
                Arguments.of(false, List.of(List.of(1), List.of(2), List.of(), List.of(3)))
        );
    }

    @ParameterizedTest
    @MethodSource
    void test(boolean expected, List<List<Integer>> rooms) {
        assertEquals(expected, canVisitAllRooms(rooms));
    }
}
