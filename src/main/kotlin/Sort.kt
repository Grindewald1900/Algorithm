/**
 * Algo Expert
 * @author Yee
 * 1. Bubble Sort
 * **/

fun main(){
    println(threeNumberSort(mutableListOf(-2, -2, -2, -3, -3, -3, -3, -3, -3), mutableListOf(-2, -3, 0)))
}

/** Question-4 Solution 2 **/
fun threeNumberSort(array: MutableList<Int>, order: List<Int>): List<Int> {
    val orderCount = mutableListOf<Int>(0, 0, 0)
    for (i in array.indices){
        orderCount[order.indexOf(array[i])]++
    }
    var temp = 0
    for (i in 0 .. 2){
        for (j in temp until  temp + orderCount[i]){
            array[j] = order[i]
        }
        temp += orderCount[i]
    }
    return array
}

/** Question-4 **/
//fun threeNumberSort(array: MutableList<Int>, order: List<Int>): List<Int> {
//    var index = 0
//    if (array.size == 0) return listOf()
//    for (i in order.indices){
//        for (j in i+1 until array.size){
//            if (array[j] == order[i]){
//                array[j] = array[index]
//                array[index] = order[i]
//                index++
//            }
//        }
//    }
//    if(array.last() != order.last()){
//        array.add(array.indexOf(array.last()), array.last())
//        array.removeAt(array.size - 1)
//    }
//    return array
//}

/** Question-3 **/
fun selectionSort(array: MutableList<Int>): List<Int> {
    val result = mutableListOf<Int>()
    while (array.isNotEmpty()){
        var temp = Int.MAX_VALUE
        array.forEach{
            if (it < temp) temp = it
        }
        array.remove(temp)
        result.add(temp)
    }
    return result
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
