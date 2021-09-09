/**
 * Algo Expert
 * @author Yee
 * 1. Palindrome Check
 * **/


fun main(){
    reverseWordsInString("AlgoExpert is the best!")
}

/** Question-9 **/
fun reverseWordsInString(string: String): String {
    // Write your code here.
    var stringList = mutableListOf<String>()
    var spaceList = mutableListOf<String>()
    var tempString = ""
    var result = ""
    var isSpace = false

    for (i in string.indices){
        if (string[i] == ' '){
            if (!isSpace){
                stringList.add(tempString)
                tempString = ""
            }
            isSpace = true
            tempString += " "
        }else{
            if (isSpace){
                spaceList.add(tempString)
                tempString = ""
            }
            isSpace = false
            tempString += string[i]
        }
    }
    if (isSpace)
        spaceList.add(tempString)
    else
        stringList.add(tempString)
    for (i in stringList.indices.reversed()){
        if (i < spaceList.size )
            result += spaceList[i]
        result += stringList[i]

    }
    return result
}




/** Question-8 **/
fun validIPAddresses(string: String): List<String> {
    // Write your code here.
    val size = string.length
    var result = mutableListOf<String>()
    if (size < 4 || size > 12) return listOf()

    for (i in 1 until size - 2){
        for (j in i+1 until size - 1){
            for(k in j+1 until size){
                if (i > 3 || j - i > 3 || k - j > 3 || size - k > 3) {
                    continue
                }else if (string[0] == '0' && i > 1){
                    continue
                }else if (string[i] == '0' && j - i > 1){
                    continue
                }else if (string[j] == '0' && k - j > 1){
                    continue
                }else if (string[k] == '0' && size - k > 1){
                    continue
                }else if(string.substring(0,i).toInt() > 255 || string.substring(i,j).toInt() > 255 || string.substring(j,k).toInt() > 255 || string.substring(k,size).toInt() > 255){
                    continue
                }
                result.add("${string.substring(0,i)}.${string.substring(i,j)}.${string.substring(j,k)}.${string.substring(k,size)}")
            }
        }
    }
    return result
}


/** Question-6 **/
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