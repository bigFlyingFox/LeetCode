public class Solution {
    private static final int[] values = {
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4,
        1
    };
    
    private static final String[] symbol = {
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    };
    
    public String intToRoman(int num) {
        
        int n=num, i=0;
        StringBuilder str=new StringBuilder();
        while (n>0) {
            while (n/values[i]>0) {
                str.append(symbol[i]);
                n -= values[i];
            }
            i++;
        }
        return str.toString();
        
    }
}