package ru.mirea.kabo0222.task1;

public class StudentTest {
    public static void main(String[] args) {
        // Создание массива студентов
        Student[] students = {
                new Student("Даня", "Климаш", 456),
                new Student("Михаил", "Гоч", 123),
                new Student("Лёня", "Матвеев", 789),
        };
        System.out.println("До сортировки:");
        for (Student student : students) {
            System.out.println(student);
        }
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getIDNumber() > key.getIDNumber()) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
        System.out.println("\nПосле сортировки:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student {
    private String firstName;
    private String lastName;
    private int iDNumber;

    public Student(String firstName, String lastName, int iDNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iDNumber = iDNumber;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + iDNumber;
    }
}