package com.itcode.sorts;

@SuppressWarnings("unchecked")
public class MergeSort<E extends Comparable<E>> extends Sort<E> {

    private E[] backupArr;

    @Override
    protected void sort() {
        backupArr = (E[]) new Comparable[arr.length >> 1];
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
        System.arraycopy(arr, begin, backupArr, 0, mid - begin);
        int index = begin;
        for (int i = begin, j = mid; i <= mid && j <= end; i++, j++) {
            if (i == mid) {
                //一旦左数组先结束, 右边是不需要再改动
                break;
            }
            if (j == end) {
                //一旦右边先结束. 需要将左边的剩余数据复制到右边
                System.arraycopy(backupArr, i - begin, arr, index, mid - i);
                break;
            }
            if (cmpElement(backupArr[i - begin], arr[j]) <= 0) {
                arr[index++] = backupArr[i - begin];
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
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        //备份数组
        for (int i = li; i < le; i++) {
            backupArr[i] = arr[begin + i];
        }
        //必定有一个到了终点：
        // 左边的数组到了重点，无需任何操作
        // 右边数组到了重点，需要复制左边数组的剩余内容到arr中去。
        while (li < le) {
            if (ri < re && cmpElement(arr[ri], backupArr[li]) < 0) {
                arr[ai++] = arr[ri++];
            } else {
                arr[ai++] = backupArr[li++];
            }
        }
    }

}
