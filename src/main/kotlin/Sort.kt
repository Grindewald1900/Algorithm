/**
 * Algo Expert
 * @author Yee
 * 1. Bubble Sort
 * **/

fun main(){
    println(bubbleSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)))
    println(insertionSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)))
}

/** Question-2 **/
fun insertionSort(array: MutableList<Int>): List<Int> {
    val size = array.size
//    var value = array.first()
    for (i in 1 until size){
        var j = i
        while (j > 0 && array[j] < array[j - 1]){
            swap(j, j - 1, array)
            j--
        }
    }
    return array
}

fun swap(i: Int, j: Int, array: MutableList<Int>){
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}


/** Question-1 **/
fun bubbleSort(array: MutableList<Int>): List<Int> {
    val size = array.size
    for (i in 0 until size - 1){
        for (j in 0 until size - 1 - i){
            if (array[j] > array[j+1]){
                val temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            }
        }
    }
    return array
}

//fun swapInt(valueOne: Int, valueTwo: Int){}
