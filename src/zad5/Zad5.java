package zad5;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 *   Stwórz listę obiektów reprezentujących osoby, gdzie każda osoba ma imię i wiek.
 *   Napisz komparator, który sortuje tę listę na podstawie wieku.
 *   Następnie posortuj listę za pomocą komparatora i wyświetl wynik.
 *
 *   Autor: Marceli Gawlik
 *   Data: Listopad 2024
 */

class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class Zad5 {
    public static void main(String[] args) {
        // Tworzenie listy obiektów Person
        List<Person> people = new ArrayList<>();
        // Wczytywanie danych z pliku
        loadPeopleFromFile("src/zad5/Person.txt", people);
        // Komparator sortujący osoby na podstawie wieku
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        // Sortowanie listy za pomocą komparatora
        people.sort(ageComparator);
        // Wyświetlenie posortowanej listy
        System.out.println("Lista osób posortowana według wieku:");
        people.forEach(System.out::println);
    }

    // Metoda wczytująca dane z pliku
    public static void loadPeopleFromFile(String filePath, List<Person> people) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Rozdzielanie danych z linii po przecinku
                String[] data = line.split(",");
                if (data.length == 2) {
                    String name = data[0].trim();
                    int age = Integer.parseInt(data[1].trim());
                    people.add(new Person(name, age));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Błąd podczas wczytywania pliku: " + e.getMessage());
        }
    }
}
