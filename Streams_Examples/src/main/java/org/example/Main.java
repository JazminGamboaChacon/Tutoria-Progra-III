package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("____________________Welcome to streams class___________________");
            System.out.println("Select an option:");
            System.out.println("1. Sum of even numbers from 1 to 10");
            System.out.println("2. Strings starting with 'A'");
            System.out.println("3. Squares of numbers");
            System.out.println("4. Maximum value from a list of integers");
            System.out.println("5. Exit");
            System.out.println("___________________________________________1___________________");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sumOfEvenNumbers();
                    break;
                case 2:
                    filterStringsStartingWithA();
                    break;
                case 3:
                    calculateSquares();
                    break;
                case 4:
                    findMaximumValue();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void sumOfEvenNumbers() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("Sum of even numbers from 1 to 10: " + sum);
    }

    private static void filterStringsStartingWithA() {
        String[] strings = {"Apple", "Banana", "Avocado", "Orange"};
        List<String> filteredStrings = Arrays.stream(strings)
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Strings starting with 'A': " + filteredStrings);
    }

    private static void calculateSquares() {
        int[] moreNumbers = {1, 2, 3, 4, 5};
        List<Integer> squares = Arrays.stream(moreNumbers)
                .map(n -> n * n)
                .boxed() // Convert IntStream to Stream<Integer>
                .collect(Collectors.toList());
        System.out.println("Squares of numbers: " + squares);
    }

    private static void findMaximumValue() {
        int[] someNumbers = {1, 5, 3, 8, 2};
        OptionalInt max = Arrays.stream(someNumbers).reduce(Integer::max);
       System.out.println("Maximum value: " + max);
    }
}
