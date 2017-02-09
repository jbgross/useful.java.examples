/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuabgross.cs.examples.binary;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author joshua.gross
 */
public class NGramListMaker {

    private HashMap<String, Integer> all = new HashMap();
    Random rand = new Random();

    public NGramListMaker(String filename, int nGramSize, int listSize) throws IOException {
        int count = 1;
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = sc.next();
        System.out.print("NGram Size: ");
        int nGramSize = sc.nextInt();
    }

}
