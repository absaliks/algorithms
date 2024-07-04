package absaliks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Utils {
    public static <T extends Comparable<T>> ArrayList<T> sortedClone(Collection<T> src) {
        var clone = new ArrayList<T>(src);
        Collections.sort(clone);
        return clone;
    }
}
