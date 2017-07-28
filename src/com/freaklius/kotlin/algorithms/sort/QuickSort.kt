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

    /*
    arr = array
    left = array start
    right = array end
    arr[i] > pivot ---- arr[j] > pivot -> j--              both bigger than pivot
                   ---- arr[j] < pivot -> swap, i++, j--   i is bigger, j is smaller
    arr[i] < pivot ---- arr[j] > pivot -> i++, j--         i is smaller, j is bigger
                   ---- arr[j] < pivot -> i++              both smaller than pivot
     */
    private fun partition(arr: MutableList<Long>, left: Int, right: Int) : Int{
        val pivot = arr[right]
        var i = left
        var j = right - 1
        while (i < j) {
            if (arr[i] > pivot) {
                if (arr[j] < pivot) {
                    swap(arr, i, j)
                    i++
                }
                j--
            } else {
                if (arr[j] > pivot) {
                    j--
                }
                i++
            }
        }
        /*
        last swap or not
        */
        if (arr[i] > arr[right]) {
            swap(arr, i, right)
            return i
        } else {
            return i + 1
        }
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