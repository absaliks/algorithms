package absaliks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Utils {
    public static <T extends Comparable<T>> ArrayList<T> sortedClone(Collection<T> src) {
        var clone = new ArrayList<T>(src);
        Collections.sort(clone);
        return clone;
    }

    @SuppressWarnings("SuspiciousSystemArraycopy")
    public static Object groupElements(int groupSize, Object array) {
        int srcLength = Array.getLength(array);
        if (srcLength % groupSize != 0) {
            throw new IllegalArgumentException("Number of elements must be a multiple of groupSize");
        }

        var elementType = array.getClass().getComponentType();
        int groupsCount = srcLength / groupSize;
        var dest = Array.newInstance(elementType, groupsCount, groupSize);

        for (int i = 0; i < groupsCount; i++) {
            var destGroup = Array.get(dest, i);
            System.arraycopy(array, i * groupSize, destGroup, 0, groupSize);
            Array.set(dest, i, destGroup);
        }
        return dest;
    }
}
