/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joshuabgross.cs.examples.gson;

/**
 *
 * @author joshua.gross
 */
public class GsonExample {
    
    private String name;
    private int age;
    
    public GsonExample(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
}
