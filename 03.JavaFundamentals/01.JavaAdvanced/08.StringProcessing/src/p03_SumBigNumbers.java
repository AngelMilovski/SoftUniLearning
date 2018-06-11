import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String firstNum = removeLeadingZeros(reader.readLine());
        String secondNum = removeLeadingZeros(reader.readLine());
        int count = Math.abs(firstNum.length() - secondNum.length());

        if (firstNum.length() <= secondNum.length()) {
            secondNum = padding(secondNum, count);
        } else {
            String temp = firstNum;
            firstNum = secondNum;
            secondNum = padding(temp, count);
        }
        boolean isOverNine = false;
        String result = "";
        for (int i = 0; i < firstNum.length(); i++) {
            int startInd = firstNum.length() - 1 - i;
            int addend = Integer.valueOf(firstNum.substring(startInd, startInd + 1));
            int addedUp = Integer.valueOf(secondNum.substring(startInd, startInd + 1));
            int sum = addend + addedUp;
            sum += (isOverNine ? 1 : 0);
            isOverNine = false;
            if (sum > 9 && i != firstNum.length() - 1) {
                isOverNine = true;
                sum -= 10;
            }
            result = Integer.toString(sum) + result;

        }
        System.out.println(result);
    }

    private static String padding(String str, int size) {
        StringBuffer padded = new StringBuffer(str);
        for (int i = 0; i < size; i++) {
            padded.insert(i, "0");
        }
        return padded.toString();
    }

    private static String removeLeadingZeros(String number) {
        while (number.length() >= 1 && number.charAt(0) == '0') {
            number = number.substring(1);
        }
        return number;
    }
}
