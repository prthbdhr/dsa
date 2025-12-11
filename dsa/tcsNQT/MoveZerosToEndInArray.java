package dsa.tcsNQT;

import java.util.Scanner;

public class MoveZerosToEndInArray {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        moveZerosToEnd(arr);

        for (int num : arr) System.out.print(num + " ");
    }

    private static void moveZerosToEnd(int[] arr) {

        int i = 0;
        int j = 0;

        while (j < arr.length) {

            if (arr[j] != 0) arr[i++] = arr[j];

            j++;
        }

        while (i < arr.length) arr[i++] = 0;
    }
}
