package com.joshuabgross.cs.er;

import java.util.*;

/**
 * This code defines Patient to be treated in our Emergency Room.
 * It is part of the stack/queue game lab I use in CS212 at Blackburn College.
 * Students have to implement this Queue. Contact me for documentation.
 * @author joshua.gross
 */
public class Patient {

    private static final Random rand = new Random();
    private int priority = 0;
    private int sum = 0;
    private final double decrement;

    private double health = 99;

    private Patient(int priority) {
        this.priority = priority;
        while (priority > 0) {
            sum++;
            priority--;
        }
        this.decrement = Math.pow(2, (this.sum * 0.25)) * this.sum * 0.2 + 1;
    }

    public int getPriority() {
        return this.priority;
    }

    public double getHealth() {
        if (this.health > this.decrement) {
            this.health -= this.decrement;
            return this.health;
        }
        
        return 0;
    }
    
    public static final Patient newPatient() {
        return new Patient(Patient.rand.nextInt(10) + 1);
    }
}
