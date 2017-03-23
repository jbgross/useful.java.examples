package com.joshuabgross.cs.er;

public class Runner {

    public static void main(String[] args) {
        Patient p = Patient.newPatient();
        System.out.println("Priority: " + p.getPriority());
        double health = 0;
        do {
            health = p.getHealth();
            System.out.println("Health: " + health);
        } while (health > 0);
        
        ListElement first = new ListElement(Patient.newPatient());
        ListElement next = first;
        for(int i = 0; i <10; i++) {
            next = add(next);
        }
        
        System.out.println("");
        System.out.println("Priority: " + first.sumPriority());
        do {
            health = first.sumHealth();
            System.out.println("Health: " + health);
        } while (health > 0);
    }
    
    private static ListElement add(ListElement le) {
        ListElement newle = new ListElement(Patient.newPatient());
        le.setNext(newle);
        return newle;
    }
}
