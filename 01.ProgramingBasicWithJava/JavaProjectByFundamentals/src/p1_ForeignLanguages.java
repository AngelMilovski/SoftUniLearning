import java.util.Scanner;

public class p1_ForeignLanguages {
    public static void main(String[] args) {
        //       Scanner scan = new Scanner(System.in);

          String str = "Angelsa MIilovski";
          StringBuilder bulid = new StringBuilder(str);
          bulid.deleteCharAt(6);  // Shift the positions front.
          bulid.deleteCharAt(6 - 1);
          bulid.deleteCharAt(8 - 1);
          System.out.println("Name is : " + bulid);

//        StringBuffer buffer = new StringBuffer(str);
//        buffer.replace(1, 2, ""); // Shift the positions front.
//        buffer.replace(7, 8, "");
//        buffer.replace(13, 14, "");
//        System.out.println("Buffer : "+buffer);

//        char[] c = str.toCharArray();
//        String new_Str = "";
//        for (int i = 0; i < c.length; i++) {
//            if (!(i == 1 || i == 8 || i == 15))
//                new_Str += c[i];
//        }
//        System.out.println("Char Array : "+new_Str);

//        public String removeChar(String str, Integer n) {
//            String front = str.substring(0, n);
//            String back = str.substring(n+1, str.length());
//            return front + back;
//        }

//        String str = "Angel%Milovski";
//        str = str.replaceFirst(String.valueOf(str.charAt(5)), " ");//'l' will replace with ""
//        System.out.println(str);//output: wecome

    }
}
