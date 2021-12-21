class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1)
            return true;
        
        if(n <= 0)
            return false;
        
        int product = 1;
        for(int i = 1; i < 32; i++) {
            product *= 2;
            
            if(product == n)
                return true;
        }
        
        return false;
    }
}
