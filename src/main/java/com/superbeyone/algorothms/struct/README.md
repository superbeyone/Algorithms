### 数据结构与算法

#### 冒泡排序

冒泡排序（Bubble Sorting）的基本思想是：通过对待排序序列从前向后（从下标较小的元素开始）,依次比较相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。

因为排序的过程中，各元素不断接近自己的位置，**如果一趟比较下来没有进行过交换，就说明序列有序**， 因此要在排序过程中设置一个标志flag判断元素是否进行过交换。从而减少不必要的比较。

```java
import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className BubbleSort
 * @description 冒泡排序
 * @date 2020-07-24 14:01
 **/

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = new int[]{3, 9, -1, 10, 20, 6};
        long start = System.currentTimeMillis();
        //冒泡排序
        bubbleSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");

    }

    /**
     * 冒泡排序 时间复杂度 O(n^2)
     *
     * @param array 待排序数组
     */
    private static void bubbleSort(int[] array) {
        //临时变量
        int tmp = 0;
        //标识位，标志是否交换过
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                //如果前面的数比后一个数大，交换
                if (array[j] > array[j + 1]) {
                    flag = true;
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }

            if (!flag) {
                //在一趟排序中如果没有交换过
                break;
            } else {
                //重置标志位
                flag = false;
            }
        }
    }

}
```

#### 选择排序

选择排序（select sorting）也是一种简单的排序方法。它的基本思想是：第一次从arr[0] ~ arr[n-1] 中选取最小值，与arr[0]交换，第二次从arr[1] ~ arr[n-1]中选取最小值，与arr[1]交换，第三次从arr[2] ~ arr[n-1]中选取最小值，与arr[2]交换，…，第i次从arr[i-1] ~ arr[n-1]中选取最小值，与arr[i-1]交换，…, 第n-1次从arr[n-2] ~ arr[n-1]中选取最小值，与arr[n-2]交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列。


```java
import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className SelectSort
 * @description 选择排序
 * @date 2020-08-24 12:31
 **/

public class SelectSort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 9, -1, 10, 20, 6};
        long start = System.currentTimeMillis();
        //选择排序
        selectSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

    /**
     * 选择排序 时间复杂度 O(n^2)
     *
     * @param arr 要排序的数组
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    //说明假定的最小值不是实际的最小值
                    //重置 min
                    min = arr[j];
                    //重置 minIndex
                    minIndex = j;
                }
            }

            //判断是否需要交换位置
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
```


#### 插入排序

插入排序法介绍:

插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的。

插入排序（Insertion Sorting）的基本思想是：
把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。

```java
import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className InsertSort
 * @description 插入排序
 * @date 2020-08-25 12:45
 **/

public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 9, -1, 10, 20, 6};
        long start = System.currentTimeMillis();
        //选择排序
        insertSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");

    }

    /**
     * 插入排序
     *
     * @param arr 待排序数组
     */
    private static void insertSort(int[] arr) {

        //当需要插入的数是较小的数时，后移的次数明显增多，对效率有影响.
        for (int i = 0; i < arr.length; i++) {
            int insertVal = arr[i];
            //有序表的最后这个元素的下标
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出循环，说明插入位置找到了
            arr[insertIndex + 1] = insertVal;
        }
    }
}
```