/**
 * Algo Expert
 * @author Yee
 * 1. Remove duplicates from linked list
 * **/

fun main(){
    val linkedList = DoublyLinkedList()

    val one = Node(1)
    val two = Node(2)
    val three = Node(3)
    val three2 = Node(3)
    val three3 = Node(3)
    val four = Node(4)
    val five = Node(5)
    val six = Node(6)

    linkedList.setHead(one)
    linkedList.insertAfter(one, two)
    linkedList.insertAfter(two, three)
    linkedList.insertAfter(three, four)
    linkedList.insertAfter(four, five)

    linkedList.setHead(four)
    linkedList.setTail(six)
    linkedList.insertBefore(six, three)
    linkedList.insertAfter(six, three2)
}

/** Public functions **/
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


/** Question-3 **/
fun removeKthNodeFromEnd(head: LinkedList, k: Int) {
    var node = head
    var count = 1
    while (node.next != null){
        node = node.next!!
        count ++
    }
    node = head
    for (i in 1 .. count - k){
        node = node.next!!
    }
    if (node.next != null){
        
    }
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
        }else{
            head = nodeToInsert
        }
        node.prev = nodeToInsert
        nodeToInsert.next = node
    }

    fun insertAfter(node: Node, nodeToInsert: Node) {
        if (node.next != null){
            node.next!!.prev = nodeToInsert
            nodeToInsert.next = node.next
        }else{
            tail = nodeToInsert
        }
        node.next = nodeToInsert
        nodeToInsert.prev = node
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