/**
 * Java 1. Homework 3
 *
 * @author Pavel Ermilov
 * @version 13.12.2021 - 14.12.2021
 */
 import java.util.Arrays;
 
class HomeWork3 {
    public static void main(String[] args) {
        replaceNumbers();
        fillArray();
        changeArray();
        fillDiagonal();
        System.out.println(Arrays.toString(returnLenArr(7, 5)));
    }

    static void replaceNumbers() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0)? 1 : 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void changeArray() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void fillDiagonal() {
        int [][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            arr[i][i] = 1;
            arr[i][4 - i - 1] = 1;
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static int[] returnLenArr(int len, int initialValue) {
        int arr[] = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}