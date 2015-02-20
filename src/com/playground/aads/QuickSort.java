package com.playground.aads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * User: liviu
 * Date: 5/22/14
 * Time: 10:59 PM
 */
public class QuickSort {

    public int count = 0;

    public boolean sort(int[] a) {
        sort(a, 0, a.length - 1);
        return true;
    }

    private void sort(int[] a, int start, int end) {
        if (start >= end) return;

        int mid = partition(a, start, end);
        sort(a, start, mid - 1);
        sort(a, mid + 1, end);
    }

    public int partition(int[] a, int start, int end) {
        count(start, end);
        int k = start + 1;
        for (int j = start + 1; j <= end; j++) {
            if (a[start] > a[j]) {//pivot is larger
                swap(a, j, k);
                k++;
            }
        }
        swap(a, start, k - 1);
        return k - 1;
    }

    private void count(int start, int end) {
        int tmpCnt = end - start;
        if (tmpCnt <= 0) {
            System.out.println(tmpCnt);
        }
        count = count + tmpCnt;
    }

    private int selectPivot(int[] a, int start, int end) {
        int middle = start +( (end - start) / 2);
        if(middle < 0){
            System.out.println("wtf");
        }
        int []aux = new int[]{a[start], a[middle], a[end]};
        Arrays.sort(aux);  //stupid way of doing middle
        if(aux[1]== a[start]){
            return start;
        }
        if(aux[1]== a[middle]){
            return middle;
        }
        return end;
    }

    private void swap(int[] a, int j, int k) {
        int aux = a[j];
        a[j] = a[k];
        a[k] = aux;
    }

    public static void main(String... args) throws IOException {
        List<String> data = Files.readAllLines(Paths.get("d:\\QuickSort.txt"), StandardCharsets.UTF_8);
        int a[] = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            a[i] = Integer.parseInt(data.get(i));
        }
        System.out.println(new QuickSort().sort(a));
        System.out.println(Arrays.toString(a));
//        System.out.println(count);

    }
}
