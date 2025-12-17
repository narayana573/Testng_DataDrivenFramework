package Pratice_2026;

public class TernaryLogic {

    public static void main(String[] args) {


        // Find the largest of three numbers using the ternary operator ? :
        int a = 10;
        int b = 200;
        int c = 30;

        int largest = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);

        System.out.println("The largest number is: " + largest);
    }
}
