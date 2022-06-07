package Misc.Design_HashMap;

public class MyHashMap {
    private Bucket[] bucketArray;
    private int numOfBuckets;

    public MyHashMap() {
        this.numOfBuckets = 1000;
        this.bucketArray = new Bucket[this.numOfBuckets];
        for(int i = 0; i < this.numOfBuckets; i++)
            this.bucketArray[i] = new Bucket();
    }

    protected int hash(int key) {
        return key % this.numOfBuckets;
    }

    public void put(int key, int value) {
        int bucketIndex = this.hash(key);
        this.bucketArray[bucketIndex].update(key, value);
    }

    public void remove(int key) {
        int bucketIndex = this.hash(key);
        this.bucketArray[bucketIndex].remove(key);
    }

    public int get(int key) {
        int bucketIndex = this.hash(key);
        return this.bucketArray[bucketIndex].get(key);
    }
}
