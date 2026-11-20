package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 1: Gestión de un Gimnasio.
 * 
 * @author Zafra Vallejo, Ana.
 */
public class Ejercicio01 {

        public static void main(String[] args) {

            // -------------------------
            // DECLARACIÓN DE VARIABLES
            // -------------------------

            // Declaracion de Constantes
            final double PRECIO_FITNESS = 10.0; // Precio del a actividad de Fitness sin IVA
            final double PRECIO_YOGA = 15.0;    // Precio de la actividad de Yoga sin IVA
            final double PRECIO_MENSUAL = 20.0; // Precio de la mensualidad sin IVA

            // Variables de Entrada        
            String opcion;  // opción del menú

            // Variables de Salida  
            String cadenaResultado;  // Almacena la cadena resultado a presentar como salida de resultados en la opción de menú 1.
            double resultadoOferta;
            double resultadoVentas;

            //Variables Auxiliares
            Scanner teclado = new Scanner(System.in);  // Objeto Scanner para leer por teclado.
            int iva;
            double resultadoPVP;        // almacena los resultados parciales del precio con iva de cada matricula.
            int tipoMatricula;          // almacena el número del tipo de matricula a la que aplicar el descuento.
            double descuento;           // porcentaje de descuento a aplicar en la opción 2 de menú.
            int cantidadVendida;        // almacena la cantidad de matriculas realizadas de un determinado tipo.
            double precioBase;          // almacena el precio sin iva de un tipo de matrícula.
            
            System.out.println("EJERCICIO 1: GESTIÓN DE UN GIMNASIO");
            System.out.println("-----------------------------------"); 
            
            System.out.println("TIPOS DE MATRICULAS: 1. FITNESS - 2. YOGA - 3. MUSCULACIÓN");
            System.out.println("Precio de la matrícula tipo 1 (FITNESS): " + PRECIO_FITNESS +"€");
            System.out.println("Precio de la matrícula tipo 2 (YOGA): " + PRECIO_YOGA +"€");
            System.out.println("Precio de la matrícula tipo 3 (MUSCULACIÓN): " + PRECIO_MENSUAL +"€");

            do {
                System.out.println("\n--- MENÚ DE OPERACIONES ---");
                System.out.println("1. Calcular PVP de cada matricula.");
                System.out.println("2. Aplicar oferta a un tipo de matricula (sin iva).");
                System.out.println("3. Calcular el importe total de matriculas realizadas (sin iva).");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = teclado.next();

                switch (opcion) {
                    case "1":   // Opción 1: Calculamos los precios con iva de cada tipo de matrícula.  
                        cadenaResultado="";
                        for (int i = 1; i <= 3; i++) {
                            // ----------------
                            // ENTRADA DE DATOS
                            // ----------------
                            System.out.print("Ingrese el IVA para el tipo de matrícula " + i + " (4 - 10 - 21): ");
                            iva = teclado.nextInt();

                            // --------------
                            // PROCESAMIENTO
                            // --------------                        
                            switch (i) {
                                case 1:
                                    resultadoPVP = PRECIO_FITNESS + (PRECIO_FITNESS * iva / 100);
                                    cadenaResultado = cadenaResultado + "El PVP de la actividad de Fitness es: " + resultadoPVP + "€\n";                                
                                    break;
                                case 2:
                                    resultadoPVP = PRECIO_YOGA + (PRECIO_YOGA * iva / 100);
                                    cadenaResultado = cadenaResultado + "El PVP de la actividad de Yoga es: " + resultadoPVP + "€\n";
                                    break;
                                case 3:
                                    resultadoPVP = PRECIO_MENSUAL + (PRECIO_MENSUAL * iva / 100);
                                    cadenaResultado = cadenaResultado + "El PVP de la actividad de Musculación es: " + resultadoPVP + "€\n";
                                    break;
                            }                        
                        }
                        // --------------------
                        // SALIDA DE RESULTADOS
                        // --------------------
                        System.out.println(cadenaResultado);
                        break;

                    case "2":    // Opción 2: Aplicamos descuento al tipo de matrícula elegido.                       
                        // ----------------
                        // ENTRADA DE DATOS
                        // ----------------
                        System.out.println("Seleccione tipo de matrícula (1. Fitness, 2. Yoga o 3. Musculación): ");
                        tipoMatricula = teclado.nextInt();
                        System.out.print("Ingrese el % de descuento a aplicar: ");
                        descuento = teclado.nextDouble();

                        // --------------
                        // PROCESAMIENTO
                        // --------------  
                        precioBase=0.0;
                        switch (tipoMatricula) {
                            case 1:
                                precioBase = PRECIO_FITNESS;
                                break;
                            case 2:
                                precioBase = PRECIO_YOGA;
                                break;
                            case 3:
                                precioBase = PRECIO_MENSUAL;
                                break;                                                          
                        }

                        if (precioBase != 0.0){
                            resultadoOferta = precioBase - (precioBase * descuento / 100);

                            // --------------------
                            // SALIDA DE RESULTADOS
                            // --------------------
                            System.out.println("El precio final (sin iva) con descuento para el tipo de matrícula " + tipoMatricula + " es: " + resultadoOferta + "€");
                        } else {
                            System.out.println("El tipo de matrícula indicado no existe.");
                        }
                        break;

                    case "3": // Opción 3: Calculamos el total de una venta.                        
                        resultadoVentas = 0.0;
                        for (int i = 1; i <= 3; i++) {
                            // ----------------
                            // ENTRADA DE DATOS
                            // ----------------
                            System.out.print("Ingrese las matrículas realizadas para el tipo de matrícula " + i + " (1. Fitness, 2. Yoga o 3. Musculación): ");
                            cantidadVendida = teclado.nextInt();

                            // --------------
                            // PROCESAMIENTO
                            // --------------  
                            precioBase=0.0;
                            switch (i) {
                                case 1:
                                    precioBase = PRECIO_FITNESS;
                                    break;
                                case 2:
                                    precioBase = PRECIO_YOGA;
                                    break;
                                case 3:
                                    precioBase = PRECIO_MENSUAL;
                                    break;                                                   
                            }
                            resultadoVentas = resultadoVentas + (precioBase * cantidadVendida);
                        }

                        // --------------------
                        // SALIDA DE RESULTADOS
                        // --------------------
                        System.out.println("El importe total (sin iva) de las matrículas realizadas es: " + resultadoVentas + "€");                    
                        break;

                    case "4":
                        System.out.println("Saliendo del programa...");                        
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (!opcion.equals("4"));  //Mientras la opción de menú elegida no sea "4", se vuelve a mostrar el menú de opciones.
        }
}