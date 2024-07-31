package com.itcode.sorts;

import java.util.ArrayList;
import java.util.List;

/**
 * 希尔排序, 也被成为递减增量排序: 将序列看作一个矩阵，分为M列，逐列进行排序。M从某个整数逐渐减为1时, 整个序列完全有序。
 * 希尔本人给出的步长序列为n/2^k. 比如步长为16时, 步长序列为(1,2,4,8). 本质是逐渐减少逆序对. 通常与插入排序一块使用.
 */
public class ShellSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        List<Integer> stepList = initStepSeq();
        System.out.println(stepList);
        for (Integer step : stepList) {
            sort(step);
        }
    }


//    public static void main(String[] args) {
//        ShellSort<Integer> integerShellSort = new ShellSort<>();
//        integerShellSort.sort(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
//        System.out.println(Arrays.toString(integerShellSort.arr));
//    }

    /**
     * 分成多少列及逆行排序
     */
    private void sort(int step) {
        for (int col = 0; col < step; col++) {
            //对第col列进行排序: 实际上使用插入排序对第n列进行处理.
            for (int row = 1; row * step + col < arr.length; row++) {
                int cur = row * step + col;
                //注意这里的判断条件：第一排元素肯定是col, 为了避免越界, cur > col
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }

    }

    private List<Integer> initStepSeq() {
        List<Integer> stepList = new ArrayList<>();
        int step = arr.length;
        while ((step = step >> 1) > 0) {
            stepList.add(step);
        }
        return stepList;
    }
}
