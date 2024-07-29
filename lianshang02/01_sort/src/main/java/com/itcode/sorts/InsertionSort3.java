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
public class InsertionSort3<E extends Comparable<E>> extends Sort<E> {

    /**
     * 优化2：使用二分查找进行优化
     * 仅仅只是优化了查找的速度，时间复杂度依旧是O(n^2)
     */
    @Override
    protected void sort() {
        for (int begin = 1; begin < arr.length; begin++) {
            E insertionVal = arr[begin];
            int insertIndex = searchIndex(begin);
            System.arraycopy(arr, insertIndex, arr, insertIndex + 1, begin - insertIndex);
            arr[insertIndex] = insertionVal;
        }
    }


    /**
     * 找到一个合适的待插入的位置. 第一个比指定元素大的位置.
     */
    private int searchIndex(int endIndex) {
        int low = 0;
        int high = endIndex;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (cmpElement(arr[endIndex], arr[mid]) < 0) {
                high = mid;
            } else {
                //element.compareTo(arr[mid]) >= 0
                low = mid + 1;
            }
        }
        //high == low
        return high;
    }

}
