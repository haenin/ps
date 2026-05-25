import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.next();
        	char[] c = s.toCharArray();
			int n_count = 0, w_count = 0, s_count = 0, e_count = 0;
            for(int i = 0; i < s.length(); i++){
                if(c[i] == 'N'){
                    n_count ++;
				}else if(c[i] == 'W'){
                    w_count ++;
				}else if(c[i] == 'S'){
                    s_count ++;
                }else if(c[i] == 'E'){
                    e_count ++;
                }
            }
               // x축(E,W) 균형 AND y축(N,S) 균형
            boolean xOk = (e_count == 0 && w_count == 0) || (e_count > 0 && w_count > 0);
            boolean yOk = (n_count == 0 && s_count == 0) || (n_count > 0 && s_count > 0);

            if (xOk && yOk) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }         
        }
    }
}