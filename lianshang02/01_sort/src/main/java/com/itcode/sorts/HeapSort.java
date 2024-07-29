package com.itcode.sorts;

/**
 * 时间复杂度: O(nlogn)
 * @param <E>
 */
public class HeapSort<E extends Comparable<E>> extends Sort<E> {

    private int heapSize;

    @Override
    protected void sort() {
        //原地建立堆
        heapSize = arr.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
        while (heapSize > 1) {
            //交换堆顶元素和堆尾部元素
            swap(0, --heapSize);
            // 对0位置进行siftDown: 回复堆的性质.
            siftDown(0);
        }
    }

    /**
     * 堆数组进行原地建堆。建堆的时间复杂度为O(n)。
     */
    private void siftDown(int index) {
        E element = arr[index];
        int half = heapSize >> 1;
        while (index < half) {
            // index必须是非叶子节点
            // 默认是左边跟父节点比
            int childIndex = (index << 1) + 1;
            E child = arr[childIndex];

            int rightIndex = childIndex + 1;
            // 右子节点比左子节点大
            if (rightIndex < heapSize &&
                    cmpElement(arr[rightIndex], child) > 0) {
                child = arr[childIndex = rightIndex];
            }

            // 大于等于子节点
            if (cmpElement(element, child) >= 0) {
                break;
            }
            arr[index] = child;
            index = childIndex;
        }
        arr[index] = element;
    }
}
