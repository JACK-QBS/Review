package DataStructure.heap;

/**
 * 向上调整：大堆
 */
public class HeapTest2 {
    public static void adjustUp(int[] array,int size,int index) {
        while (true) {
            //1、如果index是树的根，直接结束
            if (index == 0) {
                return;
            }
            //2、找到Index的父节点
            int parentIndex = (index - 1) / 2;
            //3、如果 父节点值 < 孩子值
            if (array[parentIndex] < array[index]) {
                //交换
                int tmp = array[parentIndex];
                array[parentIndex] = array[index];
                array[index] = tmp;
            } else {
                return;
            }
            //4、把父节点看作index，继续循环
            index = parentIndex;
        }
    }
}
