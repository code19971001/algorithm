package com.itcode.sorts;

@SuppressWarnings("unchecked")
public class MergeSort<E extends Comparable<E>> extends Sort<E> {

    private E[] leftArr;

    @Override
    protected void sort() {
        leftArr = (E[]) new Comparable[arr.length >> 1];
        sort(0, arr.length);
    }

    /**
     * [begin, mid), [mid, end)
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge2(begin, mid, end);
    }

    /**
     * 数组进行merge
     */
    private void merge(int begin, int mid, int end) {
        //备份数组
        System.arraycopy(arr, begin, leftArr, 0, mid - begin);
        int index = begin;
        for (int i = begin, j = mid; i <= mid && j <= end; i++, j++) {
            if (i == mid) {
                //一旦左数组先结束, 右边是不需要再改动
                break;
            }
            if (j == end) {
                //一旦右边先结束. 需要将左边的剩余数据复制到右边
                System.arraycopy(leftArr, i - begin, arr, index, mid - i);
                break;
            }
            if (cmpElement(leftArr[i - begin], arr[j]) <= 0) {
                arr[index++] = leftArr[i - begin];
                j--;

            } else {
                arr[index++] = arr[j];
                i--;
            }
        }

    }

    /**
     * 将[begin ,mid)和[mid ,end)范围中的数据合并到一起。
     * 为了更好的进行merge操作，最好将其中1组序列备份出来，推荐将左边的数组进行备份。
     */
    private void merge2(int begin, int mid, int end) {
        //左边数组永远从0开始，数组长度为mid - begin
        int li = 0, le = mid - begin;
        //右边数组
        int ri = mid, re = end;
        //合并数组的索引
        int ai = begin;
        //备份数组
        for (int i = li; i < le; i++) {
            leftArr[i] = arr[begin + i];
        }
        //必定有一个到了终点：
        // 左边的数组到了重点，无需任何操作
        // 右边数组到了重点，需要复制左边数组的剩余内容到arr中去。
        while (li < le) {
            if (ri < re && cmpElement(arr[ri], leftArr[li]) < 0) {
                //左右数组都没完成遍历，且左值大于右值
                arr[ai++] = arr[ri++];
            } else {
                arr[ai++] = leftArr[li++];
            }
        }
    }

}
