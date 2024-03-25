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
public class simpleArray {

    public static void main(String[] args) {

        String[] names;
        names = new String[]{"jdksafj", "dfas"};

        for (String aux : names) {
            System.out.println(aux);
        }

        System.out.println("\n----------------");

        int[] numbers;
        numbers = new int[10];

        int aux = 1;

        for (int i = 0; i < numbers.length; i++) {
            aux += numbers[i];
            System.out.println(aux++);
        }
        
        System.out.println("\n-----------");

        int numeros[] = new int[]{55,978,13,3};
        int sumar = 0;
        
        for (int i = 0; i < numeros.length; i++) {
            sumar += numeros[i];
        }
        System.out.println("TOTAL: " + sumar );
    }
    
}
