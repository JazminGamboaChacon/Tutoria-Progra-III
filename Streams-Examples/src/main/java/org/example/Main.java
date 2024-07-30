package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Sumar números pares");
            System.out.println("2. Filtrar cadenas que comienzan con 'A'");
            System.out.println("3. Transformar enteros en sus cuadrados");
            System.out.println("4. Encontrar el valor máximo");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            System.out.println("---------------------------------------------------");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (option) {
                case 1:
                    sumEvenNumbers();
                    break;
                case 2:
                    filterStringsStartingWithA();
                    break;
                case 3:
                    transformIntegersToSquares();
                    break;
                case 4:
                    findMaxValue();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }


    private static void sumEvenNumbers() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("Suma de números pares: " + sum);
    }

    private static void filterStringsStartingWithA() {
        String[] strings = {"Apple", "Banana", "Avocado", "Orange"};
        List<String> filteredStrings = Arrays.stream(strings)
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Cadenas que empiezan con 'A': " + filteredStrings);
    }

    private static void transformIntegersToSquares() {
        int[] numbers = {1, 2, 3, 4, 5};
        List<Integer> squares = Arrays.stream(numbers)
                .map(n -> n * n)
                .boxed()  // Convierte int a Integer para poder usar List
                .collect(Collectors.toList());
        System.out.println("Cuadrados de los números: " + squares);
    }

    private static void findMaxValue() {
        int[] numbers = {1, 5, 3, 8, 2};
        Optional<Integer> max = Arrays.stream(numbers)
                .boxed()  // Convierte IntStream a Stream<Integer>
                .reduce(Integer::max);
        System.out.println("Valor máximo: " + max.orElse(null));
    }

}