import java.lang.reflect.Array;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        int maxLen = 0;
        for (String i : asciis) {
            maxLen = maxLen > i.length() ? maxLen : i.length();
        }
        String[] sorted = new String[asciis.length];
        System.arraycopy(asciis, 0, sorted, 0, asciis.length);
        for (int i = maxLen; i > -1; i--) {
            sortHelperLSD(sorted, i);
        }
        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */

    private static void sortHelperLSD(String[] asciis, int index) {

        // gather all the counts for each value
        int[] counts = new int[256];
        for (String i : asciis) {
            int c = charAtBackToInt(i, index) ;
            counts[c]++;
        }

        // however, below is a more proper, generalized implementation of
        // counting sort that uses start position calculation
        int[] starts = new int[256];
        int pos = 0;
        for (int i = 0; i < starts.length; i += 1) {
            starts[i] = pos;
            pos += counts[i];
        }

        String[] copySource = new String[asciis.length];
        System.arraycopy(asciis, 0, copySource, 0, asciis.length);
        for (int i = 0; i < copySource.length; i += 1) {
            String item = copySource[i];
            int charToInt = charAtBackToInt(item, index);
            int place = starts[charToInt];
            asciis[place] = item;
            starts[charToInt] += 1;
        }
    }

    private static int charAtBackToInt(String str, int i) {

        if (i > str.length() - 1) {
            return (int) ' ';
        } else {
            return (int) str.charAt(i);
        }
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"qwfe", "aeye", "aewgy"};
        String[] sorted = RadixSort.sort(s);
        for (String i : sorted) {
            System.out.println(i);
        }
    }
}
