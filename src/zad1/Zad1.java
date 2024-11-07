package zad1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *   Polecenie: Zaimplementuj program, który przyjmuje od użytkownika ciąg liczb i
 *   przechowuje je w zbiorze typu HashSet i TreeSet. Następnie wyświetl różnice
 *   między HashSet a TreeSet w kontekście kolejności elementów.
 *
 *   Autor: Marceli Gawlik
 *   Data: Listopad 2024
 */

public class Zad1 {
    public static void main(String[] args) {
        // utworzenie obiektu aplikacji
        // uruchomienie głównej pętli aplikacji.
        Zad1 application = new Zad1();
        application.runMainLoop();
    }

    public void runMainLoop() {
        Scanner scanner = new Scanner(System.in);

        // Zbiory do przechowywania liczb
        Set<Integer> numbersHashSet = new HashSet<>();
        Set<Integer> numbersTreeSet = new TreeSet<>();

        // Pobranie danych od użytkownika
        System.out.println("Podaj ciąg liczb oddzielonych spacją: ");
        String userInput = scanner.nextLine();
        String[] userNumbers = userInput.split(" ");

        // Przetwarzanie wprowadzonych liczb
        for (String userNum : userNumbers) {
            try {
                int num = Integer.parseInt(userNum);
                numbersHashSet.add(num);
                numbersTreeSet.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy format danych: " + userNum);
            }
        }

        // Wyświetlenie wyników
        System.out.println("HashSet: \n" + numbersHashSet);
        System.out.println("TreeSet: \n" + numbersTreeSet);

        // Różnica między HashSet a TreeSet
        System.out.println("\nRóżnice między HashSet a TreeSet:");
        System.out.println("- HashSet nie zachowuje kolejności elementów.");
        System.out.println("- TreeSet przechowuje elementy w kolejności rosnącej.");

        scanner.close();
    }
}
