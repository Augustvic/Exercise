package Cache;

import java.util.HashMap;
import java.util.Map;

public class PureLRUCache<K, V> {

    // capacity
    private final Integer capacity;
    // dictionary
    private final Map<K, Node<K, V>> map;
    // list
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public PureLRUCache(Integer capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node<>();
        this.tail = new Node<>();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        moveToLast(node);
        return node.getValue();
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            node = new Node<>();
        }
        node.setKey(key);
        node.setValue(value);
        map.put(key, node);
        moveToLast(node);
        removeEldestIfNecessary();
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    private void moveToLast(Node<K, V> node) {
        Node<K, V> preNode = node.getPre();
        Node<K, V> nextNode = node.getNext();
        if (preNode != null) {
            preNode.setNext(nextNode);
        }
        if (nextNode != null) {
            nextNode.setPre(preNode);
        }
        Node<K, V> preTail = tail.getPre();
        node.setPre(preTail);
        node.setNext(tail);
        preTail.setNext(node);
        tail.setPre(node);
    }

    public void removeEldestIfNecessary() {
        if (map.size() <= this.capacity) {
            return;
        }
        Node<K, V> needRemoveNode = head.getNext();
        if (needRemoveNode == null || needRemoveNode == tail || needRemoveNode.getKey() == null) {
            return;
        }
        head.setNext(needRemoveNode.getNext());
        map.remove(needRemoveNode.getKey());
    }

    static class Node<K, V> {
        private K key;
        private V value;

        private Node<K, V> pre;
        private Node<K, V> next;

        public Node() {
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getPre() {
            return pre;
        }

        public void setPre(Node<K, V> pre) {
            this.pre = pre;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        PureLRUCache<Integer, Integer> cache = new PureLRUCache<>(4);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.get(3);
        cache.put(4, 4);
        cache.get(1);
        cache.put(5, 5);
        cache.put(6, 6);
    }
}
