/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guatex.productos.app;

import com.guatex.productos.Entidad.EProducto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author GUATEX
 */
public class ComGuatexProductosApp {

    static Scanner scanner = new Scanner(System.in); //para entrada de datos en consola

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        EProducto producto = new EProducto();
        int opcion = 0;
        //Mientras la opción elegida no sea 0, preguntamos al usuario
        do {
            //Try catch para evitar que el programa termine si hay un error
            try {
                System.out.println("Elige opción:"
                        + "\n1.- Buscar"
                        + "\n2.- Listar \n"
                        + "3.- Insertar \n"
                        + "4.- Modificar \n"
                        + "5.- Eliminar \n"
                        + "6.- Salir");

                System.out.println("Opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        System.out.println("\n---- BUSCAR ----- \n");
                        break;
                    case 2:
                        System.out.println("\n---- LISTAR ----- \n");

                        muestraDatos();

                        break;
                    case 3:
                        System.out.println("\n---- INSERTAR ----- \n");
                        insertaDatos();

                        break;
                    case 4:
                        System.out.println("\n---- MODIFICAR ----- \n");
                        break;
                    case 5:
                        System.out.println("\n---- ELIMINAR ----- \n");
                        break;
                    case 6:
                        System.out.println("Cerrando Programa!");
                        break;
                    default:
                        System.out.println("Opción no reconocida");
                        break;

                }

                System.out.println("\n");

            } catch (Exception e) {
                System.out.println(" Error");
            }
        } while (opcion != 6);

//        File doc = new File("Test.txt");
//        BufferedReader obj = new BufferedReader(new FileReader(doc));
//
//        String strng;
//        while ((strng = obj.readLine()) != null) System.out.println(strng);
    }

    public static void insertaDatos() throws FileNotFoundException, IOException {

        EProducto producto = new EProducto();

        System.out.println("Ingrese nombre del producto:");
        producto.setNombreProducto(scanner.nextLine());

        System.out.println("\nIngrese descripcion del producto:");
        producto.setDescripcionProducto(scanner.nextLine());

        System.out.println("\nIngrese precio de bodega:");
        producto.setPrecioBodega(Float.parseFloat(scanner.nextLine()));

        System.out.println("\nIngrese precio de venta:");
        producto.setPrecioVenta(Float.parseFloat(scanner.nextLine()));

        System.out.println("\nIngrese cantidad:");
        producto.setCantidad(Integer.parseInt(scanner.nextLine()));

        // nueva cadena con los datos ingresados
        String datosProducto = "\n----------------------\n"
                + "Nombre: " + producto.getNombreProducto()
                + "\nDescripción: " + producto.getDescripcionProducto()
                + "\nPrecio en bodega: Q." + producto.getPrecioBodega()
                + "\nPrecio de venta: Q." + producto.getPrecioVenta()
                + "\nCantidad disponible: " + producto.getCantidad();

        try {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\GUATEX\\Documents\\NetBeansProjects\\com.guatex.productos.app\\src\\com\\guatex\\productos\\Datos\\DB.txt", true))) {
                writer.write(datosProducto);
                writer.newLine();
                writer.close();
            }
            System.out.println("\n Los datos se han guardado en el archivo DB.txt");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
        System.out.println("\nDatos del producto ingresado:\n" + datosProducto);
    }

    public static void muestraDatos(String archivo) throws FileNotFoundException, IOException {

        System.out.println("\nMOSTRANDO DATOS INGRESADOS");
        String cadena;
        
        FileReader reader = new FileReader(archivo);
        BufferedReader bReader = new BufferedReader(reader);
        while( ( cadena = bReader.readLine() )!= null ) {
            System.out.println(cadena);
        }
        
        
    }

}
