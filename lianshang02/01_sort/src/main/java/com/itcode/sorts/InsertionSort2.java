package com.itcode.sorts;

/**
 * 插入排序的时间复杂度和逆序对的数量成正比关系.
 * 最坏/平均时间复杂度: O(n^2)
 * 最好时间复杂度: O(n). 完全升序的序列
 * 空间复杂度为O(1)
 * 也是属于稳定排序.
 *
 * @param <E>
 */
public class InsertionSort2<E extends Comparable<E>> extends Sort<E> {

    /**
     * 优化1：将"交换"转为"挪动"，备份待插入元素，将比待插入元素大的元素往后挪动。
     * **如果逆序对越多，优化就越明显**.
     */
    @Override
    protected void sort() {
        for (int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            E insertionVal = arr[cur];
            //pay attention.
            while (cur > 0 && cmpElement(insertionVal, arr[cur - 1]) < 0) {
                arr[cur] = arr[cur - 1];
                cur--;
            }
            arr[cur] = insertionVal;
        }
    }


}
