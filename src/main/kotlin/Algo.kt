import java.util.ArrayDeque
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


fun main(args: Array<String>) {

/** BST data**/
    val tree = BinaryTree(1)
    tree.left = BinaryTree(2)
    tree.left!!.left = BinaryTree(4)
    tree.left!!.right = BinaryTree(5)
    tree.left!!.left!!.left = BinaryTree(8)
    tree.left!!.left!!.right = BinaryTree(9)
    tree.left!!.right!!.left = BinaryTree(10)
    tree.right = BinaryTree(3)
    tree.right!!.right = BinaryTree(7)
    tree.right!!.left = BinaryTree(6)
    tree.right!!.left!!.right = BinaryTree(11)
    tree.right!!.left!!.right!!.right = BinaryTree(16)
    tree.right!!.left!!.right!!.left = BinaryTree(15)
    tree.right!!.left!!.right!!.left!!.right = BinaryTree(17)
    tree.right!!.left!!.right!!.left!!.right!!.right = BinaryTree(18)
    tree.right!!.left!!.right!!.left!!.right!!.right!!.right = BinaryTree(19)
    tree.right!!.left!!.right!!.left!!.right!!.right!!.right!!.left = BinaryTree(20)
    tree.right!!.left!!.right!!.left!!.right!!.right!!.right!!.left!!.left = BinaryTree(21)


    print("")
}


open class TreeInfo(){
    var maxPathSum: Int? = null

}
open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

open class BinaryTreeWithParent(tree: BinaryTree, parent: BinaryTree){
    var tree = tree
    var parent = parent
}
var maxSum: Int = Int.MIN_VALUE

fun maxPathSum(tree: BinaryTree): Int {
    // Write your code here.
    maxSum = Int.MIN_VALUE
    getMaxSum(tree)
    return maxSum
}

fun getMaxSum(node: BinaryTree): Int{
    var maxLeft = 0
    var maxRight = 0
    // Get left and left value
    if(node.left != null){
        maxLeft = getMaxSum(node.left!!)
    }
    if (node.right != null){
        maxRight = getMaxSum(node.right!!)
    }
    val tempMaxSum = max(0, maxLeft) + max(0, maxRight) + node.value
    if(tempMaxSum > maxSum) maxSum = tempMaxSum
    // Return
    return if(node.left == null && node.right == null) node.value
    else max(maxLeft, maxRight) + node.value
}




fun findNodesDistanceK(tree: BinaryTree, target: Int, k: Int): List<Int> {
    // Write your code here.

    return listOf()
}



fun findNodeByValue(tree: BinaryTree, value: Int): BinaryTree?{
    var result: BinaryTree? = null
    if (tree.value != value){
        if(tree.left != null) {
            val rLeft = findNodeByValue(tree.left!!, value)
            if(null != rLeft) result = rLeft
        }
        if(tree.right != null) {
            val rRight = findNodeByValue(tree.right!!, value)
            if(null != rRight) result = rRight
        }
    }
    return result
}


var isBalance = true

fun heightBalancedBinaryTree(tree: BinaryTree): Boolean {
    // Write your code here.
    isBalance = true
    getTreeHeight(tree)
    return isBalance
}
fun getTreeHeight(node: BinaryTree): Int{
    var leftHeight = 0
    var rightHeight = 0
    if(node.left != null){
        leftHeight = getTreeHeight(node.left!!) + 1
    }
    if(node.right != null){
        rightHeight = getTreeHeight(node.right!!) + 1
    }
    print("Node: ${node.value}  Left: $leftHeight  Right: $rightHeight\n")
    if(abs(leftHeight - rightHeight) > 1){
        isBalance =  false
    }
    if (node.left == null && node.right == null){
        return 0
    }
    return max(leftHeight, rightHeight)
}

val nodeList: MutableList<BinaryTree> = arrayListOf()

fun findSuccessor(tree: BinaryTree, node: BinaryTree): BinaryTree? {
    // Write your code here.
    traverseTree(tree, node)
    print("Node list: $nodeList \n\n")
    if (nodeList.last() == node){
        return null
    }
    return nodeList[nodeList.indexOf(node) + 1]
}

fun traverseTree(tree: BinaryTree, node: BinaryTree){
    print("Value pre: ${tree.value} \n")
    if(tree.left != null){
        traverseTree(tree.left!!, node)
    }
    print("Value mid: ${tree.value} \n")
    nodeList.add(tree)
    if(tree.right != null){
        traverseTree(tree.right!!, node)
    }
    print("Value post: ${tree.value} \n")
}



fun binaryTreeDiameter(tree: BinaryTree?): Int {
    // Write your code here.
    val (depth, diameter) = getLongestPath(tree)

    return diameter
}


fun getLongestPath(tree: BinaryTree?): Pair<Int, Int>{
    if (tree == null) return Pair(0, 0)
    // Get info from left and right subtrees
    val (depthLeft, diameterLeft) = getLongestPath(tree.left)
    val (depthRight, diameterRight) = getLongestPath(tree.right)

    val currentDepth = 1 + max(depthLeft, depthRight)
    val maxDiameter = max(diameterLeft, diameterRight)
    val currentDiameter = max(maxDiameter, depthLeft + depthRight)

    return Pair(currentDepth, currentDiameter)
}


fun traverseNode(node: BinaryTree, longPathList: MutableList<Int>){
    searchNode(node, longPathList)
    if(node.left != null){
        traverseNode(node.left!!, longPathList)
    }
    if(node.right != null){
        traverseNode(node.right!!, longPathList)
    }
}


fun searchNode(node: BinaryTree, longPathList: MutableList<Int>){
    val lengthListLeft: MutableList<Int> = arrayListOf()
    val lengthListRight: MutableList<Int> = arrayListOf()

    if (node.left != null){
        findLongestPath(node.left!!, 0, lengthListLeft)
//        traverseNode(node.left!!, longPathList)
    }
    if (node.right != null){
        findLongestPath(node.right!!, 0, lengthListRight)
//        traverseNode(node.right!!, longPathList)
    }
    print("${node.value} \n")
    print("Long path for node\n")
    longPathList.add(lengthListLeft.maxOrNull()!! + lengthListRight.maxOrNull()!! + 1)
}

fun findLongestPath(node: BinaryTree, length: Int, lengthList: MutableList<Int>){
    if (node.left != null){
        findLongestPath(node.left!!, length + 1, lengthList)
    }
    if (node.right != null){
        findLongestPath(node.right!!, length + 1, lengthList)
    }
    if(node.left == null && node.right == null){
        print("${node.value} \n")
        print("$length \n")
        lengthList.add(length + 1)
    }
}

fun invertBinaryTree(tree: BinaryTree, targetTree: BinaryTree) {
    print("Node value: ${tree.value} \n")
    print("Target value: ${targetTree.value} \n")
    print("Left: ${targetTree.left} \n")
    print("Right: ${targetTree.right} \n\n")

    // Write your code here.
    if(tree.left != null && tree.right != null){
        // Switch left and right node
        val tempValue: BinaryTree = tree.left!!
        tree.left = tree.right
        tree.right = tempValue
        invertBinaryTree(tree.left!!, targetTree)
        invertBinaryTree(tree.right!!, targetTree)
    }else if(tree.left != null){
        // Only have left sub node
        tree.right = tree.left
        invertBinaryTree(tree.right!!, targetTree)
        tree.left = null
    }else if(tree.right != null){
        // Only have right sub node
        tree.left = tree.right
        invertBinaryTree(tree.left!!, targetTree)
        tree.right = null
    }
}

fun branchSums(root: BinaryTree): List<Int> {
    var sumList:MutableList<Int> = mutableListOf()
    // Write your code here.
    getSums(root, 0, sumList)
    return sumList
}

fun getSums(node: BinaryTree, temSum: Int, list: MutableList<Int>){
    if (node.left != null){
        getSums(node.left!!, temSum + node.value, list)
    }
    if (node.right != null){
        getSums(node.right!!, temSum + node.value, list)
    }
    if (node.left == null && node.right == null){
        list.add(temSum + node.value)
    }
}



fun nodeDepths(root: BinaryTree): Int {
    var depthList: MutableList<Int> = mutableListOf()
    getDepth(root, 0, depthList)
    print(depthList)
    // Write your code here.
    return depthList.sum()
}

fun getDepth(node: BinaryTree, temDepth: Int, depthList: MutableList<Int>){
    depthList.add(temDepth)
//    print("Node: ${node.value}")
//    print("Temp Depth: $temDepth \n")
    if(node.left != null){
        getDepth(node.left!!, temDepth + 1, depthList)
    }
    if (node.right != null){
        getDepth(node.right!!, temDepth + 1, depthList)
    }
}



// valueOne is greater than target while valueTwo is less
//var valueOne = 0
//var valueTwo = 0
//var isGreater = false
//var isGreaterChanged = false
//
//open class BST(value: Int) {
//    var value = value
//    var left: BST? = null
//    var right: BST? = null
//}
//
//
//fun findClosestValueInBst(tree: BST, target: Int): Int{
//    isGreater = tree.value > target
//    findClosestValueInBstHelper(tree, target)
//    return if(abs(valueOne - target) > abs(valueTwo - target)){
//        valueTwo
//    }else{
//        valueOne
//    }
//}
//
//fun findClosestValueInBstHelper(tree: BST, target: Int){
//    val result = tree.value
//    if(isGreater != result > target){
//        isGreaterChanged = true
//    }
//    if(result > target){
//        valueOne = result
//        if(!isGreaterChanged && tree.left != null){
//            findClosestValueInBst(tree.left!!, target)
//        }
//    }else{
//        valueTwo = result
//        if (!isGreaterChanged && tree.right != null){
//            findClosestValueInBst(tree.right!!, target)
//        }
//    }
//}



fun zigzagTraverse(array: List<List<Int>>): List<Int> {
    val width = array[0].size - 1
    val height = array.size - 1
    var leftEnd = Pair(0, 0)
    var rightEnd = Pair(0, 0)
    var isFromLeft = false
    val results = mutableListOf<Int>()

    for (i in 0..width + height){
        val count = rightEnd.second - leftEnd.second
        for (j in 0..count){
            if (isFromLeft){
                results.add(array[leftEnd.first - j][leftEnd.second + j])
            }else{
                results.add(array[rightEnd.first + j][rightEnd.second - j])
            }
        }
        isFromLeft = !isFromLeft
        leftEnd = if (leftEnd.first == height)
            Pair(height, leftEnd.second + 1)
        else
            Pair(leftEnd.first + 1, 0)
        rightEnd = if (rightEnd.second == width)
            Pair(rightEnd.first + 1, width)
        else
            Pair(0, rightEnd.second + 1)

    }
    return results
}



fun minRewards(scores: List<Int>): Int {
    val rewards = MutableList(scores.size){1}
    if (scores.size == 1) return 1
    if (scores.size == 2) return 3
    for (i in 1 until scores.size){
        if (scores[i] > scores[i-1]) rewards[i] = max(rewards[i-1] + 1, rewards[i])
    }
    for (i in scores.size - 2 downTo 0){
        if (scores[i] > scores[i+1]) rewards[i] = max(rewards[i+1] + 1, rewards[i])
    }
    return rewards.sum()
}



fun largestRange(array: List<Int>): Pair<Int, Int> {
    if(array.size == 1) return Pair(array[0], array[0])
    var leftIdx = 0
    var rightIdx = 0
    var currentRange = 1
    var maxRange = 1
    var start = 0

    val sortedArray = array.toMutableList()
    sortedArray.sort()
    while (rightIdx < sortedArray.size - 1){
        if (sortedArray[rightIdx+1] <= sortedArray[rightIdx] + 1){
            currentRange = rightIdx + 1 - leftIdx
        } else {
            leftIdx = rightIdx + 1
        }
        if (currentRange > maxRange){
            if(sortedArray[start] < sortedArray[start+currentRange]){
                maxRange = currentRange
            }
            start = leftIdx
        }
        rightIdx ++
    }
    return Pair(sortedArray[start], sortedArray[start+maxRange])
}


fun subarraySort(array: List<Int>): List<Int> {
    var leftIdx = 0
    var rightIdx = array.size - 1
    var localMax = 0
    var localMin = 0

    while (leftIdx < rightIdx){
        if (array[leftIdx] > array[leftIdx+1] && array[rightIdx-1] > array[rightIdx]) break
        if(rightIdx - leftIdx <= 1) return listOf<Int>(-1, -1)
        if (array[leftIdx] <= array[leftIdx+1]) leftIdx ++
        if (array[rightIdx-1] <= array[rightIdx]) rightIdx --
    }
    localMax = array[rightIdx]
    localMin = array[leftIdx]
    for (i in leftIdx..rightIdx){
        localMax = max(localMax, array[i])
        localMin = min(localMin, array[i])
    }
    while (leftIdx > 0 && array[leftIdx-1] > localMin){
        leftIdx --
    }
    while (rightIdx < array.size - 1 && array[rightIdx+1] < localMax){
        rightIdx ++
    }

    return listOf<Int>(leftIdx, rightIdx)
}



fun fourNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    if (array.size < 4) return listOf()
    array.sort()

    return numberSum(array, targetSum, 3)
}


fun numberSum(array: MutableList<Int>, targetSum: Int, count: Int): MutableList<List<Int>>{
    val localResult = mutableListOf<List<Int>>()
    while (array.size > count){
        val temp = array[0]
        array.removeAt(0)
        var numList = mutableListOf<List<Int>>()
        if(count > 0){
            numList = numberSum(array.toMutableList(), targetSum - temp, count - 1)
        }else if(count == 0 && array.contains(targetSum)){
            numList = mutableListOf(listOf(targetSum))
        }
        if (numList.isNotEmpty()){
            numList.forEach {
                when(count){
                    3 -> localResult.add(listOf(temp, it[0], it[1], it[2]))
                    2 -> localResult.add(listOf(temp, it[0], it[1]))
                    1 -> localResult.add(listOf(temp, it[0]))
                    0 -> localResult.add(listOf(it[0]))
                }
            }
        }

    }
    return localResult
}


fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>>{
    val results = mutableListOf<List<Int>>()

    while (array.size > 2){
        val temp = array[0]
        array.removeAt(0)
        val twoNumList = twoNumSum(array.toMutableList(), targetSum - temp)
        if (twoNumList.isNotEmpty()){
            twoNumList.forEach {
                results.add(listOf(temp, it[0], it[1]))
            }
        }
    }

    return results
}

fun twoNumSum(array: MutableList<Int>, targetSum: Int): List<List<Int>>{
    val results = mutableListOf<List<Int>>()

    while (array.size > 1){
        val temp = array[0]
        array.removeAt(0)
        if (array.contains(targetSum - temp)){
            results.add(listOf(temp, targetSum - temp))
            array.remove(targetSum - temp)
        }
    }

    return results
}

fun twoNumSum2(array: MutableList<Int>, targetSum: Int): List<Int>{
    var indexOne = 0
    var indexTwo = array.size - 1
    var result = listOf<Int>()
    var sum = 0
    while (indexOne < indexTwo){
        sum = array[indexOne] + array[indexTwo]
        if (sum < targetSum) indexOne ++
        if (sum > targetSum) indexTwo --
        if (sum == targetSum){
            result = listOf(array[indexOne], array[indexTwo])
            break
        }
    }
    return result
}

fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
    var index = 0
    var tempInterval: List<Int>
    var results = mutableListOf<List<Int>>()
    var sortedIntervals = intervals.toMutableList().sortedWith(Comparator { i1, i2 ->  i1[0].compareTo(i2[0])})

    tempInterval = sortedIntervals[0]
    while (index < sortedIntervals.size - 1){
        if (tempInterval[1] >= sortedIntervals[index+1][0]){
            tempInterval = listOf(min(tempInterval[0], sortedIntervals[index+1][0]), max(tempInterval[1], sortedIntervals[index+1][1]))
        }else{
            results.add(tempInterval)
            tempInterval = sortedIntervals[index+1]
        }
        index ++
    }
    results.add(tempInterval)
    return results
}

fun isOverlap(intervalOne: List<Int>, intervalTwo: List<Int>): Boolean{
    return (intervalOne[1] >= intervalTwo[0] && intervalOne[1] <= intervalTwo[1])||
            (intervalTwo[1] >= intervalOne[0] && intervalTwo[1] <= intervalOne[1])
}

fun mergeInterval(intervalOne: List<Int>, intervalTwo: List<Int>): List<Int>{
    return listOf(min(intervalOne[0], intervalTwo[0]), max(intervalOne[1], intervalTwo[1]))
}



fun arrayOfProducts(array: List<Int>): List<Int> {
    val results = arrayListOf<Int>()
    var product = 1

    product = production(array)
    array.forEach {
        if (it != 0)
            results.add(product / it)
        else{
            val temArray = array.toMutableList()
            temArray.remove(0)
            results.add(production(temArray))
        }
    }
    return results
}

fun production(array: List<Int>): Int{
    var product = 1
    array.forEach {
        product *= it
    }
    return product
}



fun firstDuplicateValue(array: MutableList<Int>): Int {
    val seen = arrayListOf<Int>()

    array.forEach {
        if(seen.contains(it)) return it
        else seen.add(it)
    }

    return -1
}





fun longestPeak(array: List<Int>): Int {
    if (array.size < 3) return 0
    var currentLong = 0
    var maxLong = 0

    for (i in 1..array.size - 2){
        if (array[i-1] < array[i] && array[i+1] < array[i]){
            currentLong ++
            var left = i - 1
            var right = i + 1

            while (left >= 0 && array[left] < array[left+1]){
                currentLong ++
                left --
            }
            while (right < array.size && array[right] < array[right-1]){
                currentLong ++
                right ++
            }
            maxLong = max(currentLong, maxLong)
            currentLong = 0
        }
    }
    return maxLong
}



fun spiralTraverse(array: List<List<Int>>): List<Int> {
    var top= 0
    var bottom = array.size - 1
    var left = 0
    var right = array[0].size - 1
    var results = arrayListOf<Int>()

    while (top <= bottom && left <= right){
        for (i in left..right){
            results.add(array[top][i])
        }
        for (i in top + 1..bottom){
            results.add(array[i][right])
        }
        for (i in right - 1 downTo left){
            if (top == bottom) break
            results.add(array[bottom][i])
        }
        for (i in bottom - 1 downTo top + 1){
            if (left == right) break
            results.add(array[i][left])
        }
        top ++
        bottom --
        left ++
        right --
    }
    return results
}

//fun spiralTraverse(array: List<List<Int>>): List<Int> {
//
//    var top= 0
//    var xPos = 0; var yPos = 0
//    var bottom = array.size - 1
//    var left = 0
//    var right = array[0].size - 1
//    var directionCount = 5
//    val size = array[0].size * array.size
//    var results = arrayListOf<Int>()
//
//    while (!(top == bottom && left == right)){
//        results.add(array[yPos][xPos])
//        if(yPos == top){
//            if(xPos < right){
//                xPos ++
//            }else{
//                yPos ++
//                left ++
//            }
//            continue
//        }
//        if(xPos == right){
//            if(yPos < bottom){
//                yPos ++
//            }else{
//                xPos --
//                top ++
//            }
//            continue
//        }
//        if(yPos == bottom){
//            if(xPos > left){
//                xPos --
//            }else{
//                yPos --
//                right --
//            }
//            continue
//        }
//        if(xPos == left){
//            if(yPos > top){
//                yPos --
//            }else{
//                xPos ++
//                bottom --
//            }
//            continue
//        }
//    }
//
//    return results
//}
















fun isMonotonic(array: List<Int>): Boolean {
    if (array.size <= 2) return true
    var isIncreasing = true
    var isDecreasing = true

    for (i in 0..array.size - 2){
        if (array[i + 1] > array[i]){
            isDecreasing = false
        }
        if (array[i + 1] < array[i]){
            isIncreasing = false
        }
    }
    return isIncreasing || isDecreasing
}


fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    if (array.size == 0) return array
    val results = mutableListOf<Int>()
    var count = 0

    array.forEach {
        if (it != toMove){
            results.add(it)
            count ++
        }
    }
    for (i in 0 until array.size - count){
        results.add(toMove)
    }
    return results
}




fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    // Write your code here.
    var distance = 0
    var indexOne = 0
    var indexTwo = 0
    var results = listOf<Int>()

    arrayOne.sort()
    arrayTwo.sort()
    distance = abs(arrayOne[0] - arrayTwo[0])
    while (indexOne < arrayOne.size && indexTwo < arrayTwo.size){
        val currentDistance = abs(arrayOne[indexOne] - arrayTwo[indexTwo])
        if(currentDistance < distance){
            distance = currentDistance
            results = listOf(arrayOne[indexOne], arrayTwo[indexTwo])
        }
        if(arrayOne[indexOne] < arrayTwo[indexTwo]){
            indexOne ++
        }else{
            indexTwo ++
        }
    }
    return results
}




fun nonConstructibleChange(coins: MutableList<Int>): Int {
    // Write your code here.
    coins.sort()
    var currentChange = 0
    coins.forEach {
        if (it > currentChange + 1)
            return currentChange + 1
        currentChange += it
    }
    return currentChange + 1
}


//fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
//    // Write your code here
//    val result: MutableList<MutableList<Int>> = mutableListOf()
//    array.sort()
//    array.forEach(fun(item: Int) {
//        val subArray = array.toMutableList()
//        subArray.remove(item)
//        val twoSumArray = twoNumberSum(subArray, targetSum - item)
//        if (twoSumArray.size > 0) {
//            twoSumArray.forEach {
//                if (item < it[0]){
//                    val triplet = mutableListOf(item)
//                    triplet.addAll(it)
//                    result.add(triplet)
//                }
//            }
//        }
//    })
//    return result
//}


fun twoNumberSum(subArray: MutableList<Int>, sum: Int): MutableList<List<Int>>{
    val result: MutableList<List<Int>> = mutableListOf()
    subArray.forEach {
        if(subArray.contains(sum - it)){
           if (subArray.indexOf(sum - it) != subArray.indexOf(it)) {
               if(it <= sum/2){
                   result.add(listOf(it, sum - it))
               }
           }
        }
    }
    return result
}


fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    // Write your code here.
    val competiterList = hashMapOf<String, Int>()
    var maxValue = 0
    var champion = ""
    for (i in competitions.indices){
        val winner = competitions[i][1 - results[i]]
        if (!competiterList.containsKey(winner)){
            competiterList[winner] = 1
        }else{
            competiterList[winner] =  competiterList[winner]!! + 1
        }
    }
    competiterList.forEach{
        if(it.value > maxValue){
            maxValue = it.value
            champion = it.key
        }
    }
    return champion
}


fun sortedSquaredArray(array: List<Int>): List<Int> {
    // Write your code here.
    val resultList = ArrayDeque<Int>()
    var leftIndex = 0
    var rightIndex = array.size - 1
    while (leftIndex <= rightIndex){
        if(abs(array[leftIndex]) <= abs(array[rightIndex])){
            resultList.push(array[rightIndex] * array[rightIndex])
            rightIndex --
        }else{
            resultList.push(array[leftIndex] * array[leftIndex])
            leftIndex ++
        }
    }
    return resultList.toMutableList()
}

