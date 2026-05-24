import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] x = new int[N];
            int[] y = new int[N];
            for (int i = 0; i < N; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            
            int maxArea = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    for (int k = j+1; k < N; k++) {
                        int area = 0;
                        
                        // x[i]==x[j]: 세로변, 가로변은 k와 연결
                        if (x[i] == x[j]) {
                            if (y[i] == y[k])
                                area = Math.abs(x[i]-x[k]) * Math.abs(y[i]-y[j]);
                            if (y[j] == y[k])
                                area = Math.abs(x[j]-x[k]) * Math.abs(y[i]-y[j]);
                        }
                        // x[i]==x[k]: 세로변, 가로변은 j와 연결
                        if (x[i] == x[k]) {
                            if (y[i] == y[j])
                                area = Math.abs(x[i]-x[j]) * Math.abs(y[i]-y[k]);
                            if (y[k] == y[j])
                                area = Math.abs(x[k]-x[j]) * Math.abs(y[i]-y[k]);
                        }
                        // x[j]==x[k]: 세로변, 가로변은 i와 연결
                        if (x[j] == x[k]) {
                            if (y[j] == y[i])
                                area = Math.abs(x[j]-x[i]) * Math.abs(y[j]-y[k]);
                            if (y[k] == y[i])
                                area = Math.abs(x[k]-x[i]) * Math.abs(y[j]-y[k]);
                        }
                        
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
            
            System.out.println(maxArea);
        }
    }
}