package com.itcode.sorts;

/**
 * 快速排序: 逐渐将每一个元素都转化为轴点, 一旦所有的元素都转换为轴点, 那就已经排好顺序.
 * 最好时间复杂度: O(nlogn), 轴点左右元素数量比较均匀的情况下
 * 最坏时间复杂度: O(n^2)
 * <p>
 * 平均时间复杂度推到:
 * T(n) = 2 * T(n/2) + O(n)
 * T(1) = O(1)
 * T(n)/n = T(n/2)/ (n/2) + O(n)/n
 * <p>
 * 令S(n) = T(n)/n  S(1) = O(1)
 * <p>
 * S(n) = S(n/2) + O(1) = S(n/4) + O(2) = S(n/(2^3)) + O(3) = S(n/(2^k)) + O(k) = S(1) + O(logn)
 * T(n) = nS(n) = O(nlogn)
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, arr.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        //确定轴点元素的位置
        int pivotIndex = getPivotIndex(begin, end); // O(n)
        sort(begin, pivotIndex); //T(n/2)
        sort(pivotIndex + 1, end); // T(n/2)
    }

    /**
     * 将轴点元素放入最终位置
     */
    private int getPivotIndex(int begin, int end) {
        E pivotVal = arr[begin];
        //默认反向
        boolean reverse = true;
        //指向最后一个元素
        end--;
        while (begin < end) {
            if (reverse) {
                if (cmpElement(pivotVal, arr[end]) < 0) {
                    end--;
                } else {
                    //覆盖
                    arr[begin++] = arr[end];
                    //下一轮正向扫
                    reverse = false;
                }
            } else {
                if (cmpElement(pivotVal, arr[begin]) > 0) {
                    begin++;
                } else {
                    //覆盖
                    arr[end--] = arr[begin];
                    //下一轮反向扫
                    reverse = true;

                }
            }

        }
        //将轴点元素放到合适的位置
        arr[begin] = pivotVal;
        return begin;
    }
}
