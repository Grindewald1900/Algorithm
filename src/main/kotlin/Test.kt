import java.util.*
import java.util.LinkedList
import java.util.function.Consumer
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(){
//    testCaseOne()
//    testCaseTwo()
    testCaseThree()
}

fun testCaseOne(){
    val listOne = listOf(1, 2, 3, 4, 5)
    val listTwo = listOf(5, 4, 3, 2, 1)
    val listThree = listOf(1, 2, 3, 4, 5)
    val arrayList = ArrayList<Int>(5)
    val hashMap = HashMap<String, String>()
    val linkedList = LinkedList<Int>()
    val it = hashMap.iterator()
    val itLink = linkedList.iterator()
    val itList = listOne.iterator()

    linkedList.add(1)
    linkedList.add(2)
    linkedList.add(3)

    hashMap["England"] = "London";
    hashMap["Germany"] = "Berlin";
    hashMap["Norway"] = "Oslo";
    hashMap["USA"] = "Washington DC";

    listOne.forEach { n -> println(n) }
}

fun testCaseTwo(){
    val list = mutableListOf(1, 2, 3, 4)
    val a = list[3]
    list.removeAt(3)
    println(a)
    println(list)

    var numberOne = 3
    var numberTwo = numberOne++
    var numberThree = ++numberOne
    println(numberTwo)
    println(numberThree)
    val car = Mazda()
    car.run()

}


fun testCaseThree(){
    val concurrencyTest = ConcurrencyTest()
//    concurrencyTest.start()
//    concurrencyTest.addition()
    val arrayList = ArrayList<Int>(5)
    arrayList.add(1)
    arrayList.add(2)

    val method = Consumer { n: Int? -> println(n) }
    val upperCase = {str: String -> str.toUpperCase()}
    val addition = {n1: Int, n2: Int -> n1 + n2}
    println(upperCase("aaa"))
    println(upperCase)
    println(addition(1,2))

}

fun testCaseFour(){
    var count = 0

}









class ConcurrencyTest(): Thread(){
    var amount = 0
    fun addition(){
        for (i in 1..10){
            amount++
            println("Thread 1: $amount")
        }
    }

    override fun run() {
        super.run()
        for (i in 1..10){
            amount++
            println("Thread 2: $amount")
        }
    }
}

class Main : Thread() {
    override fun run() {
        amount++
    }
    companion object {
        var amount = 0
        @JvmStatic
        fun main() {
            val thread = Main()
            thread.start()
            // Wait for the thread to finish
            while (thread.isAlive) {
                println("Waiting...")
            }
            // Update amount and print its value
            println("Main: " + amount)
            amount++
            println("Main: " + amount)
        }
    }
}
abstract class Vehicle(){
    abstract fun run()
    fun brand(){
        println("AAA")
    }
}

open class Parent(){
}

class Child: Parent(){
}

class Mazda: Vehicle(){
    override fun run() {
        println("Mazda run...")
        val scan = Scanner(System.`in`)
        val user = scan.nextLine()
        val age = scan.nextInt()
        println("User: $user")
        println("Age: $age")
    }
}


interface lambdaTest{
    fun doSomething(p1: Int)
}
enum class Level{
    LOW, MEDIUM, HIGH
}