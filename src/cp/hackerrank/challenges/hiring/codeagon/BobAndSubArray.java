package cp.hackerrank.challenges.hiring.codeagon;

import java.util.Scanner;

public class BobAndSubArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] arr = new long[n];
        long[][] dp = new long[32][n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            String bs = Long.toBinaryString(arr[i]);
            for (int k = bs.length() - 1; k >= 0; k--) {
                if(bs.charAt(k)=='1')
                    dp[bs.length()-1-k][i] = i+1;
                else
                    dp[bs.length()-1-k][i] = i==0 ? 0 : dp[bs.length()-1-k][i-1];
            }
        }
        
        long sum = 0l;
        for(int i=0; i<32; i++) {
            long count = 0l;
            for(int j=0; j<n; j++) {
                count += dp[i][j];
            }
            sum += (1<<i)*count;
        }
        
        System.out.println(sum);
        in.close();
    }

}

