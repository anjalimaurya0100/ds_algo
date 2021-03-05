package HashHeap;

public class CheckAnagram {

    public static boolean checkAnagram(String a, String b) {
        int[] array = new int[26];

        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            array[a.charAt(i) - 'A']++;
            array[b.charAt(i) - 'A']--;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "FIREP";
        String b = "FRIED";

        System.out.println(checkAnagram(a, b));
    }
}
