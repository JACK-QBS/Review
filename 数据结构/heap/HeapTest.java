package DataStructure.heap;

/**
 * 向下调整：小堆
 */
public class HeapTest {
    public static void shiftDown(int[] arr,int size,int index) {
        while (true) {
            //1、判断 Index 位置的结点是不是叶子结点
            int leftIndex = index * 2 + 1;//左孩子结点
            if (leftIndex >= size) {
                return;
            }
            //2、找到两个孩子中最小的
            int minIndex = leftIndex;//假设此时左孩子为最小的
            int rightIndex = leftIndex + 1;//右孩子结点
            if (rightIndex < size && arr[rightIndex] < arr[minIndex]) {
                minIndex = rightIndex;
            }
            //3、比较小孩子的值和index位置的值
            if (arr[minIndex] < arr[index]) {
                //交换
                int tmp = arr[minIndex];
                arr[minIndex] = arr[index];
                arr[index] = tmp;
            } else {
                return;
            }
            //4、把最小的孩子视为index，循环回去
            index = minIndex;
        }
    }
}
