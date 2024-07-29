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
public class InsertionSort1<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }


}
