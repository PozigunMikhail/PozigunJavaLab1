package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortsTest {
    private static <T extends Comparable> boolean compArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].compareTo((arr2[i])) != 0)
                return false;
        }
        return true;
    }

    private static <T extends Comparable> boolean gnomeSortTest(T[] arr, T[] arrCheckSort) {
        Arrays.sort(arr);
        Sorts.gnomeSort(arrCheckSort);
        return compArrays(arr, arrCheckSort);
    }

    private static <T extends Comparable> boolean mergeSortTest(T[] arr, T[] arrCheckSort) {
        Arrays.sort(arr);
        Sorts.mergeSort(arrCheckSort, 0, arr.length - 1);
        return compArrays(arr, arrCheckSort);
    }

    @Test
    public void gnomeSortTwoElemArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{1, 2});
        arrList.add(new Integer[]{2, 1});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = gnomeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void mergeSortTwoElemArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{1, 2});
        arrList.add(new Integer[]{2, 1});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = mergeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void gnomeSortOneElemArrTest() throws Exception {
        Integer[] arr = {1};
        Integer[] arrCheckSort = new Integer[arr.length];
        System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
        boolean isEqual = gnomeSortTest(arr, arrCheckSort);
        assertEquals(isEqual, true);
    }

    @Test
    public void mergeSortOneElemArrTest() throws Exception {
        Integer[] arr = {1};
        Integer[] arrCheckSort = new Integer[arr.length];
        System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
        boolean isEqual = mergeSortTest(arr, arrCheckSort);
        assertEquals(isEqual, true);
    }

    @Test
    public void gnomeSortEmptyArrTest() throws Exception {
        Integer[] arr = {};
        Integer[] arrCheckSort = new Integer[arr.length];
        System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
        boolean isEqual = gnomeSortTest(arr, arrCheckSort);
        assertEquals(isEqual, true);
    }

    @Test
    public void mergeSortEmptyArrTest() throws Exception {
        Integer[] arr = {};
        Integer[] arrCheckSort = new Integer[arr.length];
        System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
        boolean isEqual = mergeSortTest(arr, arrCheckSort);
        assertEquals(isEqual, true);
    }

    @Test
    public void gnomeSortNotSortedArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{1, 5, 4, 9, 6});
        arrList.add(new Integer[]{2, 8, 3, 1, 7, 8, 4, 0});
        arrList.add(new Integer[]{3, 1, 0, 0, 4, 0});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = gnomeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void mergeSortNotSortedArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{1, 5, 4, 9, 6});
        arrList.add(new Integer[]{2, 8, 3, 1, 7, 8, 4, 0});
        arrList.add(new Integer[]{3, 1, 0, 0, 4, 0});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = mergeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void gnomeSortSortedArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{1, 2, 3, 4, 5});
        arrList.add(new Integer[]{1, 2, 3, 4, 5, 6});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = gnomeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void mergeSortSortedArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{1, 2, 3, 4, 5});
        arrList.add(new Integer[]{1, 2, 3, 4, 5, 6});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = mergeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void gnomeSortReverseSortedArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{7, 6, 5, 4, 3, 2, 1});
        arrList.add(new Integer[]{8, 7, 6, 5, 4, 3, 2, 1});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = gnomeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void mergeSortReverseSortedArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{7, 6, 5, 4, 3, 2, 1});
        arrList.add(new Integer[]{8, 7, 6, 5, 4, 3, 2, 1});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = mergeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void gnomeSortEqElemArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{1, 1, 1, 1, 1, 1});
        arrList.add(new Integer[]{1, 1, 1, 1, 1, 1, 1});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = gnomeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void mergeSortEqElemArrTest() throws Exception {
        List<Integer[]> arrList = new ArrayList<Integer[]>();
        arrList.add(new Integer[]{1, 1, 1, 1, 1, 1});
        arrList.add(new Integer[]{1, 1, 1, 1, 1, 1, 1});
        for (Integer[] arr : arrList) {
            Integer[] arrCheckSort = new Integer[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = mergeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void gnomeSortStringElemTest() throws Exception {
        List<String[]> arrList = new ArrayList<String[]>();
        arrList.add(new String[]{"9", "2", "1", "3", "5", "4", "7", "0"});
        arrList.add(new String[]{"9", "2", "1", "3", "5", "4", "7"});
        for (String[] arr : arrList) {
            String[] arrCheckSort = new String[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = gnomeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }

    @Test
    public void mergeSortStringElemTest() throws Exception {
        List<String[]> arrList = new ArrayList<String[]>();
        arrList.add(new String[]{"9", "2", "1", "3", "5", "4", "7", "0"});
        arrList.add(new String[]{"9", "2", "1", "3", "5", "4", "7"});
        for (String[] arr : arrList) {
            String[] arrCheckSort = new String[arr.length];
            System.arraycopy(arr, 0, arrCheckSort, 0, arr.length);
            boolean isEqual = mergeSortTest(arr, arrCheckSort);
            assertEquals(isEqual, true);
        }
    }
}