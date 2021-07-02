package DataStructure.sort;

//归并排序
public class mergeSort {
    public static void merge(int[] array) {
        mergeSortInternal(array,0,array.length - 1);
    }

    //对数组进行分组和合并
    private static void mergeSortInternal(int[] array, int lowIndex, int highIndex) {
        int size = highIndex - lowIndex;
        if (size <= 1) {
            return;
        }
        int midIndex = (lowIndex + highIndex) / 2;
        //分别对左右区间数组进行相同的递归处理
        mergeSortInternal(array,lowIndex,midIndex);
        mergeSortInternal(array,midIndex,highIndex);
        //合并两个数组
        mergeOrderedInternal(array,lowIndex,midIndex,highIndex);
    }

    //合并两个数组
    //新建一个数组，将需要比较的数组元素依次取出进行比较，存入额外数组中
    private static void mergeOrderedInternal(int[] array, int lowIndex, int midIndex, int highIndex) {
        int size = highIndex - lowIndex;
        int[] extra = new int[size];//新数组
        int left = lowIndex;//左数组的下标
        int right = midIndex;//右数组的下标
        int i = 0;//遍历新数组
        //两个数组中都有元素
        while (left < midIndex && right < highIndex) {
            if (array[left] <= array[right]) {
                extra[i++] = array[left++];
            } else {
                extra[i++] = array[right++];
            }
        }
        //已经有数组空了，则将另一个数组全部放入额外数组中
        if (left < midIndex) {
            //右数组为空，将左数组剩余部分全部放入额外数组
            while (left < midIndex) {
                extra[i++] = array[left++];
            }
        } else {
            //左数组为空，将右数组剩余部分全部放入额外数组
            while (right < highIndex) {
                extra[i++] = array[right++];
            }
        }
        //将数组中的值全部替换为新数组中的值
        for (int j = 0; j < size; j++) {
            array[lowIndex + j] = extra[j];
        }
    }
}
