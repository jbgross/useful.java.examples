package com.joshuabgross.cs.examples.binary;

import edu.blackburn.cs.cs372.bitshifting.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * This class generates/writes/reads binary data. It can be used by
 * 
 * @author joshua.gross
 */
public class BinaryData {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BinaryData gen = new BinaryData();
        //gen.choose();
        gen.read("sample1.bin");
    }

    public static byte[] generateRandomBytes(int count) {
        Random rand = new Random();
        byte[] randomData = new byte[count];
        rand.nextBytes(randomData);
        return randomData;
    }

    public void choose() throws IOException {
        System.out.print("[r]ead or [w]rite? ");
        char option = scan.next().charAt(0);
        System.out.print("Enter a filename: ");
        String filename = scan.next();
        switch (option) {
            case 'w':
                this.generate(filename);
                break;
            default:
                BinaryData.read(filename);
                break;
        }
    }

    public void generate(String filename) throws IOException {
        System.out.print("Enter a file size in bytes: ");
        int count = scan.nextInt();

        byte[] randomData = generateRandomBytes(count);

        // writes to the root of the project, not the root of the code repo
        Path path = Paths.get(filename);
        Files.write(path, randomData);
    }

    /**
     * Reads binary data from a file and returns as an array of bytes. This
     * would really, really suck for a large file, and couldn't handle a file
     * larger than INT_MAX bytes, but oh man, you'd be in much pain long before
     * then. C'mon, this is a demonstration program.
     * @param filename the name of the file, absolute or relative to execution, 
     * usually the root project directory for most IDEs
     * @return an array of bytes
     * @throws IOException 
     */
    public static byte[] read(String filename) throws IOException {
        return Files.readAllBytes(Paths.get(filename));

    }
}
