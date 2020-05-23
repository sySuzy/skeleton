package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        int N = oomages.size();
        int[] buckets = new int[M];
        for (int i = 0; i < M; i++) {
            buckets[i] = 0;
        }
        for (Oomage oomage : oomages) {
            int hashCode = oomage.hashCode();
            int bucketNum = (hashCode & 0x7FFFFFFF) % M;
            buckets[bucketNum] += 1;
        }
        int i = 0;
        for (int bucket : buckets) {
            if (bucket < (double) N / 50.0)  {
                return false;
            }
            if (bucket > (double) N / 2.5) {
                return false;
            }
        }

        return true;
    }
}
