


fun main(){
    testCase()
}

fun testCase() {
    println(phoneNumberMnemonics("1905"))
}







/**
 * Question 6
 */
fun staircaseTraversal(height: Int, maxSteps: Int): Int {
    return -1
}



/**
 * Question 5
 */
fun phoneNumberMnemonics(phoneNumber: String): List<String> {
    val result = mutableListOf<String>()
    phoneNumberMnemonicsHelper(phoneNumber, String(), result)
    return result
}


fun phoneNumberMnemonicsHelper(remainedNumber: String, string: String, result: MutableList<String>){
    val tempChar = remainedNumber[0]

    val tempCharList = alphabetPair[tempChar] ?: return
    for (i in tempCharList.indices){
        val tempString = string.plus(tempCharList[i])
        if (remainedNumber.length == 1){
            result.add(tempString)
        }else{
            phoneNumberMnemonicsHelper(remainedNumber.substring(1, remainedNumber.length), tempString, result)
        }
    }
}

val alphabetPair :MutableMap<Char, List<Char>> = mutableMapOf(
    '0' to listOf('0'),
    '1' to listOf('1'),
    '2' to listOf('a', 'b', 'c'),
    '3' to listOf('d', 'e', 'f'),
    '4' to listOf('g', 'h', 'i'),
    '5' to listOf('j', 'k', 'l'),
    '6' to listOf('m', 'n', 'o'),
    '7' to listOf('p', 'q', 'r', 's'),
    '8' to listOf('t', 'u', 'v'),
    '9' to listOf('w', 'x', 'y', 'z'))

/**
 * Question 4
 */
fun powerset(array: List<Int>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    powersetHelper(array, result)
    result.add(array)
    return result
}

fun powersetHelper(array: List<Int>, result: MutableList<List<Int>>){
    if (array.isEmpty()) return
    for (i in array.indices){
        val tempArray = array.toMutableList()
        tempArray.removeAt(i)
        if (!result.contains(tempArray)){
            result.add(tempArray)
        }
        powersetHelper(tempArray, result)
    }
}


/**
 * Question 3
 */
fun getPermutations(array: List<Int>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    getPermutationsHelper(result, array, listOf())
    return result
}

fun getPermutationsHelper(result: MutableList<List<Int>>, remainedArray: List<Int>, tempArray: List<Int>){
    for (i in remainedArray.indices){
        val duplicatedRemain = remainedArray.toMutableList()
        val duplicatedTemp = tempArray.toMutableList()
        duplicatedTemp.add(duplicatedRemain[i])
        duplicatedRemain.removeAt(i)
        if(duplicatedRemain.isEmpty()){
            result.add(duplicatedTemp)
        }else{
            getPermutationsHelper(result, duplicatedRemain, duplicatedTemp)
        }
    }
}


/**
 * Question 2
 */
fun productSum(array: List<*>): Int {
    return productSumHelper(array, 1)
}

fun productSumHelper(array: List<*>, depth: Int): Int{
    var sum = 0
    for (item in array){
        if (item is List<*>){
            sum += productSumHelper(item, depth + 1)
        }
        if (item is Int){
            sum += item
        }
    }
    return sum * depth
}




/**
 * Question 1
 */

fun getNthFib(n: Int): Int {
    if(n == 1) return 0
    if(n == 2) return 1
    val lastTwo = getFibHelper(n)
    return lastTwo.first + lastTwo.second
}

fun getFibHelper(n: Int): Pair<Int, Int>{
    if (n == 3) return Pair(0, 1)
    val lastTwo = getFibHelper(n-1)
    return Pair(lastTwo.second, lastTwo.first + lastTwo.second)
}

fun getNthFib2(n: Int): Int {
    if(n == 1) return 0
    if(n == 2) return 1
    return getNthFib2(n-1) + getNthFib2(n-2)
}