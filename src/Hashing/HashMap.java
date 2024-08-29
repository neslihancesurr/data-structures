package Hashing;

/**
 *  hash function: one-to-one function that maps the elements to their addresses.
 *  a good hash function must: scatter the elements evenly,
 *  and if possible not address two elements into the same position.
 */

/**
 * Basic operations in hash tables:
 * -which hash function is used
 * -how is the size of the table chosen
 * -is there collision and how will it resolved
 */
public class HashMap {
    /**
     * This implementation makes use of a static Element array. As the array is immutable, another boolean array
     * is used to mark which elements are deleted. N is the size of the array. It is preferable for N to be a prime number.
     */
    Element[] table;
    boolean[] deleted;
    int N;

    public HashMap(int N){
        table = new Element[N];
        deleted = new boolean[N];
        this.N = N;
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
}
