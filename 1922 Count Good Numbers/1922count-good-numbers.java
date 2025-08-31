class Solution {
    int mod = (1000000007);

    public int countGoodNumbers(long n) {
        long firstPow = computePower(5, (n + 1) / 2) % mod;
        long secPow = computePower(4, n / 2) % mod;
        long ans = (firstPow*secPow)%mod;
        return (int) ans;
    }

    private long computePower(int i, long l) {
        if (l == 0) return 1;
        long temp = computePower(i, l / 2);
        temp = temp % mod;
        return l % 2 == 0 ? (temp * temp) % mod : (i * temp * temp) % mod;
    }
}