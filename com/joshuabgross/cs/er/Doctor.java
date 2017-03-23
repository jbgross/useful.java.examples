package com.joshuabgross.cs.er;

/**
 * This code defines Doctor to treat Patient objects in our Emergency Room.
 * It is part of the stack/queue game lab I use in CS212 at Blackburn College.
 * Students have to implement this Queue. Contact me for documentation.
 * @author joshua.gross
 */
public class Doctor {
    
    private AbstractQueue queue;
    private AbstractStack stack;
    private int healed = 0;
    private double health = 0;
    
    /**
     * Creates a new doctor
     * @param queue the queue of patients to be healed
     * @param stack the stack of patients to be healed
     */
    public Doctor(AbstractQueue queue, AbstractStack stack) {
        this.queue = queue;
        this.stack = stack;
    }
    
    /**
     * Heals the next patient in order from the stack and from the queue
     */
    public void heal() {
        Patient a = this.stack.pop();
        if(a != null && a.getHealth() > 0) {
            this.healed++;
            this.health += a.getHealth();
        }
        
        a = this.queue.dequeue();
        if(a != null && a.getHealth() > 0) {
            this.healed++;
            this.health += a.getHealth();
        }
    }
    
    /**
     * 
     * @return 
     */
    public int getHealed() {
        return this.healed;
    }
    
    public double getHealth() {
        return this.health;
    }
    
    
}
