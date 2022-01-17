import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(){
    val list = mutableListOf(3,2,1,2,6)
    val result = taskAssignment(3, listOf(1, 3, 5, 3, 1, 4))
    println(result)
}



/**
 * Question 4
 */
fun taskAssignment(k: Int, tasks: List<Int>): List<List<Int>> {
    val unsignedTaskIndex = MutableList(k * 2){index ->  index}
    val mutableTask = tasks.toMutableList()
    val result = mutableListOf<List<Int>>()
    mutableTask.sort()
    while (mutableTask.isNotEmpty()){
        var indexOne: Int = 0
        var indexTwo: Int = 0
        for (i in unsignedTaskIndex.indices){
            if (tasks[unsignedTaskIndex[i]] == mutableTask.first()){
                indexOne = unsignedTaskIndex[i]
                unsignedTaskIndex.removeAt(i)
                break
            }
        }
        for (i in unsignedTaskIndex.indices){
            if (tasks[unsignedTaskIndex[i]] == mutableTask.last()){
                indexTwo = unsignedTaskIndex[i]
                unsignedTaskIndex.removeAt(i)
                break
            }
        }
        mutableTask.removeAt(0)
        mutableTask.removeAt(mutableTask.size - 1)
        result.add(listOf(indexOne, indexTwo))
    }
    return result
}


//fun taskAssignment(k: Int, tasks: List<Int>): List<List<Int>> {
//    val perfectTask = tasks.sum() / k
//    val mutableTask = tasks.toMutableList()
//    val unassignedTask = MutableList(tasks.size){index -> index}
//    val result = mutableListOf<List<Int>>()
//
//    println("k is $perfectTask")
//    println()
//    while (result.size < k){
//        val tempTask = mutableTask[unassignedTask[0]]
//        var tempPairIndex = 0
//        var minDifference = Int.MAX_VALUE
//        for (i in 1 until unassignedTask.size){
//            if (abs(tempTask + mutableTask[unassignedTask[i]] - perfectTask) < minDifference){
//                tempPairIndex = unassignedTask[i]
//                minDifference = abs(tempTask + mutableTask[unassignedTask[i]] - perfectTask)
//            }
//        }
//
//        result.add(listOf(unassignedTask[0], tempPairIndex))
//        println("${mutableTask[unassignedTask[0]]} + ${mutableTask[tempPairIndex]} = ${mutableTask[unassignedTask[0]] + mutableTask[tempPairIndex]}")
//        println(result)
//        println(unassignedTask)
//        unassignedTask.removeAt(0)
//        unassignedTask.removeAt(unassignedTask.indexOf(tempPairIndex))
//        println(unassignedTask)
//        println()
//    }
//
//    return result
//}

/**
 * Question 3
 */
fun tandemBicycle(redShirtSpeeds: MutableList<Int>, blueShirtSpeeds: MutableList<Int>, fastest: Boolean): Int {
    var speedSum = 0
    redShirtSpeeds.sort()
    if (fastest){
        blueShirtSpeeds.sortDescending()
    }else{
        blueShirtSpeeds.sort()
    }
    for (i in redShirtSpeeds.indices){
        speedSum += max(redShirtSpeeds[i], blueShirtSpeeds[i])
    }
    return speedSum
}





/**
 * Question 2
 */
fun classPhotos(redShirtHeights: MutableList<Int>, blueShirtHeights: MutableList<Int>): Boolean {
    redShirtHeights.sort()
    blueShirtHeights.sort()
    val isRedTaller = redShirtHeights.sum() > blueShirtHeights.sum()
    for (i in redShirtHeights.indices){
        if (isRedTaller && redShirtHeights[i] <= blueShirtHeights[i]){
            return false
        }
        if(!isRedTaller && redShirtHeights[i] >= blueShirtHeights[i]){
            return false
        }
    }
    return true
}




/**
 * Question 1
 */
fun minimumWaitingTime(queries: MutableList<Int>): Int {
    queries.sort()
    var waitingTime = 0
    var tempTime = 0
    println(queries)
    for(i in 0 until queries.size){
        waitingTime += tempTime
        tempTime += queries[i]
    }
    return waitingTime
}


