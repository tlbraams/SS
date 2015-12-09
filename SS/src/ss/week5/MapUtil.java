package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MapUtil {
	
	/*@
	  ensures \result == (\forall K k, l; map.keySet().contains(k) && map.keySet().contains(l)
	  				&& k != l;	!map.get(k).equals(map.get(l)));
	 */
    /*@ pure */public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	Boolean result = true;
    	Object[] keys = map.keySet().toArray();
    	for (int i = 0; i < keys.length && result; i++) {
    		for (int j = i + 1; j < keys.length && result; j++) {
    			result = !map.get(keys[i]).equals(map.get(keys[j]));
    		}
    	}
        return result;
    }
    
    /*@
     	ensures \result == (\forall V v; range.contains(v);
     	 						\exists K k; map.keySet().contains(k); map.get(k).equals(v));
     */
    /*@ pure */public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        Boolean result = true;
        for (V v: range) {
        	Boolean contains = false;
        	for (K k: map.keySet()) {
        		if (map.get(k).equals(v)) {
        			contains = true;
        		}
        	}
        	result = result && contains;
        }
        return result;
    }
    
    /*@
     	ensures \forall K k; map.keySet().contains(k); \result.get(map.get(k)).contains(k);
     */
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
    	Map<V, Set<K>> result = new HashMap<V, Set<K>>();
    	for (V v: map.values()) {
    		Set<K> set = new HashSet<K>();
    		for (K k: map.keySet()) {
    			if (map.get(k).equals(v)) {
    				set.add(k);
    			}
    		}
    		result.put(v, set);
    	}
    	return result;
	}
    
    /*@
     	ensures isOneOnOne(map) && isSurjectiveOnRange(map, new HashSet<V>(map.values()))
     	 		==> (\forall K k; map.keySet().contains(k);	\result.get(map.get(k)).equals(k));
     */
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> result = null;
		if (isOneOnOne(map) && isSurjectiveOnRange(map, new HashSet<V>(map.values()))) {
			result = new HashMap<V, K>();
			for (K k: map.keySet()) {
				result.put(map.get(k), k);
			}
		}
        return result;
	}
	
	/*@
	 	ensures \result == (\forall V v; f.values().contains(v); g.keySet().contains(v));
	 */
	/*@ pure */public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        Boolean result = true;
        for (V v: f.values()) {
        	result = result && g.keySet().contains(v);
        }
        return result;
	}
	
	/*@
	 	ensures compatible(f, g) ==> (\forall K k; f.keySet().contains(k); 
	 										\result.get(k).equals(g.get(f.get(k))));
	 */
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> result = null;
        if (compatible(f, g)) {
        	result = new HashMap<K, W>();
        	for (K k: f.keySet()) {
        		result.put(k, g.get(f.get(k)));
        	}
        }
		return result;
	}
}
