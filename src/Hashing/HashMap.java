package Hashing;
import Basics.Node;
import Basics.Element;

/*
 Hash function:
  Hash functions are one-to-one functions that map the elements to their addresses. A good hash function must:
  - scatter the elements evenly, and if possible not address two elements into the same position.
  Basic operations in hash tables :
  - which hash function is used?
  - how is the size of the table chosen?
  - is there collision and how will it be resolved?
 */
public class HashMap {
    /**
     * This implementation makes use of a static Element array. As the array is immutable, another boolean array
     * is used to mark which elements are deleted. N is the size of the array. It is preferable for N to be a prime number.
     */
    Element[] table;
    boolean[] deleted;
    int N;
    int currentSize;

    public HashMap(int N){
        table = new Element[N];
        deleted = new boolean[N];
        this.N = N;
        currentSize = 0;
    }

    public void printMap(){
        for (int i = 0; i < N; i++) {
            if (table[i] != null) {
                System.out.println(i + "th Index: " + table[i].data);
                System.out.println("------");
            } else {
                System.out.println(i + "th Index: empty");
            }
        }
    }

    /**
     * Hash function (modulo) for an integer
     * @param value takes in the value to be placed in the array
     * @return the mod N of the given value where N is the size of the array
     */
    public int hashFunction(int value){
        return value % N;
    }

    /**
     *    This hash function iterates through the characters of the input string,
     *  multiplying the current hash value by 36 and adding the ASCII value of each character.
     *  Finally, it applies a modulo operation using the hash table size (`N`)
     *  to ensure the hash code falls within the valid index range.
     *
     * @param stringValue takes in the string value to be placed in the array
     * @return the mod N of the given value where N is the size of the array
     */
    public int hashFunction(String stringValue){
        int i;
        int position = 0;

        for (i = 0; i < stringValue.length(); i++){
            position = 36 * position + stringValue.charAt(i);
        }
        position = position % N;
        return position;
    }

    public int hashFunctionDouble(int value){
        return 1 + (value % (N - 1));
    }

    /* Open addressing : when there is a collision, we try other addresses until we find an empty one.
     hashFunction(x) + f(1) % N -->
     hashFunction(x) + f(2) % N -->
     hashFunction(x) + f(3) % N   where f is the collision resolution strategy.

     Linear probing : f(i) = (i) just keep adding 1 to the address which comes out of the hash function.
     In linear probing, we have the problem of primary clustering. It refers to the formation of large clusters
     of occupied slots in a hash table, which can lead to performance degradation.
     Search time increases as we insert more elements.
    */

    public Element searchLinear(int searched){
        int address = hashFunction(searched);

        while (table[address] != null){
            if (!deleted[address] && table[address].data == searched){
                break;
            }
            address = (address + 1) % N;
        }
        return table[address];
    }

    public void insertLinear(Element inserted){
        if (currentSize == N){
            System.out.println("The table is full. Rehashing...");
            rehash();
        }
        int index = hashFunction(inserted.data);

        while (table[index] != null){
            if (deleted[index]){
                deleted[index] = false;
                break;
            }
            index = (index + 1) % N;
        }
        table[index] = inserted;
        currentSize++;

    }

    /**
     * The deletion algorithm takes in the Element to be deleted as a parameter. The data stored in the element is
     * put through the hash function to get its regular storing place. In case this spot is filled, the while loop
     * realizes a linear probing strategy to find the Element to be deleted. The loop searches until there are no elements
     * left (null). It breaks out of the loop when it finds the matching element if the element has not already been
     * deleted. Once it breaks, it turns the value of the index to false in the deleted array.
     * @param tobeDeleted the Element to be deleted.
     */
    public void deleteLinear(Element tobeDeleted){
        int index = hashFunction(tobeDeleted.data);

        while (table[index] != null) {
            if (!deleted[index] && table[index] == tobeDeleted){
                break;
            }
                index = (index + 1) & N;
        }
        deleted[index] = true;
    }

    /*
    Quadratic probing: f(i) = i^2
    The number added to the address which comes out of the hash function is increased quadratically (+1, +4 +9..)
    This helps reduce primary clustering. However, quadratic probing brings about the problem of secondary clustering.
    This means that elements which originally map to the address by the hash function follow the same probing steps,
    which also increases search time.
    index = (index + (i * i) & N;
     */

    public Element searchQuadratic(int searched){
        int index = hashFunction(searched);
        int i = 0;

        while (table[index] != null){
            if (!deleted[index] && table[index].data == searched){
                break;
            }
            i++;
            index = (index + i * i) % N;
        }
        return table[index];
    }

    public void insertQuadratic(Element inserted){
        int index = hashFunction(inserted.data);
        int i = 0;
        int probes = 0;

        while (table[index] != null){
            if (deleted[index]){
                deleted[index] = false;
                break;
            }
            i++;
            probes++;
            index = (index + i * i) % N;

            if (index < 0) { // This ensures that the index does not become negative if the number gets too large.
                index += N;
            }

        }

        // If the probes are getting too long (more than N), rehash the table.

        if (probes < N){
            table[index] = inserted;
            currentSize++;
        } else {
            System.out.println("The table is full. Rehashing...");
            rehash();
            insertQuadratic(inserted);
        }
    }

    public void deleteQuadratic(Element tobeDeleted){
        int index = hashFunction(tobeDeleted.data);
        int i = 0;

        while (table[index] != null){
            if (!deleted[index] && table[index] == tobeDeleted){
                deleted[index] = true;
                currentSize--;
                return;
            }
            i++;
            index = (index + i * i) % N;
            if (index < 0){
                index = index + N;
            }
        }
    }

    /*
    Double Hashing:
    Unlike linear or quadratic probing, where the next slot is determined by a fixed or quadratic increment,
    double hashing uses a second hash function to determine the step size. This method significantly
    reduces the chances of both primary and secondary clustering,  leading to a more uniform distribution of
    entries in the hash table.
     */

    public Element searchDouble(int value){
        int index = hashFunction(value);
        int index2 = hashFunctionDouble(value);

        while (table[index] != null){
            if(!deleted[index] && table[index].data == value){
                break;
            }
            index = (index + index2) % N;
        }
        return table[index];
    }


    /*
    Rehashing:
    It is a process used in dynamic hash tables to handle situations where the table becomes too full,
    leading to an increased number of collisions and degraded performance.
    When rehashing occurs, the entire hash table is resized, and all the elements in the table are reinserted
    into the new table using a new hash function or the same hash function with the updated table size.
     */

    public void rehash(){
        Element[] oldTable = table;
        boolean[] oldDeleted = deleted;
        int oldN = N;

        this.N = this.N * 2;
        this.table = new Element[N];
        this.deleted = new boolean[N];

        for (int i = 0; i < oldN; i++){
            if (!oldDeleted[i] && oldTable[i] != null){
                insertLinear(oldTable[i]);
            }

        }
    }

}
