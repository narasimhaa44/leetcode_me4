class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder res = new StringBuilder();

        for (int j = 0; j < cols; j++) {
            int i = 0, col = j;

            while (i < rows && col < cols) {
                res.append(encodedText.charAt(i * cols + col));
                i++;
                col++;
            }
        }

        // remove trailing spaces
        int end = res.length() - 1;
        while (end >= 0 && res.charAt(end) == ' ') end--;

        return res.substring(0, end + 1);
    }
}