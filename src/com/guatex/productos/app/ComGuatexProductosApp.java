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
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author GUATEX
 */
public class ComGuatexProductosApp {

    static Scanner scanner = new Scanner(System.in); //para entrada de datos en consola
    static LinkedList<EProducto> productos = new LinkedList<>();
    static String archivo = "productos";

    public static void main(String[] args) {
        int opcion = 0;

        do {

            try {

                System.out.println("Elige opción:"
                        + "\n1.- Buscar"
                        + "\n2.- Listar"
                        + "\n3.- Insertar"
                        + "\n4.- Modificar"
                        + "\n5.- Eliminar"
                        + "\n6.- Salir");

                System.out.println("Opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        break;
                    case 2:
                        System.out.println("\n------ LISTAR  ------");
                        listarDatos();
                        break;
                    case 3:
                        System.out.println("\n ----- INSERTAR  -----");
                        insertaDatos();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                            System.out.println("\n ------ DATOS GUARDADOS  -------");
                            guardarDatos();
                        break;

                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 6);

        scanner.close();
    }

    public static void listarDatos() {

        System.out.println("Lista de productos ingresados:");

        for (EProducto producto : productos) {
            System.out.println("Nombre: " + producto.getNombreProducto());
            System.out.println("Descripción: " + producto.getDescripcionProducto());
            System.out.println("Precio en bodega: " + producto.getPrecioBodega());
            System.out.println("Precio de venta: " + producto.getPrecioVenta());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("------------------------");
        }
    }

    public static void insertaDatos() {

        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el precio en bodega del producto: ");
        float precioBodega = Float.parseFloat(scanner.nextLine());

        System.out.println("Ingrese el precio de venta del producto: ");
        float precioVenta = Float.parseFloat(scanner.nextLine());

        System.out.println("Ingrese la cantidad del producto: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        EProducto producto = new EProducto();
        producto.setNombreProducto(nombre);
        producto.setDescripcionProducto(descripcion);
        producto.setPrecioBodega(precioBodega);
        producto.setPrecioVenta(precioVenta);
        producto.setCantidad(cantidad);

        productos.add(producto);
    }

    public static void guardarDatos() {
        try (FileWriter writer = new FileWriter(archivo)) {
            for (EProducto producto : productos) {
                String data = producto.getNombreProducto() + ","
                        + producto.getDescripcionProducto() + ","
                        + producto.getPrecioBodega() + ","
                        + producto.getPrecioVenta() + ","
                        + producto.getCantidad() + "\n";
                writer.write(data);
            }
            System.out.println("Datos guardados correctamente en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static void actualizarDatos(String[] args) {

    }
}
