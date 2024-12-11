package DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;

public class DisjointSet {
    Set[] sets;
    int count;

    public DisjointSet(int[] elements, int count){
        int i;
        sets = new Set[count];
        for (i = 0; i < count; i++){
            sets[i] = new Set(elements[i], i);
        }
        this.count = count;
    }

    public int findSetRepresentative(int index){
        if (sets[index].parent == index){
            return sets[index].parent;
        }
        return findSetRepresentative(sets[index].parent);
    }

    public void union(int index1, int index2) {
        int rep1 = findSetRepresentative(index1);
        int rep2 = findSetRepresentative(index2);

        if (rep1 == rep2) {
            return;
        }

        if (sets[rep1].depth > sets[rep2].depth) {
            sets[rep2].parent = rep1;
        } else if (sets[rep1].depth < sets[rep2].depth) {
            sets[rep1].parent = rep2;
        } else {
            sets[rep2].parent = rep1;
            sets[rep1].depth++;
        }
    }

    public void printSets() {
        HashMap<Integer, ArrayList<Integer>> setMap = new HashMap<>();

        // Group elements by their representative
        for (int i = 0; i < count; i++) {
            int rep = findSetRepresentative(i);
            setMap.putIfAbsent(rep, new ArrayList<>());
            setMap.get(rep).add(sets[i].data);
        }

        // Print each set
        for (ArrayList<Integer> set : setMap.values()) {
            System.out.println(set);
        }
    }
}
