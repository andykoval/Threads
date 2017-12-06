package com.company;

import java.util.*;

/**
 * Created by andy on 04.12.2017.
 */
public class ThreadRead extends Thread {
    Map<String, Integer> mainCountWords;
    List<String> words;
    HashMap<String, Integer> getCountWords = new HashMap<>();
    ValueComparator valueComp = new ValueComparator(getCountWords);
    TreeMap<String, Integer> sortedMap = new TreeMap<>(valueComp);


    ThreadRead(Map<String, Integer> mainCountWords, List<String> words) {
        this.mainCountWords = mainCountWords;
        this.words = words;
    }

    @Override
    public void run() {

            int count = 0;
            for (String word : words) {
                try {
                    if (getCountWords.containsKey(word))
                        count = getCountWords.get(word) + 1;
                    else
                        count = 1;
                    getCountWords.put(word, count);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        sortedMap.putAll(getCountWords);
//        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        synchronized (mainCountWords) {
            int countSync = 0;
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                if (countSync == 50) {
                    break;
                }
                countSync++;
                mainCountWords.put(entry.getKey(), entry.getValue());
            }
        }
    }
}

class ValueComparator implements Comparator<Object> {
    HashMap<String, Integer> unSortMap;

    ValueComparator(HashMap<String, Integer> unSortMap) {
        this.unSortMap = unSortMap;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if ((Integer) unSortMap.get(o1) < (Integer) unSortMap.get(o2))
            return 1;
        else if ((Integer) unSortMap.get(o1) == (Integer) unSortMap.get(o2))
            return 0;
        else return -1;
    }
}
