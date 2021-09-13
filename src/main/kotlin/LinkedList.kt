/**
 * Algo Expert
 * @author Yee
 * 1. Remove duplicates from linked list
 * **/

fun main(){
    val list = removeDuplicatesFromLinkedList(addMany(LinkedList(1), listOf(1, 3, 4, 4, 4, 5, 6, 6)))
    println(getNodesInArray(list))
}

fun addMany(linkedList: LinkedList, values: List<Int>): LinkedList {
    var current = linkedList
    while (current.next != null) {
        current = current.next!!
    }
    for (value in values) {
        current.next = LinkedList(value)
        current = current.next!!
    }
    return linkedList
}

fun getNodesInArray(linkedList: LinkedList?): List<Int> {
    val nodes = mutableListOf<Int>()
    var current: LinkedList? = linkedList
    while (current != null) {
        nodes.add(current.value)
        current = current.next
    }
    return nodes
}
/** Question-1 **/
// This is an input class. Do not edit.
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
    if (linkedList.next == null) return linkedList
    isSameValue(linkedList)
    return linkedList
}

fun isSameValue(nodeOne: LinkedList){
    if (nodeOne.next!!.next == null){
        if (nodeOne.value == nodeOne.next!!.value){
            nodeOne.next = null
        }
    }else{
        if (nodeOne.value == nodeOne.next!!.value){
            nodeOne.next = nodeOne.next!!.next
            isSameValue(nodeOne)
        }else{
            isSameValue(nodeOne.next!!)
        }
    }
}