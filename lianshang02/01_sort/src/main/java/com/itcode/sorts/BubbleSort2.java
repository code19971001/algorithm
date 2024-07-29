package com.itcode.sorts;

/**
 * 优化: 数据相对有序的时候可以使用.
 * 1.如果某一轮没有进行过交换, 那就代表已经有序了.
 */
public class BubbleSort2<E extends Comparable<E>> extends Sort<E> {


    @Override
    public void sort() {
        for (int end = arr.length - 1; end > 0; end--) {
            boolean isSorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    // 交换
                    swap(begin, begin - 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
