package Sort;

import java.util.Arrays;

public class ShellSort {
    //希尔排序：
    //若合理选择 gap 序列，希尔排序的时间复杂度可以达到O(N^1.3) （最高效）
    //实现 希尔排序 时，使用希尔序列 O(N^2):size/2, size/4, size/8 ... 1
    //gap = 1 时，希尔排序代码 = 直接插入排序代码
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while(gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        //当 gap = 1 时，最终插排一次
        insertSortGap(array, 1);
    }
    private static void insertSortGap(int[] array, int gap) {
        //从每组下标为 1 的元素开始
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            // bound 位置中相邻的前一个元素下标
            for (; cur >= 0 ; cur -= gap) {
                //分组情况下，同组的相邻元素下标差 gap
                // 把 cur 位置的元素搬到 cur +gap 位置
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 2, 9, 4, 3, 6, 8};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
