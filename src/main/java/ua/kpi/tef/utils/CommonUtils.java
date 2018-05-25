package ua.kpi.tef.utils;

import java.util.Scanner;

public class CommonUtils {
    public static int inputIntegerWithScanner(Scanner scanner) {
        System.out.println("input number");
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
