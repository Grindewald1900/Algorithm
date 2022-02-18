import kotlin.math.max
import kotlin.math.min

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = BST(value)
            } else {
                this.left!!.insert(value)
            }
        } else {
            if (this.right == null) {
                this.right = BST(value)
            } else {
                this.right!!.insert(value)
            }
        }
    }
}




fun TestCase1() {
    val array = listOf(8, 5, 11, -1, 3, 4, 2)
    println(rightSmallerThan(array))
}

fun main(){
    TestCase1()
}


/**
 * Question 8
 */
open class RightSmallerBST(v: Int, id: Int){
    var id = id
    var value = v
    var left: RightSmallerBST? = null
    var right: RightSmallerBST? = null
    var leftCount = 0
}

fun rightSmallerThan(array: List<Int>): List<Int> {
    val count = mutableListOf<Int>()
    if (array.isEmpty()) return listOf()

    var root = RightSmallerBST(array[0], 0)
    for (i in 1 until array.size){
        insertToRightSmallBST(root, array[i], i)
    }
    for (i in array.indices){
        count.add(searchSmallCount(root, i))
    }
    return count
}

fun insertToRightSmallBST(node: RightSmallerBST, v: Int, id: Int){
    if (v < node.value){
        node.leftCount++
        if (node.left == null)
            node.left = RightSmallerBST(v, id)
        else
            insertToRightSmallBST(node.left!!, v, id)
        traverseAdd(node.right, 1)
    }else{
        if (node.right == null)
            node.right = RightSmallerBST(v, id)
        else
            insertToRightSmallBST(node.right!!, v, id)
    }
}

fun searchSmallCount(node: RightSmallerBST, id: Int): Int{
    if (node.id == id) return node.leftCount
    if (node.left == null && node.right == null){
        return -1
    }else{
        if (node.left != null){
            val leftResult = searchSmallCount(node.left!!, id)
            if (leftResult >= 0) return leftResult
        }
        if (node.right != null){
            val rightResult = searchSmallCount(node.right!!, id)
            if (rightResult >= 0) return rightResult
        }
        return -1
    }
}

fun traverseAdd(node: RightSmallerBST?, v: Int){
    if (node == null) return
    node.leftCount += v
    traverseAdd(node.left, v)
    traverseAdd(node.right, v)
}


fun rightSmallerThan2(array: List<Int>): List<Int> {
    val result = mutableListOf<Int>()

    for (i in array.indices){
        var count = 0
        for (j in i+1 until array.size){
            if (array[j] < array[i]) count++
        }
        result.add(count)
    }
    return result
}


/**
 * Question 7
 */
fun validateThreeNodes(nodeOne: BST, nodeTwo: BST, nodeThree: BST): Boolean {
    if (isAncestor(nodeOne, nodeTwo.value) && isAncestor(nodeTwo, nodeThree.value)) return true
    if (isAncestor(nodeThree, nodeTwo.value) && isAncestor(nodeTwo, nodeOne.value)) return true
    return false
}

// return true if A is ancestor of B
fun isAncestor(node: BST?, value: Int): Boolean{
    var hasValue = false
    if (node == null) return false
    if (node.value == value) return true
    if(isAncestor(node.left, value)) hasValue = true
    if(isAncestor(node.right, value)) hasValue = true
    return hasValue
}


/**
 * Question 6
 */
fun sameBsts(arrayOne: List<Int>, arrayTwo: List<Int>): Boolean {
    if (arrayOne.size != arrayTwo.size) return false
    if (arrayOne.isEmpty() && arrayTwo.isEmpty()) return true
    if (arrayOne == arrayTwo) return true
    if (arrayOne.first() != arrayTwo.first()) return false

    var isSame = true
    val arrayOneSmall = mutableListOf<Int>()
    val arrayTwoSmall = mutableListOf<Int>()
    val arrayOneBig = mutableListOf<Int>()
    val arrayTwoBig = mutableListOf<Int>()

    for (i in 1 until arrayOne.size){
        if (arrayOne[i] >= arrayOne.first()){
            arrayOneBig.add(arrayOne[i])
        }else{
            arrayOneSmall.add(arrayOne[i])
        }
        if(arrayTwo[i] >= arrayTwo.first()){
            arrayTwoBig.add(arrayTwo[i])
        }else{
            arrayTwoSmall.add(arrayTwo[i])
        }
    }


    if (!sameBsts(arrayOneBig, arrayTwoBig)) isSame = false
    if (!sameBsts(arrayOneSmall, arrayTwoSmall)) isSame = false
    return isSame
}

//fun sameBstHelper(arrayOne: List<Int>, arrayTwo: List<Int>): Boolean{
//
//}

/**
 * Question 5
 */
fun reconstructBst(preOrderTraversalValues: List<Int>): BST? {
    val root = BST(preOrderTraversalValues[0])
    reconstructHelper(root, preOrderTraversalValues)
    return root
}

fun reconstructHelper(node: BST, list: List<Int>){
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()
    if (list.isEmpty()) return

    for (i in 1 until list.size){
        if (list[i] >= node.value){
            rightList.add(list[i])
        }else{
            leftList.add(list[i])
        }
    }
    node.value = list[0]
    if (leftList.isNotEmpty()) {
        node.left = BST(leftList[0])
        reconstructHelper(node.left!!, leftList)
    }
    if (rightList.isNotEmpty()) {
        node.right = BST(rightList[0])
        reconstructHelper(node.right!!, rightList)
    }
}


/**
 * Question 4
 */
fun findKthLargestValueInBst(tree: BST, k: Int): Int {
    val list = mutableListOf<Int>()
    kthLargestValueHelper(tree, k, list)
    println(list)
    return list.last()
}

fun kthLargestValueHelper(tree: BST?, k: Int, list: MutableList<Int>): Boolean{
    if (tree != null){
        if(kthLargestValueHelper(tree.right, k, list)) return true
        list.add(tree.value)
        if (list.size == k) return true
        if(kthLargestValueHelper(tree.left, k, list)) return true
    }
    return false
}


/**
 * Question 4
 */
fun minHeightBst(array: List<Int>): BST {
    val size = array.size
    val index = getMediumIndex(size)
    val tree = BST(array[index])
    minHeightBstHelper(tree, array.subList(0, index))
    minHeightBstHelper(tree, array.subList(index + 1, size))
    return tree
}

fun minHeightBstHelper(tree: BST, array: List<Int>){
    val size = array.size
    if (size == 0) return
    val index = getMediumIndex(size)
    tree.insert(array[index])
    minHeightBstHelper(tree, array.subList(0, index))
    minHeightBstHelper(tree, array.subList(index + 1, size))
}

fun getMediumIndex(size: Int): Int{
    if (size == 1) return 0
    return if (size%2 == 0){
        size/2
    }else{
        (size-1)/2
    }
}

/**
 * Question 3
 */
fun inOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    inOrderHelper(tree, array)
    return array
}

fun preOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    preOrderHelper(tree, array)
    return array
}

fun postOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    postOrderHelper(tree, array)
    return array
}


fun inOrderHelper(node: BST?, array: MutableList<Int>){
    if(null == node) return
    inOrderHelper(node.left, array)
    array.add(node.value)
    inOrderHelper(node.right, array)
}

fun preOrderHelper(node: BST?, array: MutableList<Int>){
    if(null == node) return
    array.add(node.value)
    preOrderHelper(node.left, array)
    preOrderHelper(node.right, array)
}

fun postOrderHelper(node: BST?, array: MutableList<Int>){
    if(null == node) return
    postOrderHelper(node.left, array)
    postOrderHelper(node.right, array)
    array.add(node.value)
}


/**
 * Question 2
 */
fun validateBst(tree: BST): Boolean {
    return validateBstHelper(tree, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun validateBstHelper(tree: BST?, minValue: Int, maxValue: Int): Boolean{
    if (tree == null) return true
    if (tree.value < minValue || tree.value >= maxValue) return false
    return validateBstHelper(tree.left, minValue, tree.value) && validateBstHelper(tree.right, tree.value, maxValue)
}

fun validateBst_1(tree: BST): Boolean {
    var isValid = true

    if (tree.left != null){
        val values = mutableListOf<Int>()
        getAllValue(tree.left!!, values)
        val maxValue = values.max()
        if (maxValue!! >= tree.value){
            isValid = false
        }else{
            if(!validateBst_1(tree.left!!)){
                isValid = false
            }
        }
    }
    if (tree.right != null){
        val values = mutableListOf<Int>()
        getAllValue(tree.right!!, values)
        val minValue = values.min()
        if (minValue!! < tree.value){
            isValid = false
        }else{
            if(!validateBst_1(tree.right!!)){
                isValid = false
            }
        }
    }
    return isValid
}

fun getAllValue(node: BST, list: MutableList<Int>){
    list.add(node.value)
    if (node.left != null){
        getAllValue(node.left!!, list)
    }
    if (node.right != null){
        getAllValue(node.right!! ,list)
    }
}


/**
 * Question 1
 */
//open class BST(value: Int) {
//    var value = value
//    var left: BST? = null
//    var right: BST? = null
//
//    fun insert(v: Int): BST{
//        if (v < value){
//            if (left == null){
//                left = BST(v)
//                println("insert $v")
//            }else{
//                left!!.insert(v)
//            }
//
//        }else{
//            if (right == null){
//                right = BST(v)
//                println("insert $v")
//            }else{
//                right!!.insert(v)
//            }
//        }
//        return this
//    }
//
//
//    fun remove(v: Int, parent: BST? = null): BST{
//        if (value < this.value){
//            if (this.left != null){
//                this.left!!.remove(v, this)
//            }
//        }else if (v > this.value){
//            if(this.right != null){
//                this.right!!.remove(v, this)
//            }
//        }else {
//            if (left != null && right != null){
//                value =  right!!.getMinValue()
//                right!!.remove(value, this)
//            } else if (parent == null){
//                if(left != null){
//                    value = left!!.value
//                    left = left!!.left
//                    right = left!!.right
//                }else if(right != null){
//                    value = right!!.value
//                    right = right!!.right
//                    left = right!!.left
//                }
//            }else if (this == parent.left){
//                parent.left = if (left != null) left!! else right
//            }else if (this == parent.right){
//                parent.right = if (left != null) left!! else right
//            }
//        }
//        return this
//    }
//
//    private fun getMinValue(): Int{
//        return if (this.left == null){
//            this.value
//        }else{
//            this.left!!.getMinValue()
//        }
//    }
//
//    fun contains(v: Int): Boolean{
//        var isContain = false
//        if (value == v){
//            println("contains $v")
//            isContain = true
//        }else{
//            if (left != null){
//                if(left!!.contains(v)){
//                    isContain = true
//                }
//            }
//            if (right != null){
//                if(right!!.contains(v)){
//                    isContain = true
//                }
//            }
//        }
//        return isContain
//    }
//
//    fun traverse(){
//        println("Value: $value")
//        if (left != null){
//            println("Left: ${left!!.value}")
//        }
//        if(right != null){
//            println("Right: ${right!!.value}")
//        }
//        println()
//        if (left != null){
//            left!!.traverse()
//        }
//        if(right != null){
//            right!!.traverse()
//        }
//    }
//
//}