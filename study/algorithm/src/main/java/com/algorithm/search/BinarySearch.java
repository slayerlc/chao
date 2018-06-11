package com.algorithm.search;

import javax.annotation.Resource;

/**
 * @Autor lvchao
 * @date 2018/6/6
 */
public class BinarySearch {

    private static final int NOT_FOND = -1;

    public static void main(String args[]){
        int[] arr = new int[1000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        int findNum = 998;
        System.out.println("arr.index : " + binarySearch(arr,findNum));
    }

    /**
     * 二分法查找
     * 给定一个A0，A1……A(N-1) 已经排好先后顺序的数组
     * 求得值为x的下标i如果结果不在数组中则返回-1。
     * 验证x是否等于居中的元素如果是则返回结果。 如果x小于居中元素则用同样的方式验证左边的元素，大于则验证右边的。
     * 因为循环内工作花费为O(1)  循环从high - low >= N - 1 开始 在 high - low <= -1 结束
     * 每次循环后 需要判断的数组长度减半。 循环次数最多为[log(N-1)] + 2 因此运行时间是O(logN)
     * @param arr
     * @param x
     * @return
     */
    public static int binarySearch(int[] arr,int x){
        int low = 0;
        int high = arr.length - 1;
        while(high >= low){
            int mid = (low + high)/2;
            if(arr[mid] > x){
                high = mid - 1;
            }else if(arr[mid] < x){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return NOT_FOND;
    }
}
