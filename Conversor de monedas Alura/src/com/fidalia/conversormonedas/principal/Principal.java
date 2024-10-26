package com.fidalia.conversormonedas.principal;

import com.fidalia.conversormonedas.calculos.ConvertirMoneda;
import com.fidalia.conversormonedas.modelos.ConversorMenu;
import com.fidalia.conversormonedas.modelos.Moneda;
import com.fidalia.conversormonedas.modelos.MonedaExchance;
import com.fidalia.conversormonedas.servicios.ServicioExchance;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConversorMenu miMenu = new ConversorMenu();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            miMenu.displayConsoleMenu();

            try {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        miMenu.menuCase("Dolar americano", "USD", "ARS");
                        break;
                    case 2:
                        miMenu.menuCase("Peso Argentino", "ARS", "USD");
                        break;
                    case 3:
                        miMenu.menuCase("Dolar americano", "USD", "BRL");
                        break;
                    case 4:
                        miMenu.menuCase("Real Brasilero", "BRL", "USD");

                        break;
                    case 5:
                        miMenu.menuCase("Dolar americano", "USD", "COP");
                        break;
                    case 6:
                        miMenu.menuCase("Peso colombiano", "COP", "USD");
                        break;
                    case 7:
                        continuar = false;
                        System.out.println("¡Gracias por usar el conversor!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
            }


        }
        scanner.close();

    }
}
