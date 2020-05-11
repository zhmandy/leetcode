class Solution {
    // split it into half and compare
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        
        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return rev == x || (rev / 10) == x;
    }
}