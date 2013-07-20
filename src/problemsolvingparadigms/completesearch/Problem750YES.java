package problemsolvingparadigms.completesearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem750YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int[] pos = new int[8];
            Arrays.fill(pos, -1);
            int row = sc.nextInt() - 1;
            pos[sc.nextInt() - 1] = row;
            System.out.println("SOLN       COLUMN");
            System.out.println(" #      1 2 3 4 5 6 7 8\n");
            LinkedList<int[]> sol = new LinkedList<int[]>();
            sol.add(pos);
            int ret = 1;
            while (!sol.isEmpty()) {
                int[] cur = sol.poll();
                boolean ada = false;
                for (int i = 0; i < 8 && !ada; i++) {
                    ada = cur[i] == -1 ? true : false;
                }
                if (!ada) {
                    if (ret < 10) {
                        System.out.print(" " + (ret++) + "      ");
                    } else {
                        System.out.print((ret++) + "      ");
                    }
                    for (int i = 0; i < 7; i++) {
                        System.out.print(1 + cur[i] + " ");
                    }
                    System.out.println(1 + cur[7]);
                } else {
                    for (int i = 0; i < 8; i++) {
                        if (cur[i] == -1) {
                            for (int j = 0; j < 8; j++) {
                                boolean bisa = true;
                                for (int k = 0; k < 8; k++) {
                                    int x = cur[k];
                                    if (x == -1) {
                                        continue;
                                    }
                                    if (j == x) {
                                        bisa = false;
                                    }
                                    if (Math.abs(i - k) == Math.abs(j - x)) {
                                        bisa = false;
                                    }
                                }
                                if (bisa) {
                                    int[] temp = cur.clone();
                                    temp[i] = j;
                                    sol.add(temp);
                                }
                            }
                            break;
                        }
                    }
                }
            }
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
}
