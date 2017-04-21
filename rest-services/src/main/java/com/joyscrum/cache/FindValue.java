package com.joyscrum.cache;

import org.mongodb.morphia.query.Query;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Jorge Mota
 * on 4/20/17.
 */
public class FindValue {
    private static HashMap<String, Object> memCache = new HashMap<>(400);

    public static <T> T getSingle(Query<T> query, String identifier, boolean fromDB) {
        if (fromDB) {
            return query.get();
        } else {
            T result = null;
            if (!memCache.containsKey(identifier)) {
                result = query.get();
            }else{
                result=(T)memCache.get(identifier);
            }
            if (result != null) {
                memCache.put(identifier, result);
            }
            return result;
        }
    }

    public static <T> T getSingle(Query<T> query, String identifier) {
        return getSingle(query, identifier, false);
    }

    public static <T> List<T> getList(Query<T> query, String identifier, boolean fromDB) {
        if (fromDB) {
            return query.asList();
        } else {
            List<T> result = null;
            if (!memCache.containsKey(identifier)) {
                result = query.asList();
            }
            if (result != null) {
                memCache.put(identifier, result);
            }
            return result;
        }
    }

    public static <T> List<T> getList(Query<T> query, String identifier) {
        return getList(query, identifier, false);
    }
}
