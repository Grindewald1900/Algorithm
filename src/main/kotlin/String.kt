/**
 * Algo Expert
 * @author Yee
 * 1. Palindrome Check
 * **/

























fun main(args: Array<String>){
    caesarCipherEncryptor("abcxyz", 2)
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