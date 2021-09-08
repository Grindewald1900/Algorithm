import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val input = mutableListOf(
        mutableListOf(1),
    )
    print(minimumPassesOfMatrix(input))
}


/** Graph Question-8 **/
lateinit var mMatrix: MutableList<MutableList<Int>>
var width = 0
var height = 0
var isChanged = true

fun minimumPassesOfMatrix(matrix: MutableList<MutableList<Int>>): Int {
    // Write your code here.
    isChanged = true
    var path = -1
    val positiveMatrix: MutableList<MutableList<Int>> = mutableListOf()
    mMatrix = matrix
    height = mMatrix.size
    width = mMatrix[0].size

    while (isChanged){
        isChanged = false
        for (i in mMatrix.indices){
            for (j in mMatrix[0].indices){
                if(mMatrix[i][j] > 0){
                    print("i $i, j $j, value ${mMatrix[i][j]} \n")
                    positiveMatrix.add(mutableListOf(i, j))
                }
            }
        }
        positiveMatrix.forEach {
            convertNegative(it[0], it[1])
        }

        path ++
    }
    for (i in mMatrix.indices){
        for (j in mMatrix[0].indices){
            if (mMatrix[i][j] < 0)
                path = -1
        }
    }
    return path
}


fun isValidPosition(i: Int, j: Int): Boolean{
    var isValid = false
    if (i > -1 && i < height){
        if (j > -1 && j < width){
            isValid = true
        }
    }
    return isValid
}

fun convertNegative(i: Int, j: Int){
    if (isValidPosition(i - 1, j))
        changeValue(i - 1, j)
    if (isValidPosition(i + 1, j))
        changeValue(i + 1, j)
    if (isValidPosition(i, j - 1))
        changeValue(i, j - 1)
    if (isValidPosition(i, j + 1))
        changeValue(i, j + 1)
}

fun changeValue(i: Int,j: Int){
    if (mMatrix[i][j] < 0){
        mMatrix[i][j] *= -1
        isChanged = true
    }
}


/** Graph Question-7 **/
var size = 0
var isCycle = false
fun cycleInGraph(edges: List<List<Int>>): Boolean {
    // Write your code here.
    size = edges.size
    isCycle = false
    for (i in edges.indices){
        ifCycle(i, i, 0, edges)
    }
    return isCycle
}

fun ifCycle(vertex: Int, target: Int, level: Int, edges: List<List<Int>>){
    if(level > size) return
    edges[vertex].forEach {
        if(it == target){
            isCycle = true
        }else{
            ifCycle(it, target, level+1, edges)
        }
    }
}



/** Graph Question-6 **/
//lateinit var mMatrix: List<MutableList<Int>>
//var height = 0
//var width = 0
fun removeIslands(matrix: List<MutableList<Int>>): List<MutableList<Int>> {
    // Write your code here.
//    mMatrix = matrix
    height = matrix.size
    width = matrix[0].size

    for(i in 0 until width){
        labelLand(0, i)
        labelLand(height-1, i)
    }
    for(i in 0 until height){
        labelLand(i, 0)
        labelLand(i, width-1)
    }

    for(i in 0 until height){
        for(j in 0 until width){
            if(mMatrix[i][j] == 1)
                mMatrix[i][j] = 0
            if(mMatrix[i][j] == 2)
                mMatrix[i][j] = 1

        }
    }

    return matrix
}

fun labelLand(i: Int, j: Int){
    print("Position: x: $i , y: $j \n")
    if(mMatrix[i][j] == 1){
        mMatrix[i][j] = 2
        if(i > 0)
            labelLand(i - 1, j)
        if(i < height-1)
            labelLand(i + 1, j)
        if(j > 0)
            labelLand(i, j - 1)
        if(j < width-1)
            labelLand(i, j + 1)
    }
}


/** Graph Question-4 **/
//var size = 0
//var mMatrix: ArrayList<ArrayList<Int>> = ArrayList()
//var height = 0
//var width = 0

fun riverSizes(matrix: List<List<Int>>): List<Int> {
    // Write your code here.
    val result: MutableList<Int> = mutableListOf()
    height = matrix.size
    width = matrix[0].size
    mMatrix.clear()
    size = 0

    for (i in 0 until height){
        mMatrix.add(ArrayList(matrix[i]))
    }

    for (i in 0 until height){
        for (j in 0 until width){
            size = 0
            if (mMatrix[i][j] == 1){
                size++
                mMatrix[i][j] = 0
                ifNeighbourRiver(i, j)
            }
            if(size > 0){
                result.add(size)
            }
        }
    }
    return result
}

fun ifNeighbourRiver(i: Int, j: Int){
    if(j < width-1 && mMatrix[i][j+1] == 1){
        size++
        mMatrix[i][j+1] = 0
        ifNeighbourRiver(i, j+1)
    }
    if(i < height-1 && mMatrix[i+1][j] == 1){
        size++
        mMatrix[i+1][j] = 0
        ifNeighbourRiver(i+1, j)
    }
    if(j > 0 && mMatrix[i][j-1] == 1){
        size++
        mMatrix[i][j-1] = 0
        ifNeighbourRiver(i, j-1)
    }
    if(i > 0 && mMatrix[i-1][j] == 1){
        size++
        mMatrix[i-1][j] = 0
        ifNeighbourRiver(i-1, j)
    }
}


/** Graph Question-1 **/
class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()
    val stack = Stack<Node>()
    fun depthFirstSearch(): List<String> {
        // Write your code here.
        val list = mutableListOf<String>()
        stack.push(this)
        list.add(name)
        while (!stack.isEmpty()){
            val current = stack.pop()
            list.add(current.name)
            print("${current.name}  \n")

           current.children.asReversed().forEach {
                stack.push(it)
           }
        }
        return list
    }
}

/** Graph Question-2 **/
fun hasSingleCycle(array: List<Int>): Boolean {
    // Write your code here.
    val copyList = mutableListOf<Int>()
    var index = 0
    copyList.addAll(0, array)

    for (i in array.indices){
        copyList[index] = 0
        index += array[index]
        index = checkBound(index, array.size)
    }
    index = checkBound(index, array.size)
    copyList.forEach {
        if (it != 0) return false
    }
    return index == 0
}

fun checkBound(index: Int, size: Int): Int{
    var result: Int = index
    if(index > size - 1)
        result = index % size
    if(index < 0)
        result = index % size + size
    return result
}


