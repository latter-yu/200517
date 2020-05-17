package Sort;

import java.util.Arrays;

public class SeclctShell {
    //选择排序(循环找最小值放在前面（升序排序为例）)
    //时间复杂度：O(N^2) 空间复杂度：O(1)
    //稳定性：不稳定排序
    public static void seclctShell(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            //此时数组区间为：
            //已排序：[0, bound) 未排序：[bound, size)
            for (int cur = bound; cur < array.length; cur++) {
                if(array[cur] < array[bound]) {
                    //找最小值
                    swap(array, cur, bound);
                }
            }
        }
    }
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {4, 7, 9, 1, 5, 6, 3, 8};
        seclctShell(array);
        System.out.println(Arrays.toString(array));
    }
}
