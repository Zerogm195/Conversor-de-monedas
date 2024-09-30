package com.alura.conversor.principal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args){

        try {

            Conversor conversor = new Conversor();
            Scanner scanner = new Scanner(System.in);

            double valorDolares = conversor.conversorMonedas().conversion_rates().get("USD");
            double valorPesoColombiano = conversor.conversorMonedas().conversion_rates().get("COP");
            double valorBolivares = conversor.conversorMonedas().conversion_rates().get("VES");
            double valorEuro = conversor.conversorMonedas().conversion_rates().get("EUR");

            System.out.println("\nPor favor ingrese la opcion que desee: ");

            System.out.println("""
                     
                     Opciones de conversion:
                     
                     1. Dolares (USD) => Pesos Colombianos (COP)
                     2. Pesos Colombianos (COP) => Dolares (USD)
                     3. Dolares (USD) => Bolivares (VES)
                     4. Bolivares (VES) => Dolares (USD)
                     5. Dolares (USD) => Euros (EUR)
                     6. Euros (EUR) => Dolares (USD)
                    """);

            int numeroOpcion = scanner.nextInt();

            switch (numeroOpcion) {

                case 1:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double out = scanner.nextDouble();
                    out = out * valorPesoColombiano;
                    System.out.printf("El valor de su conversion es: %.2f" + " COP", out);
                    break;

                case 2:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double out1 = scanner.nextDouble();
                    out1 = (out1 / valorPesoColombiano) / valorDolares;
                    System.out.printf("El valor de su conversion es: %.2f" + " USD", out1);
                    break;

                case 3:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double out2 = scanner.nextDouble();
                    out2 = out2 * valorBolivares;
                    System.out.printf("El valor de su conversion es: %.2f" + "VES", out2);
                    break;

                case 4:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double out3 = scanner.nextDouble();
                    out3 = (out3 / valorBolivares) / valorDolares;
                    System.out.printf("El valor de su conversion es: %.2f" + " USD", out3);
                    break;

                case 5:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double out4 = scanner.nextDouble();
                    out4 = out4 * valorEuro;
                    System.out.printf("El valor de su conversion es: %.2f" + "EUR", out4);
                    break;

                case 6:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double out5 = scanner.nextDouble();
                    out5 = (out5 / valorEuro) / valorDolares;
                    System.out.printf("El valor de su conversion es: %.2f" + " USD", out5);
                    break;

                case 7:
                    System.out.println("Gracias por usar nuestro programa");
                    break;

                default:
                    System.out.println("\nSeleccione una opcion valida");

            }

        } catch (InputMismatchException e){

            System.out.println("Ingrese un valor valido");

        } catch (NullPointerException e){

            System.out.println("No se pudo conectar con la API" + e.getMessage());

        } catch (Exception e){

            System.out.println("Ocurrio un error inesperado, " + e.getMessage());

        }

    }
}
