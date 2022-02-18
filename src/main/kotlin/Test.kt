import java.util.*
import java.util.LinkedList
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(){
    testCaseOne()
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

    while (itList.hasNext()){
        println(itList.next())
    }
//    println(itLink.next())



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

}

class ConcurrencyTest(): Thread(){
    var amount = 0
    val thread = ConcurrencyTest()

    override fun run() {
        super.run()
        amount++
        println("Thread 2: $amount")
    }
}

class Main : Thread() {
    override fun run() {
        amount++
    }
    companion object {
        var amount = 0
        @JvmStatic
        fun main(args: Array<String>) {
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

enum class Level{
    LOW, MEDIUM, HIGH
}