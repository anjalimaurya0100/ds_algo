package backtracking;

public class StringPermutation {
    public static void permutations(String str, int s, int e) {
        if (s == e) {
            System.out.println(str);
            return;
        }

        for(int i = s; i <= e; i++) {
            str = swap(str, i, s);
            permutations(str, s+1, e);
            str = swap(str, i, s);
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArray =  str.toCharArray();
        char t = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = t;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String input = "CBA";
        permutations(input, 0, input.length()-1);
    }
}
