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
import static java.lang.System.in;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author GUATEX
 */
public class ComGuatexProductosApp {

    static Scanner scanner = new Scanner(System.in); //para entrada de datos en consola
    static LinkedList<EProducto> productos = new LinkedList<>(); // Creando nuestra lista enlazada
    static String nombreArchivo = "C:\\Users\\GUATEX\\Documents\\NetBeansProjects\\com.guatex.productos.app\\src\\com\\guatex\\productos\\Datos\\productos.txt"; 
    static String archivo = nombreArchivo ; // nombre de nuestro archivo

    public static void main(String[] args) {

        int opcion = 0;

        cargarDatos();

        do {

            try {

                System.out.println("\nElige opción:"
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
                        System.out.println("\n------ BUSCAR ------");
                        buscarDato();
                        break;
                    case 2:
                        System.out.println("\n------ LISTAR ------");
                        listarDatos();
                        break;
                    case 3:
                        System.out.println("\n ----- INSERTAR  -----");
                        insertaDatos();
                        break;
                    case 4:
                        System.out.println("\n ----- ACTUALIZAR -----");
                        actualizarDato();
                        break;
                    case 5:
                        System.out.println("\n ---- ELIMINAR -----");
                        eliminarDato();
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

        //Creando objeto para producto que ingresemos
        EProducto producto = new EProducto();
        producto.setNombreProducto(nombre);
        producto.setDescripcionProducto(descripcion);
        producto.setPrecioBodega(precioBodega);
        producto.setPrecioVenta(precioVenta);
        producto.setCantidad(cantidad);

        //Añadimos nuestro objeto producto a nuetro linkedlist
        productos.add(producto);
    }

    public static void listarDatos() {

        System.out.println("Lista de productos ingresados:");

        //Recorremos nuestra linkedlist, gracias a la variables producto (esta variable es de tipo " nuestro Objeto EProducto" )
        for (EProducto producto : productos) {
            System.out.println("Nombre: " + producto.getNombreProducto());
            System.out.println("Descripción: " + producto.getDescripcionProducto());
            System.out.println("Precio en bodega: " + producto.getPrecioBodega());
            System.out.println("Precio de venta: " + producto.getPrecioVenta());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("------------------------");
        }
    }

    public static void buscarDato() {

        System.out.println("Ingrese producto a buscar: ");
        String productoBuscar = scanner.nextLine();

        //Bandera para poder hacer la validación de la existencia del producto
        boolean encontrado = false;

        //Recorremos nuestra linkedlist y obtenemos (get) los datos del producto solo si coincide lo que estamos buscando
        for (EProducto producto : productos) {
            if (producto.getNombreProducto().equalsIgnoreCase(productoBuscar)) {
                System.out.println("\nProducto encontrado:\n");
                System.out.println("Nombre: " + producto.getNombreProducto());
                System.out.println("Descripción: " + producto.getDescripcionProducto());
                System.out.println("Precio en bodega: " + producto.getPrecioBodega());
                System.out.println("Precio de venta: " + producto.getPrecioVenta());
                System.out.println("Cantidad: " + producto.getCantidad());
                encontrado = true;
                break;
            }

        }
        if (!encontrado) {
            System.out.println("Producto no encontrado");
        }
    }

    public static void actualizarDato() {

        System.out.println("Producto a actualizar: ");
        String actualizarProducto = scanner.nextLine();

        //Bandera para poder hacer la validación de la existencia del producto
        boolean encontrado = false;

        //Recorremos nuestra linkedlist y actualizamos (set) los datos del producto solo si coincide lo que estamos buscando
        for (EProducto producto : productos) {

            if (producto.getNombreProducto().equalsIgnoreCase(actualizarProducto)) {
                encontrado = true;

                System.out.println("Ingrese el nuevo nombre del producto: ");
                String nuevoNombre = scanner.nextLine();
                producto.setNombreProducto(nuevoNombre);

                System.out.println("Ingrese la nueva descripción del producto: ");
                String nuevaDescripcion = scanner.nextLine();
                producto.setDescripcionProducto(nuevaDescripcion);

                System.out.println("Ingrese el nuevo precio en bodega del producto: ");
                float nuevoPrecioBodega = Float.parseFloat(scanner.nextLine());
                producto.setPrecioBodega(nuevoPrecioBodega);

                System.out.println("Ingrese el nuevo precio de venta del producto: ");
                float nuevoPrecioVenta = Float.parseFloat(scanner.nextLine());
                producto.setPrecioVenta(nuevoPrecioVenta);

                System.out.println("Ingrese la nueva cantidad del producto: ");
                int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                producto.setCantidad(nuevaCantidad);

                System.out.println("Producto actualizado correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }

    }

    public static void eliminarDato() {
        System.out.println("Producto a eliminar: ");
        String eliminarProducto = scanner.nextLine();

        //Bandera para poder hacer la validación de la existencia del producto
        boolean encontrado = false;

        //Recorremos nuestra linkedlist y obtenemos (get) los datos del producto solo si coincide lo que estamos buscando
        for (EProducto producto : productos) {
            if (producto.getNombreProducto().equalsIgnoreCase(eliminarProducto)) {
                System.out.println("\nProducto encontrado:\n");
                System.out.println("Nombre: " + producto.getNombreProducto());
                System.out.println("Descripción: " + producto.getDescripcionProducto());
                System.out.println("Precio en bodega: " + producto.getPrecioBodega());
                System.out.println("Precio de venta: " + producto.getPrecioVenta());
                System.out.println("Cantidad: " + producto.getCantidad());
                encontrado = true;
                //eliminanos el producto
                productos.remove(producto);
                break;
            }

            if (!encontrado) {
                System.out.println("Producto no encontrado");
            }
        }

        System.out.println("\n producto eliminado");

    }

    public static void guardarDatos() {
        // Intentamos escribir en nuestro archivo
        try (FileWriter writer = new FileWriter(archivo)) {
            // Recorremos nuestra linkedlist y obtenemos (get) los datos de cada producto 
            for (EProducto producto : productos) {
                String data = producto.getNombreProducto() + ","
                        + producto.getDescripcionProducto() + ","
                        + producto.getPrecioBodega() + ","
                        + producto.getPrecioVenta() + ","
                        + producto.getCantidad() + "\n";
                // Escribimos en el archivo
                writer.write(data);
            }
            System.out.println("Datos guardados correctamente en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static void cargarDatos() {

        //Intentamos escanear (leer) nuestro archivo
        try (Scanner fileScanner = new Scanner(new File(archivo))) {

            while (fileScanner.hasNextLine()) {
                // Se lee la línea actual y se almacena en la variable dataProducto
                String dataProducto = fileScanner.nextLine();
                // Se verifica que la línea contenga los 5 elementos esperados (nombre, descripción, precio bodega, precio venta y cantidad)
                String[] posicion = dataProducto.split(",");
                // Si tenemos los 5 espacios inicializamos nuestro objeto e insertamos (set) los datos
                if (posicion.length == 5) {
                    EProducto producto = new EProducto();
                    producto.setNombreProducto(posicion[0]);
                    producto.setDescripcionProducto(posicion[1]);
                    producto.setPrecioBodega(Float.parseFloat(posicion[2]));
                    producto.setPrecioVenta(Float.parseFloat(posicion[3]));
                    producto.setCantidad(Integer.parseInt(posicion[4]));

                    //Agregamos el producto a nuestra linkedlist
                    productos.add(producto);
                }
            }
            System.out.println("Datos cargados correctamente desde " + archivo);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo " + archivo);
        }

    }

}
