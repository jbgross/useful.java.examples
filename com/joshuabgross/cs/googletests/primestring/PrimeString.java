package com.joshuabgross.cs.googletests.primestring;

public class PrimeString {

    public static void main(String[] args) {
        int prime = 0;
        for (int i = 0; i < 10; i++) {
            prime = nextPrime(prime);
            System.out.println("prime = " + prime);
            
        }
        System.out.println(answer(0));
        System.out.println(answer(5));

    }

    public static String answer(int n) {
        int prime = 0;
        int primeCount = 0;
        while (primeCount < n) {
            prime = nextPrime(prime);
            primeCount++;
        }
        String s = "" + prime;
        for (int i = 0; i < 5; i++) {
            prime = nextPrime(prime);
            s += prime;
        }
        return s.substring(0, 5);
        // Your code goes here.

    }

    public static int nextPrime(int i) {
        if(i == 0) {
            return 2;
        } else if (i == 1) {
            return 3;
        }
        
        while (true) {
            if (isPrime(++i)) {
                return i;
            }
        }
    }

    public static boolean isPrime(int i) {
        if(i < 3) {
            return true;
        }
        for (int c = 2; c <= (int) Math.sqrt(i); c++) {
            if (i % c == 0) {
                return false;
            }
        }
        return true;
    }
}
