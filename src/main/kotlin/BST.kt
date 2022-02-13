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

fun main(){
    TestCase1()
}

fun TestCase1() {
    val tree = BST(10)
    tree.left = BST(5)
    tree.left!!.left = BST(2)
    tree.left!!.left!!.left = BST(1)
    tree.left!!.right = BST(5)
    tree.right = BST(15)
    tree.right!!.right = BST(22)

    val a = inOrderTraverse(tree, mutableListOf())
    println(a)
    val b = preOrderTraverse(tree, mutableListOf())
    println(b)
    val c = postOrderTraverse(tree, mutableListOf())
    println(c)

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