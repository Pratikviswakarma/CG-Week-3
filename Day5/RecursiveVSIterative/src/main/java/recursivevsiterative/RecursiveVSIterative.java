package recursivevsiterative;

public class RecursiveVSIterative {
    //Recursive Approach for fibonacci
    public static int fibonacciRecursive(int n){
        if(n<=1){
            return n;
        }
        return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }
    //Iterative Approach for fibonacci
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    // Main method
    public static void main(String[] args) {
        long start=System.nanoTime();
        fibonacciRecursive(40);
        long end=System.nanoTime();
        System.out.println("Time taken by Recursive Approach "+(end-start));

        long s=System.nanoTime();
        fibonacciIterative(40);
        long e=System.nanoTime();
        System.out.println("Time taken by Iterative Approach "+(e-s));
    }
}
