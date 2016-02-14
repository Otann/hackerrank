package hacker_rank.solve_me_first;

import java.io.*;

public class JavaSolution {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int readInt() throws IOException { return Integer.parseInt(in.readLine()); }
    static int[] readIntArray(int n) throws IOException {
        int[] result = new int[n];
        String[] s = in.readLine().split("\\s");
        for(int i = 0; i < n; i++) { result[i] = Integer.parseInt(s[i]); }
        return result;
    }

    public static void main(String[] args) throws IOException {

        String input;

        while((input = in.readLine()) != null){
            System.out.println(input);
        }

    }

}
