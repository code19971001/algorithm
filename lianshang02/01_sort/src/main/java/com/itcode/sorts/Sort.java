package com.itcode.sorts;

import com.itcode.bean.Student;

import java.text.DecimalFormat;

@SuppressWarnings({"unchecked"})
public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort<E>> {

    protected E[] arr;
    protected long cmpCount;
    protected long swapCount;
    private long time;
    private final DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(E[] arr) {
        if (arr == null || arr.length < 2) return;
        this.arr = arr;
        long begin = System.currentTimeMillis();
        sort();
        long end = System.currentTimeMillis();
        this.time = end - begin;
    }

    protected abstract void sort();

    protected int cmp(int i1, int i2) {
        cmpCount++;
        return arr[i1].compareTo(arr[i2]);
    }

    protected int cmpElement(E i1, E i2) {
        cmpCount++;
        return i1.compareTo(i2);
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        E tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    private String numberString(long number) {
        if (number < 10000) {
            return "" + number;
        }
        if (number < 100000000) {
            return fmt.format(number / 10000.0) + "万";
        }
        return fmt.format(number / 100000000.0) + "亿";
    }

    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        String stableStr = "稳定性：" + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + "\t"
                + timeStr + " \t"
                + compareCountStr + " \t"
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";
    }

    /**
     * 判断排序算法是否是稳定的。
     */
    private boolean isStable() {
//        if (this instanceof CountingSort) {
//            return true;
//        }
//        if (this instanceof RadixSort) {
//            return true;
//        }
//        if (this instanceof ShellSort) {
//            return false;
//        }
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i * 10, 10);
        }
        sort((E[]) students);
        //如果算法是稳定的，那么student的学生顺序是不会发生变化的。
        for (int i = 1; i < students.length; i++) {
            if ((students[i].getScore() != students[i - 1].getScore() + 10)) {
                return false;
            }

        }
        return true;
    }

    @Override
    public int compareTo(Sort s2) {
        int result = (int) (time - s2.time);
        if (result != 0) {
            return result;
        }
        result = (int) (cmpCount - s2.cmpCount);
        if (result != 0) {
            return result;
        }
        return (int) (swapCount - s2.swapCount);
    }
}
