import java.util.*

/**
 * Algo Expert
 * @author Yee
 * 1. Min Max Stack Construction
 * **/

fun main(){
    println(nextGreaterElement(listOf(2, 5, -3, -4, 6, 7, 2).toMutableList()))
}

/** Question-5 **/
fun nextGreaterElement(array: MutableList<Int>): MutableList<Int> {
    val mList = array.toMutableList()
    val size = array.size
    val result = mutableListOf<Int>()
    mList.addAll(array)
    for (i in 0 until size){
        var hasLargerValue = false
        for (j in i + 1 until mList.size){
            if (mList[j] > array[i]){
                result.add(mList[j])
                hasLargerValue = true
                break
            }
        }
        if (!hasLargerValue){
            result.add(-1)
        }
    }
    return result
}


/** Question-4 **/
fun sortStack(stack: MutableList<Int>): MutableList<Int> {
    // Write your code here.
    val tempStack = mutableListOf<Int>()
    tempStack.add(stack.last())
    stack.removeAt(stack.size - 1)
    while (stack.isNotEmpty())
        sortTempStack(stack, tempStack, stack.last())
    return tempStack
}

fun sortTempStack(stack: MutableList<Int>, tempStack: MutableList<Int>, tempValue: Int){
    println("Stack: $stack")
    println("TempStack: $tempStack")
    println("Value: $tempValue")
    println()
    if (stack.isEmpty()) return
    if(tempStack.isEmpty()){
        println("Temp is empty")
        tempStack.add(stack.last())
        stack.removeAt(stack.size - 1)
        sortTempStack(stack, tempStack, stack.last())
        return
    }

    if(tempValue > tempStack.last()){
        stack.removeAt(stack.size - 1)
        tempStack.add(tempValue)
    }else{
        stack.removeAt(stack.size - 1)
        stack.add(tempStack.last())
        stack.add(tempValue)
        tempStack.removeAt(tempStack.size - 1)
        sortTempStack(stack, tempStack, stack.last())
    }
}



/** Question-3 **/
fun sunsetViews(buildings: List<Int>, direction: String): List<Int> {
    // Write your code here.
    var tempMax = 0
    var result = mutableListOf<Int>()
    var buildingList =
        if (direction == "EAST") buildings.reversed()
    else buildings

    for (i in buildingList.indices){
        if (buildingList[i] > tempMax){
            result.add(i)
            tempMax = buildingList[i]
        }
    }
    if (direction == "EAST"){
        for (i in result.indices)
            result[i] = buildingList.size - 1 - result[i]
        result = result.reversed().toMutableList()
    }
    return result
}

/** Question-2 **/
fun balancedBrackets(str: String): Boolean {
    val bracketMap: Map<Char, Char> = mapOf(')' to '(', ']' to '[', '}' to '{')
    val bracketList = listOf<Char>('(', '[', '{', '}', ']', ')')
    val bracketStack = Stack<Char>()
    for (i in str.indices){
        println("$i $bracketStack")
        if (!bracketList.contains(str[i]))
            continue
        if(bracketStack.isEmpty()){
            bracketStack.push(str[i])
            continue
        }
        if (bracketStack.peek() != bracketMap[str[i]])
            bracketStack.push(str[i])
        else
            bracketStack.pop()
    }
    return bracketStack.isEmpty()
}


/** Question-1 **/
// Feel free to add new properties and methods to the class.
open class MinMaxStack() {
    private val stack = mutableListOf<Int>()
    fun peek(): Int? {
        return stack.last()
    }

    fun pop(): Int? {
        val value = stack.last()
        stack.removeAt(stack.size-1)
        return value
    }

    fun push(number: Int) {
        stack.add(number)
    }

    fun getMin(): Int? {
        var tempMin = Int.MAX_VALUE
        stack.forEach{
            if (it < tempMin)
                tempMin = it
        }
        return tempMin
    }

    fun getMax(): Int? {
        var tempMax = Int.MIN_VALUE
        stack.forEach{
            if (it > tempMax)
                tempMax = it
        }
        return tempMax
    }
}