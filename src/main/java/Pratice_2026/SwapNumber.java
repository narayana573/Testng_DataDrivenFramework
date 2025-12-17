package Pratice_2026;

public class SwapNumber {

    public static void main(String[] args) {

        //Swap two numbers without using a third variable.

        int a = 100;
        int b = 200;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("A value is:" + a);
        System.out.println("B value is:" + b);

    }
}
