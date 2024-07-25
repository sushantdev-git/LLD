package cache.dataStructures;

public class DoublyLinkedListNode<Type> {
    Type Value;
    DoublyLinkedListNode<Type> prev;
    DoublyLinkedListNode<Type> next;

    public DoublyLinkedListNode(Type val){
        this.Value = val;
    }

    public Type getVal(){
        return this.Value;
    }
}
