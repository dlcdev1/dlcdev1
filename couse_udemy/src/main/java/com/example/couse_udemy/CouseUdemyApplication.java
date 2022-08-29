package com.example.couse_udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CouseUdemyApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CouseUdemyApplication.class, args);

        Scanner sc = new Scanner(System.in);
        String string1 = sc.nextLine();
        String string2 = sc.nextLine();
        String string3 = sc.nextLine();

        validateInput1(string1);
        validateInput2(string2);
        validateInput3(string3);

        sc.close();

    }

    private static String validateQuantityNumbers(String stringNumber) {
        if (stringNumber.length() == 1) {
            stringNumber = "00" + stringNumber;
        } else if (stringNumber.length() == 2) {
            stringNumber = "0" + stringNumber;
        }

        return stringNumber;
    }

    private static void validateInput3(String string3) {
        String newString = string3.replaceAll("\\d+$", "").strip();
        String newNumber = string3.replaceAll("[a-zA-Z]", "").strip();

        newNumber = validateQuantityNumbers(newNumber);

        System.out.println(newString + String.format("%15.15s", newNumber));
    }

    private static void validateInput2(String string2) {
        String newString = string2.replaceAll("\\d+$", "").strip();
        String newNumber = string2.replaceAll("[a-zA-Z]", "").strip();

        newNumber = validateQuantityNumbers(newNumber);

        System.out.println(newString + String.format("%15.15s", newNumber));
    }

    private static void validateInput1(String string1) {
        String newString = string1.replaceAll("\\d+$", "").strip();
        String newNumber = string1.replaceAll("[a-zA-Z]", "").strip();

        newNumber = validateQuantityNumbers(newNumber);

        System.out.println(newString + String.format("%15.15s", newNumber));
    }


}
