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
public class DoublyLinkedList {

    //Definimos nuestra clase para crear nuestros nodos
    class Node {

        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //Nuestras guías (cabeza y cola) se igualan a null 
    Node head, tail = null;

    public void addNode(int data) {

        //Nuevo nodo
        Node newNode = new Node(data);

        if (head == null) {
            //Si la lista está vacía, asignamos el nuevo nodo como head y tail 
            head = tail = newNode;

            head.previous = null; // El nodo head no tiene nodo anterior
            tail.next = null; // El nodo tail no tiene nodo siguiente

        } else {
            // Si la lista no está vacía, agregamos el nuevo nodo al final    
            tail.next = newNode;

            newNode.previous = tail;// El nodo anterior al nuevo nodo es el tail actual

            tail = newNode; // Actualizamos el tail al nuevo nodo

            tail.next = null; // El nodo tail no tiene nodo siguiente
        }
    }

    public void displayNode() {

        Node current = head;

        if (head == null) {
            System.out.println("DoublyLinked lis is empty");
            return;
        }

        System.out.println("Nodes of doubly linked list:");

        while (current != null) {

            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList doublyList = new DoublyLinkedList();

        doublyList.addNode(1);
        doublyList.addNode(2);
        doublyList.addNode(3);
        doublyList.addNode(4);
        doublyList.addNode(5);

        doublyList.displayNode();

        System.out.println("\n");
    }
}
