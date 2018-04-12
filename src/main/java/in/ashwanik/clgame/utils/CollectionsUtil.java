package in.ashwanik.clgame.utils;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by jh80 on 12/04/18.
 */
public class CollectionsUtil {

    public static <T> boolean isEmpty(Collection<T> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }
}
