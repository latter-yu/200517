package Sort;

import java.util.Arrays;

public class MregeSortByLoop {
    public static void byLoop(int[] array) {
        // gap 表示当前每个组中的元素个数
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length; i += 2*gap) {
                //每进行一遍循环体，相当于把两个长度为 gap 的数组合并
                // [i, i + gap) [i + gap, i + 2*gap)
                int left = i;
                int mid = i +gap;
                int right = i + 2*gap;
                if (mid > array.length) {
                    mid = array.length;
                }
                if (right > array.length) {
                    right = array.length;
                }
                merge(array, left, mid, right);
            }
        }
    }
    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        //临时空间需要容纳下两个数组 数量之和
        int[] output = new int[right - left];
        int outputIndex = 0;
        // 当前 output 中被插入了几个元素

        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                // 如果是 < ，无法保证稳定性
                // 把 cur1 位置的元素插入到 output 中
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            }else {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }
        }
        while (cur1 < mid) {
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;
        }
        while (cur2 < right) {
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
        //把数据从临时空间中拷贝回原来的数组中
        for (int i = 0; i < right - left; i++) {
            array[left + i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 9, 1, 5, 6, 3, 8, 2};
        byLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
