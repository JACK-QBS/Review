package DataStructure.sort;

public class shellSort {
    //2、希尔排序：
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (true) {
            insertSortGap(array,gap);
            if (gap == 1) {
                break;
            }
            gap = gap / 2;
        }
    }
    public static void insertSortGap(int[] array,int gap) {
        //从第二组开始遍历
        for (int i = gap; i < array.length; i++) {
            int k = array[i];
            int j = 0;
            for (j = i - gap; j >= 0; j-=gap) {
                if (k < array[j]) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = k;
        }
    }
}
