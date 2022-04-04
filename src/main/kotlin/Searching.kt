import kotlin.math.floor

fun main(){
    println(findThreeLargestNumbers(listOf(141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7)))
}




/** Question 2 - Find 3 largest number**/
/**O(n) time and O(1) space **/
fun findThreeLargestNumbers(array: List<Int>): List<Int> {
    var largestNums = mutableListOf<Int>()
    if(array.size < 3) return listOf()
    if(array.size == 3) return sortNumbers(array)
    largestNums = sortNumbers(array.subList(0, 3))
    println(largestNums)
    for (i in 3 until array.size){
        if (array[i] > largestNums[0]){
            println("I: $i Value: ${array[i]}")
            largestNums[0] = array[i]
            largestNums = sortNumbers(largestNums)
            println(largestNums)
        }
    }
    return largestNums
}

fun sortNumbers(list: List<Int>): MutableList<Int>{
    val tempList = list.toMutableList()
    val size = list.size - 1
    for (i in 0 until size){
        for (j in 0 until size - i){
            if (tempList[j] > tempList[j+1]){
                val temp = tempList[j]
                tempList[j] = tempList[j+1]
                tempList[j+1] = temp
            }
        }
    }
    return tempList
}



















/** Question 1 - Binary search**/
/**O(logn) time and O(1) space **/
fun binarySearch(array: List<Int>, target: Int): Int {
    if (target > array.last() || target < array.first()) return -1

    var index = array.size - 1
    var maxIndex = index
    var minIndex = 0

    while (minIndex < maxIndex - 1){
        index = floor((maxIndex - minIndex)/2.0).toInt() + minIndex
        if(target > array[index]){
            minIndex = index
        }else if(target < array[index]){
            maxIndex = index
        }else{
            return index
        }
    }
    if (target == array[maxIndex]) return maxIndex
    if (target == array[minIndex]) return minIndex
    return -1
}


