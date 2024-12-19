package org.dyalex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.dyalex.Arrays.binarySearch;
import static org.dyalex.Collections.binarySearch;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Charlie", 35));
        people.add(new Person("Bob", 25));
        // Сортировка списка по имени
        people.sort(new NameComparator());
        // Объект для поиска
        Person searchPerson = new Person("Bob", 0); // Возраст не имеет значения для сравнения по имени
        // Выполнение бинарного поиска
        int index = binarySearch(people, searchPerson, new NameComparator());
        if (index >= 0) {
            System.out.println("Person found at index: " + index);
            System.out.println("Found person: " + people.get(index).getName());
        } else {
            System.out.println("Person not found");
        }

        System.out.println("Positive case for byte array: " + testByteArray());
        System.out.println("Negative case for byte array with range: " + testByteArrayWithRange());

        System.out.println("Positive case for char array: " + testCharArray());
        System.out.println("Negative case for char array with range: " + testCharArrayWithRange());

        System.out.println("Positive case for double array: " + testDoubleArray());
        System.out.println("Negative case for double array with range: " + testDoubleArrayWithRange());

        System.out.println("Positive case for float array: " + testFloatArray());
        System.out.println("Negative case for float array with range: " + testFloatArrayWithRange());

        System.out.println("Positive case for int array: " + testIntArray());
        System.out.println("Negative case for int array with range: " + testIntArrayWithRange());

        System.out.println("Positive case for long array: " + testLongArray());
        System.out.println("Negative case for long array with range: " + testLongArrayWithRange());

        System.out.println("Positive case for short array: " + testShortArray());
        System.out.println("Negative case for short array with range: " + testShortArrayWithRange());

        int[] test = {9, 8, 7, 6, 5};
        System.out.println("Negative case for range check. Should throw ArrayIndexOutOfBoundsException "
                + binarySearch(test, -1, 7, 7));
    }

    private static String testByteArray() {
        byte[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, (byte)7);

        return checkResult(index);
    }

    private static String testByteArrayWithRange() {
        byte[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, 2, 6, (byte)7);

        return checkResult(index);
    }

    private static String testCharArray() {
        char[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, (char)7);

        return checkResult(index);
    }

    private static String testCharArrayWithRange() {
        char[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, 2, 6, (char)7);

        return checkResult(index);
    }

    private static String testDoubleArray() {
        double[] arr = {0.1, 1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.0};
        int index = binarySearch(arr, 7);

        return checkResult(index);
    }

    private static String testDoubleArrayWithRange() {
        double[] arr = {0.1, 1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.0};
        int index = binarySearch(arr, 2, 6, 7.0);

        return checkResult(index);
    }

    private static String testFloatArray() {
        float[] arr = {0.1f, 1.2f, 2.3f, 3.4f, 4.5f, 5.6f, 6.7f, 7.0f};
        int index = binarySearch(arr, 7.0f);

        return checkResult(index);
    }

    private static String testFloatArrayWithRange() {
        float[] arr = {0.1f, 1.2f, 2.3f, 3.4f, 4.5f, 5.6f, 6.7f, 7.0f};
        int index = binarySearch(arr, 2, 6, 7.0f);

        return checkResult(index);
    }

    private static String testIntArray() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, 7);

        return checkResult(index);
    }

    private static String testIntArrayWithRange() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, 2, 6, 7);

        return checkResult(index);
    }

    private static String testLongArray() {
        long[] arr = {0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L};
        int index = binarySearch(arr, 7L);

        return checkResult(index);
    }

    private static String testLongArrayWithRange() {
        long[] arr = {0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L};
        int index = binarySearch(arr, 2, 6, 7L);

        return checkResult(index);
    }

    private static String testShortArray() {
        short[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, (short)7);

        return checkResult(index);
    }

    private static String testShortArrayWithRange() {
        short[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, 2, 6, (short)7);

        return checkResult(index);
    }

    private static String checkResult(int index) {
        if (index >= 0) {
            return "Number found at index: " + index;
        } else {
            return "Number not found";
        }
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ". Age: " + this.age;
    }
}
