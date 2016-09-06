package com.company;

import java.util.List;
import java.util.ArrayList;

public class Sorts {
    private static <T> void swap(T[] arr, int idx1, int idx2) {
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static <T extends Comparable> void gnomeSort(T[] arr) {
        int i = 1;
        while (i < arr.length) {
            if (i == 0)
                i++;
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                swap(arr, i, i - 1);
                i--;
            } else
                i++;
        }
    }

    public static <T extends Comparable> void mergeSort(T[] arr, int left, int right) {
        if (left >= right)
            return;
        int middle = (right + left) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        List<T> tempArr = new ArrayList<T>(right - left + 1);
        int lPartIdx = left, rPartIdx = middle + 1;
        while (lPartIdx <= middle && rPartIdx <= right) {
            if (arr[lPartIdx].compareTo(arr[rPartIdx]) > 0) {
                tempArr.add(arr[rPartIdx]);
                rPartIdx++;
            } else {
                tempArr.add(arr[lPartIdx]);
                lPartIdx++;
            }
        }
        if (lPartIdx <= middle) {
            while (lPartIdx <= middle) {
                tempArr.add(arr[lPartIdx]);
                lPartIdx++;
            }
        }
        if (rPartIdx <= right) {
            while (rPartIdx <= right) {
                tempArr.add(arr[rPartIdx]);
                rPartIdx++;
            }
        }
        for (int i = left; i <= right; i++)
            arr[i] = tempArr.get(i - left);
    }
}
