package com.blz;

public class MyMapNode<K, V> implements INode<K> {

    K key;
    V value;
    MyMapNode<K, V> next;


    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public INode<K> getNext() {
        return next;
    }


    public void setNext(INode<K> next) {
        this.next = (MyMapNode<K, V>) next;
    }

    @Override
    public String toString() {
        return "MyMapNode{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
