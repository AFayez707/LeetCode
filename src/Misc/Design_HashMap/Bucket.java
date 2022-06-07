package Misc.Design_HashMap;

import java.util.LinkedList;

public class Bucket {
    private LinkedList<Node> container;

    public Bucket() {
        this.container = new LinkedList<Node>();
    }

    public void update(Integer key, Integer value) {
        boolean found = false;

        for(Node node : this.container) {
            if (node.getKey().equals(key)) {
                found = true;
                node.setValue(value);
                break;
            }
        }
        if(!found)
            this.container.addFirst(new Node(key, value));
    }

    public void remove(Integer key) {
        for(Node node : this.container) {
            if (node.getKey().equals(key)) {
                this.container.remove(node);
                break;
            }
        }
    }

    public Integer get(Integer key) {
        for(Node node : this.container) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return -1;
    }
}
