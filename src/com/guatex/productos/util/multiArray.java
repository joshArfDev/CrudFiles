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
public class multiArray {
 
    public static void main(String[] args) {
        
        int rows = 4;
        int colums = 4;
        
        int[][] array = new int[rows][colums];
        
        int value = 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                array[i][j] = value * 2;
                value ++;
            }
        }
        
        System.out.println("The 2D array is: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
