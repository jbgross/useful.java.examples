package com.joshuabgross.cs.er;

/**
 * This code defines an abstract Queue built around the LinkedList class
 * It is part of the stack/queue game lab I use in CS212 at Blackburn College.
 * Students have to implement this Queue. Contact me for documentation.
 * @author joshua.gross
 */
public abstract class AbstractQueue {

    protected ListElement start = null;
    protected ListElement end = null;

    private int length;

    protected final void increment() {
        this.length++;
    }

    protected final void decrement() {
        this.length--;
    }

    public final int length() {
        return this.length;
    }

    /**
     * Should create a new ListElement, point the end ListElement's nextElement
     * to the new ListElement, and set end to the new ListElement
     */
    public abstract void enqueue(Patient add);

    /**
     * Should return the content of the current top element of the stack and
     * decrement length unless top == null, in which case return null and don't
     * decrement.
     */
    public abstract Patient dequeue();

    public double health() {
        if (this.start != null) {
            return this.start.sumHealth();
        }
        return 0;
    }

    public int priority() {
        if (this.start != null) {
            return this.start.sumPriority();
        }
        return 0;
    }

}
