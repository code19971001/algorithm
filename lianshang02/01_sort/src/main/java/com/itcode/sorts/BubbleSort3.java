package com.itcode.sorts;

/**
 * 优化: 如果序列尾部已经局部有序，可以记录最后一次交换的位置来减少循环的次数.
 * 1.添加变量lastIndex记录最后一次交换的位置
 */
public class BubbleSort3<E extends Comparable<E>> extends Sort<E> {


    @Override
    protected void sort() {
        for (int end = arr.length - 1; end > 0; end--) {
            int lastIndex = 0;  //初始值为0. 数组完全有序的时候则无需进行排序.
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    lastIndex = begin;
                }
            }
            end = lastIndex;
        }
    }
}
