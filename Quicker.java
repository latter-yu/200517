package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Quicker {
    //JAVA 自带排序
    public static void main1(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(6);
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(9);
        arrayList.add(8);
        Collections.sort(arrayList);
        System.out.println(arrayList);

        int[] array = {6, 3, 7, 1, 5, 9, 8};
        Arrays.sort(array);
        System.out.println(arrayList);
        //ctrl + 鼠标左键 跳转到 类/方法 定义
    }

    //非递归实现快速排序(借助一个栈)
    public static void byLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if(left >= right) {
                //区间为空 或 区间内只有一个元素
                continue;
            }
            int index = partition(array, left, right);
            //把右子树入栈 [ index + 1, right)
            stack.push(index + 1);
            stack.push(right);
            //把左子树入栈 [left, index - 1)
            stack.push(left);
            stack.push(index - 1);
        }
    }
    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];//设基准值为最后一个元素
        int i = left;
        int j = right;
        while (i < j) {
            //从左往右找到一个 大于基准值 的元素
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            //再从右往左找到一个 小于基准值 的元素
            while (i < j && array[j] >= baseValue) {
                j--;
            }

            //此时 j 指向的元素要么和 i 重合，要么小于基准值
            //交换 i 和 j 的值
            if(i <j) {
                swap(array, i, j);
            }
        }
        //循环结束， i、j 重合,再与基准值交换
        //重合元素一定大于基准值元素
        swap(array, i, right);
        return i;
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {4, 9, 1, 5, 6, 3, 8, 2};
        byLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
