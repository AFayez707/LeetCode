package Amazon.Design.Stock_Price_Fluctuation;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class StockPrice {
    // Link: https://leetcode.com/problems/stock-price-fluctuation/
    // Time: O(Log(N)) For each operation
    // Space: O(n)
    TreeMap<Integer, Integer> tm = new TreeMap<>();
    TreeMap<Integer, Set<Integer>> valueTimeStamp = new TreeMap<>();
    public StockPrice() {
        tm = new TreeMap<>();
        valueTimeStamp = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if(tm.containsKey(timestamp)){//update to existing value - correction
            int oldPrice = tm.get(timestamp);
            valueTimeStamp.get(oldPrice).remove(timestamp);
            if(valueTimeStamp.get(oldPrice).size()==0)//if only one timestamp had the value and it later got updated
                valueTimeStamp.remove(oldPrice);
        }
        tm.put(timestamp, price);
        valueTimeStamp.putIfAbsent(price, new HashSet<>());
        valueTimeStamp.get(price).add(timestamp);
    }

    public int current() {
        return tm.get(tm.lastKey());
    }

    public int maximum() {
        return valueTimeStamp.lastKey();
    }

    public int minimum() {
        return valueTimeStamp.firstKey();
    }
}