package com.joshuabgross.cs.examples.binary;

import java.io.*;

/**
 * This class demonstrates the bitwise operators in Java (although they are
 * common to C-like languages) by performing operations on one or a pair of
 * bytes. Instances read through an array of bytes, either randomly generated or
 * passed in via the constructor. Something is not working right about the right
 * shift with negative bytes (numbers between -127 and -1). I think it has
 * something to do with byte->int conversion, but I'm tired and not sure and
 * will fix tomorrow (and tomorrow and tomorrow creeps at this petty pace from
 * day to day to the last syllable of recorded time and all our yesterdays have
 * lighted fools the way to dusty death out out brief candle life's but a
 * walking shadow a poor player that struts and frets his hour upon the stage
 * and then is heard no more it is a tale told by an idiot full of sound and
 * fury signifying nothing)
 *
 * @author joshua.gross gross.joshua.b@gmail.com
 */
public class BitShifting {

    private byte[] data;

    /**
     * The default number of bytes to create and convert; has to be static to
     * use in argument passed to secondary constructor
     */
    public static final int DEFAULTCOUNT = 8;

    public static String byteToBinary(byte c) {
        return String.format("%8s", Integer.toBinaryString(c & 0xFF)).replace(' ', '0');
    }

    public static String intToBinary(int c) {
        StringBuilder sb = new StringBuilder(String.format("%32s", Integer.toBinaryString(c & -1)).replace(' ', '0'));
        sb.insert(8, " ").insert(17, " ").insert(26, " ");
        return sb.toString();
    }

    public static String eachBit(byte c) {
        StringBuilder buildf = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            buildf.append(c >> i & 1);
        }
        return buildf.toString();
    }

    public static String eachBit(int c) {
        StringBuilder buildf = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            buildf.append(c >> i & 1);
            if(i < 31 && i % 8 == 0)
                buildf.append(" ");
        }
        return buildf.toString();
    }
    
    /**
     * Convenience method - must have file named sample1.bin
     * @param args 
     * @exception IOException
     */
    /*public static void main(String[] args) throws IOException {
        new BitShifting(BinaryData.read("sample1.bin"));
    }*/

    /**
     * With no argument, randomly generates DEFAULTCOUNT number of bytes and
     * loops through them
     */
    public BitShifting() {
        this(BitShifting.DEFAULTCOUNT);
    }

    /**
     * With no argument, randomly generates DEFAULTCOUNT number of bytes and
     * loops through them
     *
     * @param count the number of bytes to generate (will perform 1/2 that
     * number of comparisons)
     */
    public BitShifting(int count) {
        this.data = BinaryData.generateRandomBytes(count);
        this.run();
    }

    /**
     *
     * @param data an array of bytes from another source (e.g., read in from
     * BinaryData)
     */
    public BitShifting(byte[] data) {
        this.data = data;
        this.run();
    }

    /**
     * This final constructor takes the name of a binary file. This file could
     * have been generated by the BinaryData class, but it should work for any
     * binary file. The filename must be absolute, or it will attempt to open
     * the file from where it is run (the root of the project by default in most
     * IDEs).
     *
     * @param filename the name of the binary file to open
     * @throws IOException thrown if something bad happens, like the file cannot
     * be opened, perhaps because it doesn't exist
     */
    public BitShifting(String filename) throws IOException {
        this(BinaryData.read(filename));
    }

    /**
     * No need to make this threaded right now, but easily done and use of
     * StringBuilder will prevent conflicts
     */
    private void run() {
        // loop through each pair
        for (int i = 0; i < this.data.length - 1; i += 2) {
            BitShifting.BytePair bp = new BitShifting.BytePair(this.data[i], this.data[i + 1]);
            System.out.println(bp.convert());
        }
    }

    /**
     * Internal class to hold a pair of bytes and do a series of bitwise
     * conversions using one or both, returning the results as a string
     */
    class BytePair {

        byte a;
        byte b;

        BytePair(Byte a, Byte b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return BitShifting.byteToBinary(a) + " (" + a + "): a\n"
                    + BitShifting.byteToBinary(b) + " (" + b + "): b";
        }

        public String convert() {
            StringBuilder build = new StringBuilder();
            byte and = (byte) (a & b);
            byte or = (byte) (a | b);
            byte xor = (byte) (a ^ b);
            byte acomp = (byte) ~a;
            byte left4 = (byte) (a << 4);
            byte arithmeticRight4 = (byte) (a >> 4);
            byte logicalRight4 = (byte) (a >>> 4);
            int ai = a;
            int arithmeticRight4i = ai >> 4;
            int logicalRight4i = ai >>> 4;

            build.append(this);
            build.append("\n");
            build.append(BitShifting.byteToBinary(and)).append(" (").append(and).append("): ").append(a).append(" & ").append(b);
            build.append("\n");
            build.append(BitShifting.byteToBinary(or)).append(" (").append(or).append("): ").append(a).append(" | ").append(b);
            build.append("\n");
            build.append(BitShifting.byteToBinary(xor)).append(" (").append(xor).append("): ").append(a).append(" ^ ").append(b);
            build.append("\n");
            build.append(BitShifting.byteToBinary(acomp)).append(" (").append(acomp).append("): ^").append(a);
            build.append("\n");
            build.append(BitShifting.byteToBinary(left4)).append(" (").append(left4).append("): ").append(a).append("<<4");
            build.append("\n");
            build.append(BitShifting.byteToBinary(arithmeticRight4)).append(" (").append(arithmeticRight4).append("): ").append(a).append(">>4 (arithmetic shift***)");
            build.append("\n");
            build.append(BitShifting.byteToBinary(logicalRight4)).append(" (").append(logicalRight4).append("): ").append(a).append(">>>4 (logical shift***)");
            build.append("\n");
            build.append(BitShifting.intToBinary(logicalRight4i)).append(" (").append(logicalRight4i).append("): ").append(a).append(">>>4 (logical shift***)");
            build.append("\n");
            build.append("*** - right shifting fails for neg. bytes because converting to int causes complement operation, filling in ones");
            build.append("\n");
            build.append(BitShifting.eachBit(a)).append(": each byte of ").append(a).append(" via looping");
            build.append("\n");
            build.append(a).append(" is").append(this.isPositive(a) ? " not" : "").append(" negative based on the first bit");
            build.append("\n");
            build.append(BitShifting.eachBit(ai)).append(": each byte of integer ").append(ai).append(" via looping");
            build.append("\n");
            build.append(BitShifting.intToBinary(ai)).append("  (").append(ai).append("): a as an integer (ai)");
            build.append("\n");
            build.append(BitShifting.intToBinary(arithmeticRight4i)).append(" (").append(arithmeticRight4i).append("): ").append(ai).append(">>>4 (integer arithmetic shift)");
            build.append("\n");
            build.append(BitShifting.intToBinary(logicalRight4i)).append(" (").append(logicalRight4i).append("): ").append(ai).append(">>>4 (integer logical shift)");
            build.append("\n");
            return build.toString();
        }

        boolean isPositive(byte c) {
            return (c >> 7 == 0);
        }
    }
}
