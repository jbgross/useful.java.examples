package com.joshuabgross.cs.er;

/**
 * This code defines a ListElement object for a LinkedList containing a
 * set of Patient objects. It is part of the stack/queue game lab I use
 * in CS212
 * @author joshua.gross
 */
public class ListElement {
    private ListElement nextElement = null;
    
    private Patient patient = null;
    
    public ListElement(Patient patient) {
        this.patient = patient;
    }
    
    public ListElement getNext() {
        return nextElement;
    }
    
    public void setNext(ListElement next) {
        this.nextElement = next;
    }
    
    public void addToEnd(Patient a) {
        if(nextElement != null) {
            nextElement.addToEnd(a);
        } else {
            this.nextElement = new ListElement(a);
        }
    }
    
    public double sumHealth() {
        double sum = this.getPatient().getHealth();
        if(this.getNext() != null) {
            sum =  + this.getNext().sumHealth();
        }
        return sum;
    }

    public int sumPriority() {
        int sum = this.getPatient().getPriority();
        if(this.getNext() != null) {
            sum += this.getNext().sumPriority();
        }
        return sum;
    }
    
    public Patient getPatient() {
        return this.patient;
    }

    
}
