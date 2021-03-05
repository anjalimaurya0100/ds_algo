package HashHeap;

public class NumberToString {
    public String[] singleDigits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public String[] twoDigits = {"", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"};
    public String[] tensMultiple = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public String[] tensPower = {"hundred", "thousand"};

    public static void main(String[] args) {
        NumberToString nts = new NumberToString();
        String str = nts.numberToString(new char[]{'1', '2', '0', '8'});
        System.out.println(str);
    }

    public String numberToString(char[] array) {
        if (array.length == 1) {
            return singleDigits[array[0] - '0'];
        }

        int length = array.length;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < array.length) {
            if (length >= 3) {
                if (array[i] != '0') {
                    sb.append(singleDigits[array[i] - '0'] + " ");
                    sb.append(tensPower[length - 3] + " ");
                }
                length--;
            } else {
                if (array[i] == '1') {
                    sb.append(twoDigits[array[i] - '0' + array[i + 1] - '0'] + " ");
                    i++;
                } else {
                    if (array[i] != '0') {
                        sb.append(tensMultiple[array[i] - '0'] + " ");
                    }
                    i++;
                    if (array[i] != '0') {
                        sb.append(singleDigits[array[i] - '0'] + " ");
                    }
                }
            }
            i++;
        }

        return sb.toString();
    }
}
