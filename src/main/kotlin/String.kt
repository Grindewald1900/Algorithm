/**
 * Algo Expert
 * @author Yee
 * 1. Palindrome Check
 * **/


fun main(){
    println(longestPalindromicSubstring("a"))
}

/** Question-6 **/
fun longestPalindromicSubstring(string: String): String {
    // Write your code here.
    var maxString = ""
    if(string.length == 1) return string

    for (i in string.indices){
        println("i $i")
        for (j in string.lastIndex downTo  i + 1){
//            println("i $i, j $j")
            if (isPalindromic(i, j, string)){
                if (j - i > maxString.length){
                    maxString = string.substring(i, j+1)
                }
                break
            }
        }
    }
    return maxString
}

fun isPalindromic(start: Int, end:Int, string: String): Boolean{
    var startIndex = start
    var endIndex = end
    while (startIndex <= endIndex){
        if (string[startIndex] == string[endIndex]){
            startIndex ++
            endIndex --
        }else{
            return false
        }
    }
    return true
}


/** Question-5 **/
fun firstNonRepeatingCharacter(string: String): Int {
    // Write your code here.
    var subString: MutableList<Char>

    for (i in string.indices){
        subString = string.toMutableList()
        subString.removeAt(i)
        if (!subString.contains(string[i]))
            return i
    }
    return -1
}

/** Question-4 **/
fun generateDocument(characters: String, document: String): Boolean {
    // Write your code here.
    val size = document.length
    val charList = characters.toMutableList()
    var isSuccess = true
    for (i in 0 until size){
        if (charList.contains(document[i])){
            charList.remove(document[i])
        }else{
            isSuccess = false
        }
    }
    return isSuccess
}


/** Question-3 **/
fun runLengthEncoding(string: String): String {
    // Write your code here.
    var result = ""
    var tempChar: Char = string[0]
    var count: Int = 1
    val mString = "$string "

    for(i in 1 until mString.length){
        if (mString[i] == tempChar && i < mString.length - 1){
            count ++
        }else{
            if(count > 9){
                val loops: Int = count / 9
                val remainder: Int = count % 9
                for (j in 1..loops){
                    result += "9$tempChar"
                }
                result = result + remainder + tempChar
            }else{
                result = result + count + tempChar
            }
            count = 1
            tempChar = mString[i]
        }
    }
    return result
}


/** Question-2 **/
fun caesarCipherEncryptor(string: String, key: Int): String {
    // Write your code here.
    var result = ""
    for (i in string.indices)
        result += ((string[i] + 26 + key - 'a') % 26 + 'a'.toInt()).toChar().toString()
    return result
}


/** Question-1 **/
fun isPalindrome(string: String): Boolean {
    // Write your code here.
    var i = 0
    var j = string.length - 1
    while (i <= j){
        if(string[i] != string[j])
            return false
        i++
        j--
    }
    return true
}