class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int p = a.length() - 1;
        int q = b.length() - 1;
        int carry = 0;

        while (p >= 0 || q >= 0 || carry != 0) {
            
            int sum = carry;
            
            if (p >= 0) {
                sum += a.charAt(p) - '0';
                p--;
            }
            
            if (q >= 0) {
                sum += b.charAt(q) - '0';
                q--;
            }

            sb.append(sum % 2);   // remainder
            carry = sum / 2;      // carry
        }

        return sb.reverse().toString();
    }
}
