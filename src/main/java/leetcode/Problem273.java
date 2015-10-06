package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class Problem273 {
    public String numberToWords(int num) {
        System.out.println("Input: " + num);
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        String str = Integer.toString(num);
        Stack<String> stack = new Stack<>();
        for (int i = str.length()-1; i >= 0; i -= 3) {
            if (i-2 < 0) {
                String s = str.substring(0, i+1);
                stack.push(s);
                break;
            }
            String s = str.substring(i-2, i+1);
            stack.push(s);
        }
        int size = stack.size()-1;
        while (!stack.isEmpty()) {
            String s = stack.pop();
            String tmp = s;
            int remainder = Integer.parseInt(tmp);
            while (remainder > 0) {
                int val = Integer.parseInt(tmp);
                int a = (int) Math.pow(10, tmp.length()-1);
                if (val <= 20) {
                    sb.append(getName(val)).append(" ");
                    break;
                } else {
                    int b = val / a;
                    if (val <= 99) {
                        if (b > 0) {
                            sb.append(getName(b * a)).append(" ");
                        }
                    } else {
                        sb.append(getName(b)).append(" ").append(getName(a)).append(" ");
                    }
                }
                remainder = val % a;
                tmp = Integer.toString(remainder);
            }
            if (Integer.parseInt(s) > 0) {
                if (size > 0) {
                    int a = (int) Math.pow(1000, size);
                    sb.append(getName(a)).append(" ");
                }
            }
            size--;
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
        System.out.println("Output: " + prob.numberToWords(0));
        System.out.println("Output: " + prob.numberToWords(100));
        System.out.println("Output: " + prob.numberToWords(2012));
        System.out.println("Output: " + prob.numberToWords(2002));
        System.out.println("Output: " + prob.numberToWords(100000));
        System.out.println("Output: " + prob.numberToWords(100000000));
        System.out.println("Output: " + prob.numberToWords(2));
        System.out.println("Output: " + prob.numberToWords(23));
        System.out.println("Output: " + prob.numberToWords(923));
        System.out.println("Output: " + prob.numberToWords(9234));
        System.out.println("Output: " + prob.numberToWords(92345));
        System.out.println("Output: " + prob.numberToWords(923456));
        System.out.println("Output: " + prob.numberToWords(9234567));
        System.out.println("Output: " + prob.numberToWords(92345678));
        System.out.println("Output: " + prob.numberToWords(923456789));
        System.out.println("Output: " + prob.numberToWords(1234567890));
        System.out.println("Output: " + prob.numberToWords(1200000001));
        System.out.println("Output: " + prob.numberToWords(Integer.MAX_VALUE));
        System.out.println("Output: " + prob.numberToWords(12345));
        System.out.println("Output: " + prob.numberToWords(12));
        System.out.println("Output: " + prob.numberToWords(1099));
    }
}
