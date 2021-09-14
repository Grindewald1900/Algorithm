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

/** Question-2 **/
class Node(value: Int) {
    val value = value
    var prev: Node? = null
    var next: Node? = null
}
class DoublyLinkedList {
    private var head: Node? = null
    private var tail: Node? = null

    fun setHead(node: Node) {
        if(head == null){
            head = node
            tail = node
        }else{
            insertBefore(head!!, node)
        }
    }

    fun setTail(node: Node) {
        if (tail == null){
            setHead(node)
        }else{
            insertAfter(tail!!, node)
        }
    }

    fun insertBefore(node: Node, nodeToInsert: Node) {
        if (node.prev != null){
            node.prev!!.next = nodeToInsert
            nodeToInsert.prev = node.prev
        }
        node.prev = nodeToInsert
        nodeToInsert.next = node
        if(nodeToInsert.prev == null){
            head = nodeToInsert
        }
    }

    fun insertAfter(node: Node, nodeToInsert: Node) {
        if (node.next != null){
            node.next!!.prev = nodeToInsert
            nodeToInsert.next = node.next
        }
        node.next = nodeToInsert
        nodeToInsert.prev = node
        if(nodeToInsert.next == null){
            tail = nodeToInsert
        }
    }

    fun insertAtPosition(position: Int, nodeToInsert: Node) {
        var tempNode = head
        if (position == 1){
            insertBefore(head!!, nodeToInsert)
            return
        }
        for (i in 1 until position){
            if (tempNode!!.next != null){
                tempNode = tempNode.next
            }
        }
        insertBefore(tempNode!!, nodeToInsert)
    }

    fun removeNodesWithValue(value: Int) {
        var node = head
        while (node != null){
            if (node.value == value){
                if(node.next != null){
                    node = node.next
                    remove(node!!.prev!!)
                }else{
                    remove(node)
                }
            }
        }
    }

    fun remove(node: Node) {
        if (node.prev != null){
            if (node.next != null){
                node.prev!!.next = node.next
                node.next!!.prev = node.prev
            }else{
                node.prev!!.next = null
            }
        }else{
            if (node.next != null){
                node.next!!.prev = null
                head = node.next
            }else{
                head = null
                tail = null
            }
        }
    }

    fun containsNodeWithValue(value: Int): Boolean {
        var node = head
        while (node != null){
            if (node.value == value) return true
            node = node.next
        }
        return false
    }

    fun getHead(): Node? { return this.head }

    fun getTail(): Node? { return this.tail }
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