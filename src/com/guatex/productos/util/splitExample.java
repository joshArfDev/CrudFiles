/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.productos.util;

/**
 *
 * @author GUATEX
 */
public class splitExample {
    
    public static void main(String[] args) {
        
        String data = "HOW.TO.SPLIT.A.STRING.IN.JAVA";
        String[] split = data.split("\\.");
        
        for (String aux : split) {
            
            System.out.println(aux);
        }
    }
}
