package zad3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *   Stwórz aplikację, która umożliwia użytkownikowi przechowywanie par klucz-wartość
 *   w mapie typu HashMap i TreeMap. Po dodaniu kilku elementów, zwróć uwagę na różnice
 *   w kolejności kluczy w obu mapach.
 *
 *   Autor: Marceli Gawlik
 *   Data: Listopad 2024
 */

public class Zad3{
    private final Map<String, String> hashMap;
    private final Map<String, String> treeMap;

    public Zad3() {
        this.hashMap = new HashMap<>();
        this.treeMap = new TreeMap<>();
    }

    public static void main(String[] args) {
        zad3.Zad3 app = new zad3.Zad3();
        app.showMenu();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Zadanie 2 ---");
            System.out.println("1. Dodaj pare wartość-klucz");
            System.out.println("2. Wyświetl HashMap");
            System.out.println("3. Wyświetl TreeMap");
            System.out.println("4. Wyświetl obie mapy");
            System.out.println("5. Zakończ program");
            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addKeyValuePair(scanner);
                case 2 -> displayMap("HashMap", hashMap);
                case 3 -> displayMap("TreeMap", treeMap);
                case 4 -> displayMaps();
                case 5 -> {
                    System.out.println("Koniec programu...");
                    running = false;
                }
                default -> System.out.println("Nieznana opcja. Spróbuj wpisać ponownie");
            }
        }

        scanner.close();
    }

    private void addKeyValuePair(Scanner scanner) {
        System.out.print("Napisz klucz: ");
        String key = scanner.nextLine();
        System.out.print("Napisz wartość: ");
        String value = scanner.nextLine();

        if (hashMap.containsKey(key) || treeMap.containsKey(key)) {
            System.out.println("Błąd: Klucz '" + key + "' już istnieje w jednej z map!");
        } else {
            hashMap.put(key, value);
            treeMap.put(key, value);
            System.out.println("Para klucz-wartość dodana do HashMap i TreeMap!");
        }
    }

    private void displayMap(String mapType, Map<String, String> map) {
        System.out.println("\n--- " + mapType + "---");
        map.forEach((key, value) -> System.out.println("Klucz: " + key + ", Wartość: " + value));
    }

    private void displayMaps() {
        System.out.println("\n--- HashMap ---");
        hashMap.forEach((key, value) -> System.out.println("Klucz: " + key + ", Wartość: " + value));

        System.out.println("\n--- TreeMap ---");
        treeMap.forEach((key, value) -> System.out.println("Klucz: " + key + ", Wartość: " + value));
    }
}
