public class AList {
    public static int[] insert(int[] x, int item, int position) {
        int l = x.length;
        int[] y = new int[l+1];


        if (position<l) {
            System.arraycopy(x, 0, y, 0, position);
            y[position] = item;
            System.arraycopy(x, position, y, position+1, l-position);
        } else {
            System.arraycopy(x, 0, y, 0, l);
            y[l] = item;
        }
        return y;
    }

    public static void reverse(int[] x){
        int n = x.length;
        int index1 = 0;
        int index2 = n-1;
        int t;
        while (index2>index1) {
            t = x[index1];
            x[index1] = x[index2];
            x[index2] = t;
            index1 = index1+1;
            index2 = index2-1;
        }
    }

    public static int[] xify(int[] x) {
        int count = 0;
        for (int i:x) {
            count = count + i;
        }

        int[] res = new int[count];
        int index_for_x = -1;
        int count_for_x = 0;
        int i = 0;
        while (i<count) {
            while (count_for_x<=0) {
                index_for_x = index_for_x + 1;
                count_for_x = x[index_for_x];
            }

            while (count_for_x>0){
                res[i] = x[index_for_x];
                count_for_x = count_for_x -1;
                i = i+1;
            }

        }
        return res;
    }
}