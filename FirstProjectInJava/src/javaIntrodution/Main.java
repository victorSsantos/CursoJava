package javaIntrodution;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        int n1 = 89;
//        int n2 = 60;
//
//        compare(n1,n2);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter three numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        showResult(max(a, b, c));
    }

    public static void compare(int n1 , int n2) {
        System.out.println(n1 & n2);
        System.out.println(n1 | n2);
        System.out.println(n1 ^ n2);
    }

    public static int max( int a, int b, int c ) {
        int aux;
        if (a > b && a > c ) {
            aux = a;
        } else if (b > c ){
            aux = b;
        } else {
            aux = c;
        }
        return aux;
    }

    public static void showResult(int higher) {
        System.out.println("Higher = " + higher);
    }
}