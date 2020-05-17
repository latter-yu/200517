package Sort;

import java.util.Arrays;

public class MergeSort {
    //归并排序
    //时间复杂度：O(NlogN) 空间复杂度：O(N) + O(logN)（临时空间）=> O(N)
    //稳定性：稳定排序

    //特点：
    // 1.能高效的针对链表进行排序
    // 2. “外部排序” 的主要实现方式（数据在外存中）
    public static void mergeSort(int[] array) {
        // [0, length)
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int [] array, int left, int right) {
        //[left, right)
        if(right - left <= 1) {
            //当前区间中有 0 或 1 个元素，不需要进行排序
            return;
        }
        //对于 [left, right）区间，分成对等的两个区间
        // [left, mid) [mid, right)
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        //已排好序，将两个有序数字进行合并
        merge(array, left, mid, right);
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
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}