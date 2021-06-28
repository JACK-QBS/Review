package DataStructure.sort;

//排序算法：
public class sort {
    public static void main(String[] args) {
        int[] array = new int[]{5,2,1,4,7,3,6,9,12};
        //insertSort.insertSort(array);
        //shellSort.shellSort(array);
        //selectSort.selectSort(array);
        //heapSort.heapSort(array);
        //bubbleSort.bubbleSort(array);
        //quickSort.quick(array);
        mergeSort.merge(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
