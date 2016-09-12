package com.company;

import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortsTest {
    private static <T extends Comparable<T>> boolean checkArrSort(T[] arr, T[] arrNotSorted) {
        return checkArrSort(arr, arrNotSorted, Comparable::compareTo);
    }

    private static <T> boolean checkArrSort(T[] arr, T[] arrNotSorted, Comparator<T> cmp) {

        for (int i = 1; i < arr.length; i++) {
            if (cmp.compare(arr[i], arr[i - 1]) < 0) {
                return false;
            }
        }
        if (arr.length != arrNotSorted.length) {
            return false;
        }
        for (T arrElem : arr) {
            int sameElemCount = 0;
            for (T arrElem1 : arr) {
                if (cmp.compare(arrElem, arrElem1) == 0) {
                    sameElemCount++;
                }
            }
            for (T arrNotSortedElem : arrNotSorted) {
                if (cmp.compare(arrElem, arrNotSortedElem) == 0) {
                    sameElemCount--;
                }
            }
            if (sameElemCount != 0) {
                return false;
            }
        }
        return true;
    }

    private static void randomIntegersArr(Integer[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
    }

    private static boolean sortIntegersTest(Integer[] arr, Sorting sortAlg) {
        Integer[] arrNotSorted = new Integer[arr.length];
        System.arraycopy(arr, 0, arrNotSorted, 0, arr.length);
        sortAlg.sort(arr);
        return checkArrSort(arr, arrNotSorted);
    }

    @Test
    public void gnomeSortTwoElemArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{2, 1}, Sorts::gnomeSort));
    }

    @Test
    public void mergeSortTwoElemArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{2, 1}, Sorts::mergeSort));
    }

    @Test
    public void gnomeSortOneElemArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{1}, Sorts::gnomeSort));
    }

    @Test
    public void mergeSortOneElemArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{1}, Sorts::mergeSort));
    }

    @Test
    public void gnomeSortEmptyArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{}, Sorts::gnomeSort));
    }

    @Test
    public void mergeSortEmptyArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{}, Sorts::mergeSort));
    }

    @Test
    public void gnomeSortSortedArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Sorts::gnomeSort));
        assertTrue(sortIntegersTest(new Integer[]{1, 2, 3, 4, 5, 6, 7}, Sorts::gnomeSort));
    }

    @Test
    public void mergeSortSortedArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Sorts::mergeSort));
        assertTrue(sortIntegersTest(new Integer[]{1, 2, 3, 4, 5, 6, 7}, Sorts::mergeSort));
    }

    @Test
    public void gnomeSortReverseSortedArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, Sorts::gnomeSort));
        assertTrue(sortIntegersTest(new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, Sorts::gnomeSort));
    }

    @Test
    public void mergeSortReverseSortedArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, Sorts::mergeSort));
        assertTrue(sortIntegersTest(new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, Sorts::mergeSort));
    }

    @Test
    public void gnomeSortSameElemArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{1, 1, 1, 1, 1, 1}, Sorts::gnomeSort));
        assertTrue(sortIntegersTest(new Integer[]{1, 1, 1, 1, 1, 1, 1}, Sorts::gnomeSort));
    }

    @Test
    public void mergeSortSameElemArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{1, 1, 1, 1, 1, 1}, Sorts::mergeSort));
        assertTrue(sortIntegersTest(new Integer[]{1, 1, 1, 1, 1, 1, 1}, Sorts::mergeSort));
    }

    @Test
    public void gnomeSortDiffSizesTest() throws Exception {
        for (int i = 0; i < 12; i++) {
            Integer[] arrEvenLen = new Integer[2 * i];
            randomIntegersArr(arrEvenLen);
            assertTrue(sortIntegersTest(arrEvenLen, Sorts::gnomeSort));
            Integer[] arrOddLen = new Integer[2 * i + 1];
            randomIntegersArr(arrOddLen);
            assertTrue(sortIntegersTest(arrOddLen, Sorts::gnomeSort));
        }
    }

    @Test
    public void mergeSortDiffSizesTest() throws Exception {
        for (int i = 0; i < 12; i++) {
            Integer[] arrEvenLen = new Integer[2 * i];
            randomIntegersArr(arrEvenLen);
            assertTrue(sortIntegersTest(arrEvenLen, Sorts::mergeSort));
            Integer[] arrOddLen = new Integer[2 * i + 1];
            randomIntegersArr(arrOddLen);
            assertTrue(sortIntegersTest(arrOddLen, Sorts::mergeSort));
        }
    }

    @Test
    public void gnomeSortNotSortedArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{1, 9, 8, 1, 0, 0, 2, 3}, Sorts::gnomeSort));
        assertTrue(sortIntegersTest(new Integer[]{2, 1, 0, 0, 0, 1, 1, 2, 0, 2, 1}, Sorts::gnomeSort));
        assertTrue(sortIntegersTest(new Integer[]{9, 8, 1, 0, 4, 6, 2, 8, 0}, Sorts::gnomeSort));
    }

    @Test
    public void mergeSortNotSortedArrTest() throws Exception {
        assertTrue(sortIntegersTest(new Integer[]{1, 9, 8, 1, 0, 0, 2, 3}, Sorts::mergeSort));
        assertTrue(sortIntegersTest(new Integer[]{2, 1, 0, 0, 0, 1, 1, 2, 0, 2, 1}, Sorts::mergeSort));
        assertTrue(sortIntegersTest(new Integer[]{9, 8, 1, 0, 4, 6, 2, 8, 0}, Sorts::mergeSort));
    }
}