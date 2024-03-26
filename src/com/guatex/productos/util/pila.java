/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.productos.util;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author GUATEX
 */
public class pila {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack myStack = new Stack<>();

        String opcion = "";

        do {

            System.out.println("\nIngresa elemento para insertar a la pila: ");
            String element = sc.nextLine();
            myStack.add(element);

            System.out.println("\n---------------------------");
            System.out.println("Desea insertar otro elemento a la pila: (S/N)");
            opcion = sc.nextLine();

            if (!opcion.equalsIgnoreCase("s")) {
                System.out.println("\n¡Por favor, si deseas seguir insertando escribe Si | S!");
                System.out.println("Desea insertar otro elemento a la pila: (S/N)");
                opcion = sc.nextLine();
            }

        } while (!opcion.equalsIgnoreCase("No") && !opcion.equalsIgnoreCase("N"));

        System.out.println("\nTu pila actual " + myStack);

        System.out.println("\n\nEl primer elemento que se eliminará será: " + myStack.peek());

        while (!myStack.empty()) {
            myStack.pop();
            System.out.println("\nTu pila actual despues de hacer POP" + myStack);
        }

        sc.close();

    }
}
