package Design_HashSet;

public class MyHashSet {
    private Bucket[] bucketArray;
    private int numOfBuckets;

    public MyHashSet() {
        this.numOfBuckets = 1000;
        this.bucketArray = new Bucket[this.numOfBuckets];
        for(int i = 0; i < this.numOfBuckets; i++)
            this.bucketArray[i] = new Bucket();
    }

    protected int hash(int key) {
        return key % this.numOfBuckets;
    }

    public void add(int key) {
        int bucketIndex = this.hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this.hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    public boolean contains(int key) {
        int bucketIndex = this.hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}
