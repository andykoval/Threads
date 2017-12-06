package com.company;

/**
 * Created by andy on 06.12.2017.
 */


import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.lang.*;


public class Test {

        public static void main(String[] args) {

            HashMap<Character, Integer> map = new HashMap<>();
            ValueComparatorA bvc =  new ValueComparatorA(map);
            TreeMap<Character, Integer> sorted_map = new TreeMap<>(bvc);

            map.put('A',99); //одинаковые значения пропадут
            map.put('B',67);
            map.put('C',63);
            map.put('D',22);
            map.put('E',99);

            System.out.println("unsorted map");
            for (Character key : map.keySet()) {
                System.out.println("key/value: " + key + "/"+map.get(key));
            }

            sorted_map.putAll(map);

            System.out.println("results");
            for (Character key : sorted_map.keySet()) {
                System.out.println("key/value: " + key + "/"+sorted_map.get(key));
            }
        }
    }

    class ValueComparatorA implements Comparator<Object> {

        HashMap<Character, Integer> base;
        public ValueComparatorA(HashMap<Character, Integer> base) {
            this.base = base;
        }

        public int compare(Object a, Object b) {

            if((Integer)base.get(a) < (Integer)base.get(b)) {
                return 1;
            } else if((Integer)base.get(a) == (Integer)base.get(b)) {
                return 0;
            } else {
                return -1;
            }

        }
    }
