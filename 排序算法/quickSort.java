package DataStructure.sort;

//快排：选最左边的数为基准，遍历数组，大于基准的放右边，小于基准的放左边
//     对左右数组在进行快排
public class quickSort {
    public static void quick(int[] array) {
        quickSortInternal(array,0,array.length-1);
    }

    //给定位置之间进行快排
    private static void quickSortInternal(int[] array, int lowIndex, int highIndex) {
        //当子数组的元素个数 <= 1 的时候，结束
        int size = highIndex - lowIndex + 1;
        if (size <= 1) {
            return;
        }
        //经过一次 partition 后，基准所在的位置下标
        int keyIndex = partition(array,lowIndex,highIndex);
        //对左右区间进行相同的处理 递归
        quickSortInternal(array,lowIndex,keyIndex - 1);
        quickSortInternal(array,keyIndex + 1,highIndex);
    }

    //以选出的 lowIndex 为基准，遍历数组，吧比基准小的放他左边，比他大的放他右边
    private static int partition(int[] array, int lowIndex, int highIndex) {
        //方法1：hover
        //return hover(array,lowIndex,highIndex);
        //方法2：挖坑法：
        //return digAHole(array,lowIndex,highIndex);
        //方法3：前后遍历法
        return doublePointer(array,lowIndex,highIndex);
    }

    private static int doublePointer(int[] array, int lowIndex, int highIndex) {
        int separateIndex = lowIndex + 1;
        for (int i = separateIndex; i < highIndex; i++) {
            if (array[i] < array[lowIndex]) {
                swap(array,i,separateIndex);
                separateIndex++;
            }
        }
        swap(array,separateIndex-1,lowIndex);
        return separateIndex - 1;
    }

    //2、挖坑法：
    private static int digAHole(int[] array, int lowIndex, int highIndex) {
        //key 代表基数，将其挖出，则该位置为空
        int key = array[lowIndex];
        int leftIndex = lowIndex + 1;
        int rightIndex = highIndex;
        //只有两个元素的情况
        if (leftIndex == rightIndex) {
            if (array[leftIndex] >= key) {
                return lowIndex;
            } else {
                int tmp = key;
                key = array[leftIndex];
                array[leftIndex] = key;
                return leftIndex;
            }
        }
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                rightIndex--;
            }
            //把右边小于基数的那个数填到之前左边挖出的坑中
            array[lowIndex] = array[rightIndex];
            while (leftIndex < rightIndex && array[leftIndex] < key) {
                leftIndex++;
            }
            //把左边大于基数的那个数填到上边空出的那个位置
            array[rightIndex] = array[leftIndex];
            lowIndex = leftIndex;
        }
        //将 key 放回剩余的坑中
        array[rightIndex] = key;
        return rightIndex;
    }

    private static int hover(int[] array, int lowIndex, int highIndex) {
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        int key = array[lowIndex];//基准
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= key) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= key) {
                leftIndex++;
            }
            //rightIndex下标遇到比基数小的数，leftIndex下标遇到比基数大的数，则，交换两个数字
            swap(array,leftIndex,rightIndex);
        }
        //交换左右相交节点和基准
        swap(array,lowIndex,leftIndex);
        return rightIndex;
    }
    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
