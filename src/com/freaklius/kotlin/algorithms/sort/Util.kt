package com.freaklius.kotlin.algorithms.sort

import java.util.Random

/**
 * Contains a set of utility methods like printing array contents and so on
 */

/**
 * Prints contents of an array
 * @param arr an array to be converted to string
 */
fun <T> arrayToString(arr: Array<T> ) : String{
    var str = "Array(";
    var isFirst: Boolean = true;
    for (element in arr){
        if (!isFirst){
            str += ", ";
        }
        str += element;
        if (isFirst){
            isFirst = false;
        }
    }
    str += ")";
    return str;
}

/**
 * Returns a shuffled version of the input array
 * @param arr an array to shuffle
 */
fun shuffleArray(arr: Array<Long>) : Array<Long>{
    val rg : Random = Random();
    for (i in 0..arr.size - 1) {
        val randomPosition = rg.nextInt(arr.size);
        swap(arr, i, randomPosition);
    }
    return arr;
}

//swap do deep copy, got arr change -> give arr change too
fun swap(arr: MutableList<Long>, i: Int, j: Int){
    val tmp : Long = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}


/**
 * Creates random array or Long of given length and max value
 * @param length length of an array to be generated
 * @param maxValue
 */
fun randomNumericArray(length: Int, maxValue : Int = 10) : Array<Long>{
    return Array<Long>(length, {i -> Math.round(maxValue * Math.random())});
}

/**
 * Returns whether given array is sorted in ascending order
 * @param arr array to be checked
 */
fun isSortedAsc(arr: Array<Long>) : Boolean{
    for (i in 0..arr.size - 2){
        if (arr[i] > arr[i + 1]){
            return false;
        }
    }
    return true;
}

/**
 * Returns maximum value of an array (a linear complexity operation).
 */
fun maximum(arr: Array<Long>) : Int{
    var max : Int = 0;
    for (value in arr){
        if (value > max){
            max = value.toInt();
        }
    }
    return max;
}