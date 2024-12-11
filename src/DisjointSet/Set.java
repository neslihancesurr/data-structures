package DisjointSet;

public class Set {
    int data;
    int parent;
    int depth;

    public Set(int data, int index){
        this.data = data;
        this.parent = index;
        depth = 1;
    }
}

