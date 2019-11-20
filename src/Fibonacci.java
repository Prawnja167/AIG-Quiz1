public class Fibonacci {
    int fib;
    int [] memo = new int[100];

    public int doFibo(int fib) {
        memo[0] = 0;
        memo[1] = 1;

        for (int i=2; i<=fib; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[fib];
    }

    public Fibonacci() {
        System.out.println(doFibo(10));
    }
}
