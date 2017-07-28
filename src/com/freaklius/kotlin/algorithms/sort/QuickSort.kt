package com.freaklius.kotlin.algorithms.sort

/**
 * Quick sort algorithm implementation
 * AveragePerformance = O(n*lg(n))
 */
public class QuickSort : SortAlgorithm {

    public override fun sort(arr: Array<Long>): Array<Long> {
        sortArrayPart(arr, 0, arr.size - 1);
        return arr;
    }

    /**
     * Swaps initial array elements having keys in [fromIndex; toIndex] range
     * so that two subarrays are formed: leftArr[i] <= arr[middleIndex] <= rightArr[j]
     * for any i, j and fromIndex <= middleIndex <= toIndex
     * @param arr
     * @param fromIndex
     * @param toIndex
     * @return returns middleIndex value
     */
    private fun partition(arr: Array<Long>, fromIndex: Int, toIndex: Int) : Int{
        val lastElementValue = arr[toIndex];
        var i = fromIndex;
        for (j in (fromIndex + 1)..toIndex - 1){
            if (arr[j] <= lastElementValue && arr[i] > arr[j]){  //if arr[j] and arr[i] are same, they don't need to swap
                swap(arr, i, j);
                i++;
            }
        }
        //Swapping leftmost element of the second part with the last element of the array, i.e. with middle element
        swap(arr, i, toIndex);
        return i;
    }

    /**
     * Sorts a part of input array
     * @param arr
     * @param fromIndex
     * @param toIndex
     */
    private fun sortArrayPart(arr: Array<Long>, fromIndex: Int, toIndex: Int){
        if (fromIndex < toIndex){
            var middleIndex = partition(arr, fromIndex, toIndex);
            sortArrayPart(arr, fromIndex, middleIndex - 1);
            sortArrayPart(arr, middleIndex + 1, toIndex);
        }
    }

    public override fun getName(): String {
        return "QuickSort";
    }
}