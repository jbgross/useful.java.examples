package com.joshuabgross.cs.examples.binary;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * Generates a file of a specified number of unique, random ngrams, where n is 
 * also specified
 * @author joshua.gross
 */
public class NGramListMaker {

    private HashMap<String, Integer> all = new HashMap();
    private Random rand = new Random();

    /**
     * 
     * @param filename
     * @param nGramSize
     * @param listSize
     * @throws IOException 
     */
    public NGramListMaker(String filename, int nGramSize, int listSize) throws IOException {
        if (listSize >= Math.pow(26, nGramSize))
            throw new RuntimeException ("Too many ngrams for uniqueness )(>=26^N).");
        int count = 0;
        while(true) {
            String s = this.generateNGram(nGramSize);
            if(this.all.containsKey(s)) {
                continue;
            }
            this.all.put(s, 1);
            count++;
            if (count >= listSize)
                break;
        }
        Path path = Paths.get(filename);
        Files.write(path, this.all.keySet());
    }
    
    /**
     * Generate a random (not necessarily unique) ngram of the specified
     * length, all lowercase
     * @param length
     * @return 
     */
    private String generateNGram(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(this.generateChar());
        }
        return sb.toString();
    }
    
    private char generateChar() {
        return (char) (this.rand.nextInt(26) + 97);
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = sc.next();
        System.out.print("NGram Size: ");
        int nGramSize = sc.nextInt();
        System.out.print("Number of NGrams: ");
        int nGramCount = sc.nextInt();
        new NGramListMaker(filename, nGramSize, nGramCount);
    }

}
