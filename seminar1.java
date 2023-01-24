// Написать программу вычисления n-ого треугольного числа.

import java.util.Scanner;

public class seminar1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число: ");
        boolean flag = iScanner.hasNextInt();
        System.out.println(flag);
        int i = iScanner.nextInt();
        System.out.println(i);
        iScanner.close();
        System.out.println("Результат вычисления треугольного числа: " + triangle(i));
    }


    static int triangle(int n) {
        return (n * (n + 1)) / 2;
        }
    
}

        

