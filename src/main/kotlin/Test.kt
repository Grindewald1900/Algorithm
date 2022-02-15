

fun main(){
    testCaseOne()
}

fun testCaseOne(){
    val listOne = listOf(1,2,3,4,5)
    val listTwo = listOf(5,4,3,2,1)
    val listThree = listOf(1,2,3,4,5)

    println(System.identityHashCode(listOne))
    println(System.identityHashCode(listTwo))
    println(System.identityHashCode(listThree))
    println(listOne == listThree)

    val strOne = "aaa"
    val strTwo = "aaa"
    println(System.identityHashCode(strOne))
    println(System.identityHashCode(strTwo))
    println(strOne == strTwo)

}