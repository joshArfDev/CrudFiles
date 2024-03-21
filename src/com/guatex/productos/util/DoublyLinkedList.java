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
    
    class Node {
        int data;
        Node previous;
        Node next;
        
        public Node( int data ) {
            this.data = data;
        }
    }
    
    Node head, tail = null;
    
    public void addNode( int data ){
        
        Node newNode = new Node(data);
        
        if ( head == null ) {
            
            head = tail = newNode;
            
            head.previous = null;
            tail.next = null;
            
        } else {
            
            tail.next = newNode;
            
            newNode.previous = tail;
            
            tail = newNode;
            
            tail.next = null;
        }
    }
    
    public void displayNode () {
        
        Node current = head;
        
        if ( head == null ) {
            System.out.println("DoublyLinked lis is empty");
            return;
        }
        
        System.out.println("Nodes of doubly linked list:");
        
        while ( current != null ) {            
            
            System.out.print( current.data + ", " );
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
