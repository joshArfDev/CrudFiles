/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.productos.util;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.LinkedList;

/**
 *
 * @author GUATEX
 */
public class linkedList {
    
    public static void main(String[] args) {
        
        LinkedList<String> products = new LinkedList<>();
        
        products.add("Shampoo");
        products.add("Pc Gamming");
        products.add("Laptop");
        
        System.out.println("LinkedList: " + products);
        
        
        products.add(3, "Smartwatch");
        
        String prd = products.getLast();
        
        System.out.println("Updated Linkedlist: " + products);
        
        String update = products.set(3, "Applewatch");
        System.out.println(update);
        
        System.out.println("Updated Linkedlist: " + products);
        System.out.println(products.getLast());
        
        String remove = products.remove(1);
        System.out.println("LinkeList Updated: " + products);
        
    }
}
