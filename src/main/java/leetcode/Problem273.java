package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class Problem273 {
    public String numberToWords(int num) {
        System.out.println("* num=" + num + " *");
        if (num <= 20) {
            if (num == 0) {
                return "Zero";
            }
            return getName(num);
        }
        int length = 0;
        int x = num;
        while (x  > 0) {
            x /= 10;
            length++;
        }
        StringBuilder sb = new StringBuilder();
        int val = num;
        length--;
        while (length >= 0) {
            int divisor = (int) Math.pow(10, length);
            if (val < divisor) {
                length--;
                continue;
            }
            System.out.println("- divisor="  + divisor + ", val=" + val);
            if (divisor == 10000000) {
                System.out.println("block 1");
                length -= 2;
                divisor = 1000000;
                int z = val / divisor;
                sb.append(numberToWords(z) + " " + getName(divisor) + " ");
            } else if (divisor == 10000) {
                System.out.println("block 2");
                length -= 2;
                divisor = 1000;
                int z = val / divisor;
                sb.append(numberToWords(z) + " " + getName(divisor) + " ");
            } else if (divisor == 10 || divisor == 1) {
                System.out.println("block 3");
                String s = getName(val);
                if (s.isEmpty()) {
                    length--;
                    int z = val / divisor;
                    s = getName(z * divisor);
                } else {
                    length -= 2;
                }
                System.out.println("s=" + s);
                sb.append(s + " ");
            } else {
                System.out.println("block 4");
                length--;
                int z = val / divisor;
                String s = getName(divisor);
                String t = "";
                if (s.isEmpty()) {
                    int div = divisor;
                    s = "";
                    int y = 0;
                    while (s.isEmpty()) {
                        div /= 1000;
                        s = getName(div);
                        y++;
                    }
                    if (val % divisor == 0) {
                        t = getName((int) Math.pow(1000, y));
                    }
                }
                System.out.println("s=" + s);
                sb.append(getName(z) + " " + s + " " + t);
            }
            val = val % divisor;
        }
        return sb.toString().trim();
    }

    private String getName(int n) {
        if  (n == 1) {
            return "One";
        } else if (n == 2) {
            return "Two";
        } else if (n == 3) {
            return "Three";
        } else if (n == 4) {
            return "Four";
        } else if (n == 5) {
            return "Five";
        } else if (n == 6) {
            return "Six";
        } else if (n == 7) {
            return "Seven";
        } else if (n == 8) {
            return "Eight";
        } else if (n == 9) {
            return "Nine";
        } else if (n == 10) {
            return "Ten";
        } else if (n == 11) {
            return "Eleven";
        } else if (n == 12) {
            return "Twelve";
        } else if (n == 13) {
            return "Thirteen";
        } else if (n == 14) {
            return "Fourteen";
        } else if (n == 15) {
            return "Fifteen";
        } else if (n == 16) {
            return "Sixteen";
        } else if (n == 17) {
            return "Seventeen";
        } else if (n == 18) {
            return "Eighteen";
        } else if (n == 19) {
            return "Nineteen";
        } else if (n == 20) {
            return "Twenty";
        } else if (n == 30) {
            return "Thirty";
        } else if (n == 40) {
            return "Forty";
        } else if (n == 50) {
            return "Fifty";
        } else if (n == 60) {
            return "Sixty";
        } else if (n == 70) {
            return "Seventy";
        } else if (n == 80) {
            return "Eighty";
        } else if (n == 90) {
            return "Ninety";
        } else if (n == 1000000000) {
            return "Billion";
        } else if (n == 1000000) {
            return "Million";
        } else if (n == 1000) {
            return "Thousand";
        } else if (n == 100) {
            return "Hundred";
        }
        return "";
    }

    public static void main(String[] args) {
        Problem273 prob = new Problem273();
//        System.out.println(prob.numberToWords(0));
//        System.out.println(prob.numberToWords(100));
//        System.out.println(prob.numberToWords(2012));
//        System.out.println(prob.numberToWords(100000));
        System.out.println(prob.numberToWords(100000000));
//        System.out.println(prob.numberToWords(2));
//        System.out.println(prob.numberToWords(23));
//        System.out.println(prob.numberToWords(923));
//        System.out.println(prob.numberToWords(9234));
//        System.out.println(prob.numberToWords(92345));
//        System.out.println(prob.numberToWords(923456));
//        System.out.println(prob.numberToWords(9234567));
//        System.out.println(prob.numberToWords(92345678));
//        System.out.println(prob.numberToWords(923456789));
//        System.out.println(prob.numberToWords(1234567890));
//        System.out.println(prob.numberToWords(Integer.MAX_VALUE));
//        System.out.println(prob.numberToWords(12345));
//        System.out.println(prob.numberToWords(12));
    }
}
