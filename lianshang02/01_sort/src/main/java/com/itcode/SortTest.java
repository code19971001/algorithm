package com.itcode;

import com.itcode.bean.Student;
import com.itcode.sorts.*;
import com.itcode.tools.Asserts;
import com.itcode.tools.Integers;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SortTest {


    public static void main(String[] args) {
        System.out.println("---------------test integer-------------------");
        Integer[] random = Integers.random(10000, 1, 1000000);
        testSort(random, new BubbleSort1<Integer>(), new BubbleSort2<Integer>(),
                new BubbleSort3<Integer>(), new SelectionSort<Integer>(),
                new HeapSort<Integer>(), new InsertionSort1(),
                new InsertionSort2());
//        System.out.println("---------------test student-------------------");
//        Student[] students = {new Student(90, 18), new Student(80, 21), new Student(100, 16)};
//        testSort(students, new BubbleSort3<Student>(), new SelectionSort<Student>(), new HeapSort<Student>());
    }

    static void testSort(Integer[] arr, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] data = Arrays.copyOf(arr, arr.length);
            sort.sort(data);
            //System.out.println(Arrays.toString(data));
            Asserts.test(Integers.isAscOrder(data));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }


    static void testSort(Student[] arr, Sort... sorts) {
        for (Sort sort : sorts) {
            Student[] students = Arrays.copyOf(arr, arr.length);
            sort.sort(students);
            System.out.println(Arrays.toString(students));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
