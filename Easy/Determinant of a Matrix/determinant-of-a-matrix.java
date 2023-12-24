//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n) {
        int d = 0;
        // code here
        if (n == 1) {
            d = matrix[0][0];
        } else if (n == 2) {
            d = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int[][] newmatrix = new int[n - 1][];
            for (int k = 0; k < n - 1; k++) {
                newmatrix[k] = new int[n - 1];
            }
            for (int skipcol = 0; skipcol < n; skipcol++) {
                int skiprow = 0;

                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j == skipcol) {
                            continue;
                        }
                        newmatrix[i - 1][skiprow] = matrix[i][j];
                        // Move the skiprow increment here
                        skiprow++;
                    }
                    // Reset skiprow after each inner loop
                    skiprow = 0;
                }

                int neg;
                if (skipcol % 2 == 0) {
                    neg = 1;
                } else {
                    neg = -1;
                }

                d += neg * matrix[0][skipcol] * determinantOfMatrix(newmatrix, n - 1);
            }
        }
        return d;
    }
}
