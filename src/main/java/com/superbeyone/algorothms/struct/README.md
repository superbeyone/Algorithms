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
     * 冒泡排序
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
