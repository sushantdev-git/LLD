package cache.policies;

import java.util.HashMap;
import java.util.Map;

import cache.dataStructures.DoublyLinkedList;
import cache.dataStructures.DoublyLinkedListNode;

public class LRUEvictionPolicy<Type> implements EvictionPolicy<Type>{
    
    private Map<Type,DoublyLinkedListNode<Type>> keyToNode;
    private DoublyLinkedList<Type> dll;

    public LRUEvictionPolicy(){
        keyToNode = new HashMap<Type,DoublyLinkedListNode<Type>>();
        dll = new DoublyLinkedList<Type>();
    }

    @Override
    public void keyAccessed(Type accessedKey) {

        if(keyToNode.containsKey(accessedKey)){
            dll.removeNode(keyToNode.get(accessedKey));
            dll.addNodeInLast(keyToNode.get(accessedKey));
        }
        else{
            DoublyLinkedListNode<Type> node = new DoublyLinkedListNode<Type>(accessedKey);
            keyToNode.put(accessedKey, node);
            dll.addNodeInLast(node);
        }
    }

    @Override
    public Type evictKey() {
        DoublyLinkedListNode<Type> head = dll.getFirstNode();
        keyToNode.remove(head.getVal());
        dll.removeNode(head);
        return head.getVal();
    }
}
