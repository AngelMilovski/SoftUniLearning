import java.util.Scanner;

public class p03_FormattingNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = scan.nextInt();
//        double secondNum = scan.nextDouble();
//        double thirdNum = scan.nextDouble();
        long binary = Integer.parseInt(Integer.toBinaryString(firstNum));
//        System.out.println(String.format("|%-10X|%010d|%10.2f|%-10.3f|", firstNum, binary, secondNum, thirdNum));
    }
}


//import java.util.Scanner;
//
//public class p03_FormattingNumbers {
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int firstNum = scan.nextInt();
//        float secondNum = scan.nextFloat();  Double instead Float
//        float thirdNum = scan.nextFloat();   Double instead Float
//
//        String hex = (Integer.toHexString(firstNum).toUpperCase());
//        String binary = getBinary(firstNum);
//        if (binary.length() > 10){
//            binary = getBinaryResize(binary);
//        }
//
//        System.out.println(String.format("|%-10s|%s%s|%10.2f|%-10.3f|"
//                , hex
//                , repeatStr("0", 10 - binary.length())
//                , binary
//                , secondNum
//                , thirdNum));
//    }
//
//    private static String getBinaryResize(String binary) {
//        String newBinary = binary.substring(0, 10);
//        return newBinary;
//    }
//
//    private static String repeatStr(String symbol, int count){
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < count; i++) {
//            sb.append(symbol);
//        }
//        return sb.toString();
//    }
//
//    private static String getBinary(int firstNum){
//        int sum = firstNum;
//        StringBuilder sb = new StringBuilder();
//        while (sum > 0){
//            sb.append(sum % 2);
//            sum = sum / 2;
//        }
//        return sb.reverse().toString();
//    }
//}