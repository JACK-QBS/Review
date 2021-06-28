package DataStructure.sort;

public class insertSort {
    //1、直接插入排序：
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //1、抓无序区间第一张牌(红色牌)
            int key = array[i + 1];
            //2、将取出的牌依次和有序区间的牌比较
            int j;
            for (j = i; j >= 0; j--) {
                //如果取出 红色的牌的值 < 绿色牌的值
                if (key < array[j]) {
                    //将 绿牌 往后挪一个位置
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            //3、选择合适的位置插入
            array[j + 1] = key;
        }
    }
}
