package src.LEETCODE;

public class leet_168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(2147483647));
    }

    public static String convertToTitle(int columnNumber) {
        String result = "";

        while(columnNumber != 0){
            char ch = (char) ((columnNumber-1) % 26 + 65);

            columnNumber = (columnNumber-1) / 26;
            result = ch + result;
        }

        return result;
    }
}
