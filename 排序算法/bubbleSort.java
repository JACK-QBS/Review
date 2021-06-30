package DataStructure.sort;

public class bubbleSort {
    //5、冒泡排序：每次将最大的元素冒泡到最后
    public static void bubbleSort(int[] array) {
        //无序区间：[0,array.length - 1]
        //有序区间：[array.length - 1,array.length]
        for (int i = 0; i < array.length - 1; i++) {
            //每次冒泡之前，假设数组有序
            boolean is = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    is = false;
                }
            }
            //如果 is == true，说明冒泡的时候没有进行交换，则代表数组有序
            if (is) {
                break;
            }
        }
    }
}
