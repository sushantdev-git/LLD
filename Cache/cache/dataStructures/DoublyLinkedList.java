package cache.dataStructures;


public class DoublyLinkedList<Type> {
    
    private DoublyLinkedListNode<Type> head = null;
    private DoublyLinkedListNode<Type> tail = null;
    private int size = 0;

    public void removeNode(DoublyLinkedListNode<Type> node){
        if(node == null) return;

        DoublyLinkedListNode<Type> prev = node.prev;
        DoublyLinkedListNode<Type> next = node.next;

        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;

        if(node == head) head = head.next;
        if(node == tail) tail = tail.prev;

        if(size > 0) size--;
    }


    public void addNodeInLast(DoublyLinkedListNode<Type> node){

        size++;

        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void addNodeInFront(DoublyLinkedListNode<Type> node){
        size++;

        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        head.prev = node;
        node.next = head;
        head = node;
    }

    public DoublyLinkedListNode<Type> getFirstNode(){
        if(size == 0) return null;
        return head;
    }

    public int size(){
        return this.size;
    }

}
