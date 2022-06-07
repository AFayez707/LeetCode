package Misc.Design_HashSet;

import java.util.LinkedList;

public class Bucket {
    private LinkedList<Integer> container;

    public Bucket() {
        this.container = new LinkedList<Integer>();
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if(index == -1)
            this.container.addFirst(key);
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean exists(Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}
