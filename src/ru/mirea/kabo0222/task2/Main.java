package ru.mirea.kabo0222.task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        // заполнение списка студентов
        studentList.add(new Student("Иванов", 4.5));
        studentList.add(new Student("Петров", 3.8));
        studentList.add(new Student("Сидоров", 4.2));
        studentList.add(new Student("Смирнова", 4.9));

        List<Student> sortedStudentList = quickSort(studentList, 0, studentList.size() - 1);

        System.out.println("Отсортированный список студентов по итоговым баллам (в порядке убывания):");
        for (Student student : sortedStudentList) {
            System.out.println(student.getName() + ", " + student.getGPA());
        }
    }

    public static List<Student> quickSort(List<Student> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
        return list;
    }

    public static int partition(List<Student> list, int low, int high) {
        Student pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).getGPA() >= pivot.getGPA()) {
                i++;

                Student temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        Student temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }
}
