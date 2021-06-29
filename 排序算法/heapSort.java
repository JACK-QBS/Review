package DataStructure.sort;

public class heapSort {
    //4、堆排序
    public static void heapSort(int[] array) {
        //1、建大堆：
        createHeap(array,array.length);
        //2、交换堆顶元素和无序数组的最后一个数字，并向下调整
        for (int i = 0; i < array.length - 1; i++) {
            int tmp = array[0];
            array[0] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
            //每次都是从堆顶开始向下调整
            adjustDown(array,array.length - 1 - i,0);
        }
    }
    //1、建大堆：
    public static void createHeap(int[] array, int length) {
        for (int i = (length - 2)/2; i >= 0; i--) {
            adjustDown(array,length,i);
        }
    }
    //2、向下调整：
    public static void adjustDown(int[] array,int size,int index) {
        while (true) {
            //1、判断index位置对应的是不是叶子结点
            int leftIndex = 2 * index + 1;//左孩子结点
            if (leftIndex >= size) {
                //左孩子不存在，该结点是叶子结点
                return;
            }
            //2、找出两个孩子中最大的
            int maxIndex = leftIndex;
            int rightIndex = 2 * index + 2;//右孩子结点
            if (rightIndex < size && array[rightIndex] > array[maxIndex]) {
                maxIndex = rightIndex;
            }
            //3、比较最大孩子和父节点
            if (array[index] >= array[maxIndex]) {
                //父节点 >= 最大孩子结点，无需交换
                return;
            }
            int tmp = array[index];
            array[index] = array[maxIndex];
            array[maxIndex] = tmp;
            //4、将最大孩子的结点视为index
            index = maxIndex;
        }
    }
}
