package com.itcode.sorts;

public class BubbleSort1<E extends Comparable<E>> extends Sort<E> {


    @Override
    protected void sort() {
        for (int end = arr.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    // 交换
                    swap(begin, begin - 1);
                }
            }
        }
    }
}
