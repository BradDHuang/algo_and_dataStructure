package com.company;

import java.util.Arrays;

import java.util.Comparator;
// java 自带！

public class Main {

    // 例：自己写排序函数
    // 缺点：
    // 多了会造成代码冗余，而且，工作量巨大。
//    private static void selectionSortStudentScoreAsc(Student[] students) {
//        for (int i = 0; i < students.length - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < students.length; j++) {
//                if (students[j].score < students[min].score) {
//                    min = j;
//                }
//            }
//            Student t = students[min];
//            students[min] = students[i];
//            students[i] = t;
//        }
//    }

//    private static void selectionSortStudent(Student[] students, Comparator<Student> comparator) {
//    private static <T> void selectionSort(T[] array, Comparator<T> comparator) {
//        for (int i = 0; i < array.length - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < array.length; j++) {
////                if (array[j].score < array[min].score) {
//                if (comparator.compare(array[j], array[min]) < 0) {
//                    min = j;
//                }
//            }
//            T t = array[min];
//            array[min] = array[i];
//            array[i] = t;
//        }
//    }

    public static void main(String[] args) {
        // write your code here

        Student[] students = new Student[6];
        students[0] = new Student("Adam", 90);
        students[1] = new Student("Brad", 80);
        students[2] = new Student("Cindy", 95);
        students[3] = new Student("Dd", 70);
        students[4] = new Student("Ad", 92);
        students[5] = new Student("Ed", 93);

        System.out.println(Arrays.toString(students));
//        Arrays.sort(students);

        Arrays.sort(students, new StudentScoreAscComparator());

        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new StudentScoreDescComparator());
        System.out.println(Arrays.toString(students));
        // java.lang.ClassCastException: com.company.
        // Student cannot be cast to java.lang.Comparable

//        selectionSortStudent(students);
//        selectionSortStudent(students, new StudentComparator());
//        System.out.println(Arrays.toString(students));

//        selectionSort(students, new StudentScoreDescComparator());
//        System.out.println(Arrays.toString(students));

//        selectionSort(students, new StudentScoreAscComparator());
//        System.out.println(Arrays.toString(students));

    }
}

class Student {
    String name;
    int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}

//abstract class StudentComparator {
//    abstract int compare(Student s1, Student s2);
////        return s1.score - s2.score;
//        // s1.score 小 return 负数
//}
//// 抽象类不需要实现

//interface StudentComparator {
//    int compare(Student s1, Student s2);
//}
//// interface 相较于 abstract class 更clean.

//interface Comparator {
//    int compare(Student s1, Student s2);
//}
//interface Comparator<T> {
//    int compare(T s1, T s2);
//}

//class StudentScoreDescComparator extends StudentComparator {
//class StudentScoreDescComparator implements Comparator {
class StudentScoreDescComparator implements Comparator<Student> {
    @Override
//    int compare(Student s1, Student s2) {
//    public int compare(Student s1, Student s2) {
    public int compare(Student o1, Student o2) {
        return o2.score - o1.score; // 需要引入泛型
        // o2.score 小 return 负数
    }
}

class StudentScoreAscComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.score - o2.score; // 需要引入泛型
    }
}