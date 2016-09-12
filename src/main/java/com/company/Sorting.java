package com.company;

import java.util.Comparator;

public interface Sorting {
    <T> void sort(T[] arr, Comparator<T> cmp);

    default <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, Comparable::compareTo);
    }
}