package Sorts;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + grade;
    }
}

public class GradeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            int flag = Integer.parseInt(sc.nextLine());
            Student[] stus = new Student[n];
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                stus[i] = new Student(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]));
            }

            Arrays.sort(stus, flag == 0 ? (s1, s2) -> s2.getGrade() - s1.getGrade() : (s1, s2) -> s1.getGrade() - s2.getGrade());
            Stream.of(stus).forEach(System.out::println);
        }
    }
}
