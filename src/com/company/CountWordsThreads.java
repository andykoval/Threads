package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by andy on 04.12.2017.
 */
public class CountWordsThreads {
    Map<String, Integer> countWordsMain = new TreeMap<>();
    List<String> words = new ArrayList<>();
    List<Thread> threads = new ArrayList<>();
    File book = new File("C:\\dir1\\wp.txt");
    static int wordToOneProc;

    public static void main(String[] args) throws IOException {
        CountWordsThreads cwt = new CountWordsThreads();

        int procNumb = Runtime.getRuntime().availableProcessors();
                List<String> lines = Files.readAllLines(cwt.book.toPath());

        for (String line : lines) {
            String[] lineWords = line.toLowerCase()
                    .replaceAll("\\p{Punct}", " ")
                    .trim()
                    .split("\\s");
            for (String word : lineWords) {
                if (word.length() > 0)
                    cwt.words.add(word);
            }
        }
        wordToOneProc = cwt.words.size() / procNumb;
        for (int i = 0; i < procNumb; i++) {
            int firstInd = wordToOneProc * i;
            int lastInd = wordToOneProc * i + wordToOneProc;
//            System.out.println(firstInd+" " +lastInd);
            cwt.threads.add(new ThreadRead(cwt.countWordsMain, cwt.words.subList(firstInd, lastInd)));
        }
        for (Thread thread : cwt.threads)
            thread.start();

        for (Thread thread : cwt.threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int cnt =0;
        for (Map.Entry<String,Integer> entry: cwt.countWordsMain.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue()+" "+cnt++);
        }
//            for (Map.Entry<String,Integer> entry: countWords.entrySet()){
//                System.out.println(entry.getKey()+" "+entry.getValue());
//            }
//        List<Map.Entry<String, Integer>> listResult = new ArrayList(countWords.entrySet());
//        Collections.sort(listResult, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });

//        int i = 1;
//        for (Map.Entry<String, Integer> entry : listResult){
//            System.out.println(entry);
//            if (++i > 100) break; // обговорить!
//        }
    }
}
