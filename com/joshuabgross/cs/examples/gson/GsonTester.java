package com.joshuabgross.cs.examples.gson;

import com.google.gson.*;

/**
 *
 * @author joshua.gross
 */
public class GsonTester {

    public static void main(String[] args) {
        // Serialization
        Gson gson = new Gson();
        GsonExample gt = new GsonExample("Kelsie", 20);
        String j1 = gson.toJson(gt);            // ==> 1
        System.out.println(j1);
        //String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
    }
}
