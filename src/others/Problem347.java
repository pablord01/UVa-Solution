package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem347 {

    static boolean cek(int n) {
        int[] temp = new int[(n + "").length()];
        temp[0]++;
        int len = (n + "").length(), next = 0;
        String s = n + "";
        while (true) {
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] > 1) {
                    return false;
                }
            }
            next += s.charAt(next) - '0';
            next %= len;
            if (next == 0) {
                break;
            }
            temp[next]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 1) {
                return false;
            }
        }
        return true;
    }

    static boolean valid(int n) {
        int[] temp = new int[10];
        while (n / 10 > 0) {
            temp[n % 10]++;
            n /= 10;
        }
        temp[n]++;
        for (int i = 0; i < 10; i++) {
            if (temp[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int ind = 1;
        String s = "";
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            if (n == 0) {
                break;
            }
            for (int i = n; i <= 9999999; i++) {
                if (valid(i)) {
                    if (cek(i)) {
                        System.out.println("Case " + (ind++) + ": " + i);
                        break;
                    }
                }
            }
        }
    }
}
