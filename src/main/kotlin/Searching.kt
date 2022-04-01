import kotlin.math.floor

fun main(){
    binarySearch(listOf(1, 5, 23, 111), 35)
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
