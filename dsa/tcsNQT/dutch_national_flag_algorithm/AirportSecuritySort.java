package dsa.tcsNQT.dutch_national_flag_algorithm;

import java.util.Scanner;

public class AirportSecuritySort {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        sc.close();
        
        sortRiskItems(arr);
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sortRiskItems(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            switch (arr[mid]) {
                case 0:
                    // swap arr[low] and arr[mid]
                    swap(arr, low, mid);
                    low++;
                    mid++;  
                    break;

                case 1:
                    mid++;
                    break;      

                case 2:
                    // swap arr[mid] and arr[high]
                    swap(arr, mid, high);
                    high--;
                    break;
            
                default:
                    break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
