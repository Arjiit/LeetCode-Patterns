class Solution {
    String[] bigUnits = {"", " Thousand", " Million", " Billion"};
    String[] digits = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
    String[] tens = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety" };
    String[] tenToTwenty = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    public String numberToWords(int num) {
        /*
        We see after the hundreds, the units change in 3 places.
        12345 -> 12345/1000 -> 12 (twelve thousand)
        1234567 -> 1234567/1000 -> 1234 -> (234 thousand) -> 1 million
        */
        StringBuilder sb = new StringBuilder();
        int bigIndex = 0;
        while (num != 0) {
            if (num % 1000 != 0) {
                sb.insert(0, parseThreeDigit(num%1000) + bigUnits[bigIndex] + "");
            }
            bigIndex++;
            num = num/1000;
        }
        return sb.length() == 0 ? "Zero": sb.substring(1).toString();
    }
    
    public String parseThreeDigit(int num){
        StringBuilder res = new StringBuilder();
        if (num > 99) {
            res.append(digits[num/100] + " Hundred");
            num = num%100;
        }
        
        if (num >19) {
            res.append(tens[num/10]);
            num = num%10;
        }
        
        if (num > 9) {
            res.append(tenToTwenty[num%10]); 
            return res.toString(); // we can return directly (like words ending with eighteen, thirteen etc)
        }
        return res.append(digits[num]).toString();
    }
}