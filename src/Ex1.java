import com.sun.source.util.SourcePositions;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

         /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
         public static void main() {
             String[] good = {"1", "1b2", "01b2", "123bA"};
             System.out.println(maxIndex(good));
         }


         public static int getValueFromString(String x ){

             String[] array={"0" , "1","2" ,"3","4","5","6" , "7","8" ,"9","A","B","C", "D","E" ,"F","G"};

             for (int i = 0; i < array.length; i++) {

                 if (array[i].equals(x))
                     return i;
             }
             return -1;
        }

        //This function converts the string into numbers.
         public static int number2Int(String num) {
            if(!isNumber(num)){
                return -1;
            }

            int sum= 0;

            if (!num.contains("b")){

                return Integer.parseInt(num);
            }
            else {
                String LeftSt = num.substring(0, num.indexOf('b'));
                String baseNum = num.substring(num.indexOf('b') + 1);

                ArrayList<Integer> LeftList = new ArrayList<>();




                    int m = getValueFromString(String.valueOf(baseNum.charAt(0)));

                    for (int j = 0; j < LeftSt.length(); j++) {

                        //Here i convert the left string to integer and put them in array/
                        int convertValue = getValueFromString(String.valueOf(LeftSt.charAt(j)));
                        LeftList.add(convertValue);

                    }
                    for (int r = LeftList.size()-1; r >= 0; r--){

                        int digit=LeftList.get(r);
                        int power=LeftList.size()-1 -r;
                        sum+=digit*(int) Math.pow(m,power);

                    }

                return sum;
            }
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * //@param a String representing a number
         * @return true iff the given String is in a number format
         */

        //function check its digit number/
        public static boolean isDigit(String x){
             if(!x.matches("[0-9]+")){
                 return false;
             }
            return true;
        }


         //This function checks if the "b" condition meets all the requirements.
        public static boolean bContains (String m){
            if(m.length()==1){
                return false;
            }
            int x =m.length()-2 ;

            if ((m.indexOf("b")) != (m.lastIndexOf("b"))){
                       return false;
            }
            if (m.charAt(x) != 'b'){

              return false;
            }

            if (m.charAt(0) == 'b'){

                return false;
            }

            return true;
        }


        public static boolean separateString (String n) {
            n = n.replace("b", "");
            int i=0;
            int x=n.length();

            if(n.charAt(x-1)=='0' || n.charAt(x-1)=='1'){
                return false;
            }


            while (i<x-1) {

                if (n.charAt(x-1) <= n.charAt(i)) {
                    return  false;
                }
                i++;
            }

            return true;
        }






        public static boolean isNumber(String valiidString) {

                boolean ans = true;
            // add your code here


                if (valiidString == null) {
                    return false;
                }
                if ( (valiidString.isEmpty()) ) {                                                //check the size of the string .
                    return false;
                }

                 if (valiidString.contains(" ")){
                     return false;
                 }
                 if (!valiidString.matches("[0-9bA-G]+")) {
                     return false;
                 }


                 if (valiidString.contains("b")){

                     if(bContains (valiidString)){

                        if (separateString(valiidString)){
                            return true;
                        }
                        else return false;

                     }
                     else return false;
                 }


                 else {
                     if(isDigit(valiidString)) {

                         return ans;
                     }

                      return false;
                  }


            }




        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {

            String ans = "";
            // add your code here
            if(num<0 || base<2 || base>16){
                return  ans;
            }
            ans = Integer.toString(num,base);
            return ans.toUpperCase();
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;
            ArrayList<Integer> list = new ArrayList();
            for(int i=0 ;i < arr.length; i++ ){
                int x= number2Int(arr[i]);
                list.add(x);
            }
            //System.out.println(list);
            int max = Collections.max(list);

            //System.out.println(max);
            ans = list.indexOf(max);
            return ans;
        }

}