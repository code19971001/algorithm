package com.itcode.sorts;

public class SelectionSort<E extends Comparable<E>> extends Sort<E> {

    /**
     * 每一轮都找到最大的，然后放到最后
     * 时间复杂度: O(n^2)
     * 空间复杂度为: O(1)
     * 对于随机的数据集, 相对于冒泡排序来说，减少了交换次数, 性能会高于冒泡排序;
     */
    @Override
    protected void sort() {
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 0; begin <= end; begin++) {
                if (cmp(maxIndex, begin) <= 0) {
                    maxIndex = begin;
                }
            }
            if (maxIndex != end) {
                //交换位置
                swap(maxIndex, end);
            }
        }
    }
}
