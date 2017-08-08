package com.joyscrum.cache;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.mongodb.morphia.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jorge Mota
 * on 4/20/17.
 */
public class FindValue {
    /**
     * Acá se debería establecer a un handler hacia MemCache Jboss Cache
     */
static{
        CacheProvider.getCacheInstance();
    }
    //private static HashMap<String, Object> memCache = new HashMap<>(400);

    public static <T> T getSingle(Query<T> query, String identifier, boolean fromDB) {
        if (fromDB) {
            return query.get();
        } else {

            T result;
            HazelcastInstance cache = CacheProvider.getCacheInstance();
            String mapName = query.getEntityClass().getName();
            IMap<String, T> map = cache.getMap(mapName);
            result = map.get(identifier);

            if (result == null) {
                result = query.get();
                if (result!=null) {
                    map.put(identifier, result,4,TimeUnit.HOURS);
                }
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
           /* if (!memCache.containsKey(identifier)) {
                result = query.asList();
            } else {
                result = (List<T>) memCache.get(identifier);
            }
            if (result != null) {
                memCache.put(identifier, result);
            }*/

            HazelcastInstance cache = CacheProvider.getCacheInstance();
            String mapName = query.getEntityClass().getName();
            IMap<String, List<T>> map = cache.getMap(mapName);
            result = map.get(identifier);
            if (result == null) {
                result = query.asList();
                if (result!=null &&!result.isEmpty()) {
                    map.put(identifier, result,4, TimeUnit.HOURS);
                }
            }
            return result;
        }
    }

    public static <T> List<T> getList(Query<T> query, String identifier) {
        return getList(query, identifier, false);
    }

    public static void clearCache(String className){
        HazelcastInstance cache = CacheProvider.getCacheInstance();
        IMap<String, Object> map = cache.getMap(className);
        if (map!=null) {

            map.evictAll();
            map.clear();
        }

    }
}
