/**
 * Java 1. Homework 2
 *
 * @author Pavel Ermilov
 * @version 12.12.2021
 */
class HomeWork2 {
    public static void main(String[]args) {
        System.out.println(within10to20(7, 7));
        System.out.println(isPositiveOrNegative(7));
        System.out.println(isNegative(7));
        printWordTimes("word", 5);
    }

    static boolean within10to20(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    static String isPositiveOrNegative(int a) {
        return a >= 0 ? "Number is positive" : "Number is negative";
    }

    static boolean isNegative(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    static void printWordTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }
}