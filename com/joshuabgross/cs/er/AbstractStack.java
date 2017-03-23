package com.joshuabgross.cs.er;

/**
 * This code defines an abstract Stack built around the LinkedList class
 * It is part of the stack/queue game lab I use in CS212 at Blackburn College.
 * Students have to implement this Queue. Contact me for documentation.
 * @author joshua.gross
 */
public abstract class AbstractStack {

    protected ListElement top = null;
    private int depth;

    public final int depth() {
        return this.depth;
    }

    protected final void increment() {
        this.depth++;
    }

    protected final void decrement() {
        this.depth--;
    }

    /**
     * Should create a new ListElement, point that element's nextElement to the
     * current top element of the stack and increment depth
     */
    public abstract void push(Patient add);

    /**
     * Should return the content of the current top element of the stack and
     * decrement depth unless top == null, in which case return null and don't
     * decrement.
     */
    public abstract Patient pop();

    public double health() {
        if (this.top != null) {
            return this.top.sumHealth();
        }
        return 0;
    }

    public int priority() {
        if (this.top != null) {
            return this.top.sumPriority();
        }
        return 0;
    }
}
