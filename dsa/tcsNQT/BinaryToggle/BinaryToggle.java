package dsa.tcsNQT.BinaryToggle;

import java.util.Scanner;

public class BinaryToggle {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String binary = new String();

        while (n > 0) {

          binary = (n & 1) + binary;

            n = n >> 1;
        }

        binary = binary.replaceAll("1", "2");
        binary = binary.replaceAll("0", "1");
        binary = binary.replaceAll("2", "0");

        System.out.println(Integer.parseInt(binary, 2));

    }
}
