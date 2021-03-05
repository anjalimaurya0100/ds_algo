package array;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {1, 6, 8, 10, 12};
        int[] a2 = {2, 3, 4, 9, 11};

        int m;
        if (a1.length == 1) {
            m = (a1[0] + a2[0]) / 2;
        } else {
            m = medianTwoArrays(a1, 0, a1.length - 1, a2, 0, a2.length - 1);
        }
        System.out.println(m);
    }

    public static int medianTwoArrays(int[] a1, int s1, int e1, int[] a2, int s2, int e2) {
        if (e1 == s1 + 1 && e2 == s2 + 1) {
            return (Math.max(a1[s1], a2[s2]) + Math.min(a1[e1], a2[e2])) / 2;
        }

        int m1 = median(a1, s1, e1);
        int m2 = median(a2, s2, e2);

        int mid1 = (s1 + e1) / 2;
        int mid2 = (s2 + e2) / 2;
        if (m1 == m2) {
            return m1;
        } else if (m1 < m2) {
            return medianTwoArrays(a1, mid1, e1, a2, s2, mid2);
        } else {
            return medianTwoArrays(a1, s1, mid1, a2, mid2, e2);
        }
    }

    public static int median(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        if ((end - start + 1) % 2 == 0) {
            return (array[mid] + array[mid + 1]) / 2;
        }
        return array[mid];
    }
}
