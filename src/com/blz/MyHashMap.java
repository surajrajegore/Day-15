package com.blz;

import java.util.ArrayList;

public class MyHashMap<K,V> {
    private final int numOfBuckets;
    ArrayList<MyLinkedList<K>> myBucketArray;

    public MyHashMap() {
        this.numOfBuckets = 10;
        this.myBucketArray = new ArrayList<>(numOfBuckets);
        for (int i = 0; i < numOfBuckets; i++ )
            this.myBucketArray.add(null);
    }
    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numOfBuckets;
        return index;
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myList = this.myBucketArray.get(index);
        if (myList == null)
            return null;
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }
    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList  == null) {
            myLinkedList  = new MyLinkedList<>();
            this.myBucketArray.set(index, myLinkedList );
        }
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList .search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList .append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }
    public void removeKey(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        myLinkedList.delete(key);
        myBucketArray.remove(index);
    }


    @Override
    public String toString() {
        return "MyHashMap [numOfBuckets=" + numOfBuckets + ", myBucketArray=" + myBucketArray + "]";
    }


}