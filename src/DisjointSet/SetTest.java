package DisjointSet;

public class SetTest {
    public static void main(String[] args) {
        int[] elements = {4,9,7,1,0};
        DisjointSet disjointSet = new DisjointSet(elements, 5);

        int rep = disjointSet.findSetRepresentative(2);
        System.out.println(rep);
        disjointSet.union(1,2);
        disjointSet.union(2,4);
        disjointSet.printSets();

    }
}
