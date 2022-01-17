import kotlin.math.max
import kotlin.math.min

/**
 * Algo Expert
 * @author Yee
 * 1. Remove duplicates from linked list
 * **/


fun main(){
    val array = listOf(2, 1)
    val result = minNumberOfCoinsForChange(3, array)
    println(result)
}


/**
 * Question 4
 */
/**
 * Question 3
 */
fun levenshteinDistance(str1: String, str2: String): Int {
    /** Example:
     *     val str1 = "abc"
     *     val str2 = "yabd"
     */
    val edit = MutableList(str2.length + 1){ MutableList(str1.length + 1){index -> index} }
    for (i in edit.indices){
        edit[i][0] = i
    }

    /** Edit:
     *    "", a, b, c
     * ""[[0, 1, 2, 3],
     * y  [1, 1, 2, 3],
     * a  [2, 1, 2, 3],
     * b  [3, 1, 2, 3],
     * d  [4, 1, 2, 3]]
     */

    /**
     * Each element in the 2d array indicates the number of operations
     * Like edit[2][1], a = a, so edit[2][1] means "ya" to "a" need 1 steps
     */
    for (i in 1 until str2.length + 1){
        for (j in 1 until str1.length + 1){
            if (str2[i - 1] == str1[j - 1]){
                edit[i][j] = edit[i - 1][j - 1]
            }else{
                edit[i][j] = min(edit[i - 1][j - 1], min(edit[i][j - 1], edit[i - 1][j])) + 1
            }
        }
    }

    /**
     * [[0, 1, 2, 3],
     *  [1, 1, 2, 3],
     *  [2, 1, 2, 2],
     *  [3, 3, 1, 2],
     *  [4, 4, 3, 2]]
     */

    return edit.last().last()
}




/**
 * Question 3
 */
var minCoin = Int.MAX_VALUE
fun minNumberOfCoinsForChange(n: Int, denoms: List<Int>): Int {
    val tempDenoms = denoms.toMutableList()
    minCoin = Int.MAX_VALUE
    tempDenoms.sort()
    while (tempDenoms.isNotEmpty()){
        getNumberOfCoins(n, tempDenoms, 0)
        tempDenoms.removeAt(tempDenoms.size - 1)
    }
    return if(minCoin == Int.MAX_VALUE){ -1 } else{minCoin}
}

fun getNumberOfCoins(amount: Int, denoms: MutableList<Int>, coins: Int){
    println("Amount: $amount denoms: ${denoms} coins: $coins")
    if(amount == 0){
        minCoin = min(minCoin, coins)
    }

    val tempDenoms: MutableList<Int> = mutableListOf()
    val tempCoin: Int
    var count = 1
    denoms.forEach {
        if (it <= amount){
            tempDenoms.add(it)
        }
    }
    if(tempDenoms.isEmpty()){
        return
    }
    if(amount < denoms.min()!!){
        return
    }

    tempCoin = tempDenoms.last()
    tempDenoms.removeAt(tempDenoms.size - 1)
    while (tempCoin * count <= amount){
        getNumberOfCoins(amount - tempCoin * count, tempDenoms, coins + count)
        count ++
    }
}

/**
 * Question 2
 */
fun numberOfWaysToMakeChange(n: Int, denoms: List<Int>): Int {
    // Write your code here.
    if (denoms.isEmpty()) return 0
    if (n == 0) return 1
    if (n < denoms.min()!!) return 0
    val resultList = mutableListOf<Int>()

    val mDenoms = mutableListOf<Int>()
    denoms.forEach {
        if (it <= n){
            mDenoms.add(it)
        }
    }
    for (i in 0 until mDenoms.size){
        getChange(n, mDenoms, resultList,true)
        mDenoms.removeAt(0)
    }


    return resultList.size
}

fun getChange(amount: Int, denomination: MutableList<Int>, result: MutableList<Int>, isInit: Boolean){
    if(amount == 0){
        result.add(1)
        return
    }
    if(denomination.isEmpty()){
        return
    }
    var tempValue = 0
    var tempItem = denomination[0]
    val tempDonom = denomination.toMutableList()
    tempDonom.removeAt(0)

    if (denomination[0] > amount){
        return
    }

    while (tempValue <= amount){
        if (!(isInit && tempValue == 0)){
            getChange(amount - tempValue, tempDonom, result, false)
        }
        tempValue += tempItem
    }
}




/**
 *  Question 1
 **/
fun maxSubsetSumNoAdjacent(array: List<Int>): Int {
    // Write your code here.
    val size = array.size
    val maxSum: MutableList<Int> = mutableListOf()
    var indexCurrent = 2
    if(array.isEmpty()){
        return  0
    }
    if(size == 1){
        return array[0]
    }
    if(size == 2){
        return max(array[0], array[1])
    }
    maxSum.add(0, array[0])
    maxSum.add(1, max(array[0], array[1]))

    while (indexCurrent < size){
        maxSum.add(indexCurrent, max(maxSum[indexCurrent - 1], maxSum[indexCurrent - 2] + array[indexCurrent]))
        indexCurrent ++
    }
    return maxSum.last()
}