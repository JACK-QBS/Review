package DataStructure.sort;

public class selectSort {
    //3、选择排序：从无序数组中选出最小的数字放在有序数组的最后一个位置
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //定义最小值的位置
            int minIndex = i;
            //从无序数组中找出最小的数字
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //交换最小的值和无序数组的第一个位置
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

}
