package toobject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSort implements Comparator<Long> {
		    Map<Long, Double> base;
		    public MapSort(Map<Long, Double> base) {
		        this.base = base;
		    }
		    
		    @Override
		    public int compare(Long a, Long b) {
		        if (base.get(a).doubleValue() >= base.get(b).doubleValue()) {
		            return -1;
		        } else {
		            return 1;
		        }
		    }
		 
		    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(
		            final Map<K, V> map) {
		        Comparator<K> valueComparator = new Comparator<K>() {
		            public int compare(K k1, K k2) {
		                int compare = map.get(k2).compareTo(map.get(k1));
		                if (compare == 0)
		                    return 1;
		                else
		                    return compare;
		            }
		        };
		        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		        sortedByValues.putAll(map);
		        return sortedByValues;
		    }
		 
		    public static void main(String[] args) {
		        HashMap<Long, Double> map = new HashMap<Long, Double>();
		        map.put(1l, 99.5);
		        map.put(2l, 67.2);
		        map.put(3l, 67.5);
		        map.put(4l, 67.6);
		 
		        MapSort bvc = new MapSort(map);
		        TreeMap<Long, Double> sorted_map = new TreeMap<Long, Double>(bvc);
		        System.out.println("unsorted map: " + map);
		        sorted_map.putAll(map);
		        System.out.println("results: " + sorted_map);
		        Map<Long, Double> sorted_map2 = sortByValues(map);
		        System.out.println("results2: " + sorted_map2);
		    }
		}
