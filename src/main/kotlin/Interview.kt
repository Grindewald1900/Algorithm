/**
 * Author: Yi Ren
 * Email: grindewald1504@gmail.com
 * Android coding question from Nuvyyo.
 */


fun main(){
    println(checkPostalCode("123"))
    println(checkPostalCode("VG"))
    println(checkPostalCode("VG1"))
    println(checkPostalCode("RD12345"))

}

fun checkPostalCode(postalCode: String): Int {
    val size = postalCode.length
    if (size < 3) return -1
    if(!postalCode[0].isUpperCase() || !postalCode[1].isUpperCase()) return -1
    if (size < 7) return 0
    return 1
}