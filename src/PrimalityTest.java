import java.io.*;
import java.math.*;
import java.util.Scanner;

public class PrimalityTest {

    private static void calculate(int n) {
        Scanner scanner = new Scanner(System.in);
        int i = 2;
        int k = 1;
        int r = 2;
        int x = 0;
        int z = 37;
        double m = 0;
        double b0 = 0;
        double res = 0;
        boolean prime = true;

        if (n <= 39) {
            z = n - 2;
        }

        if (n % 2 != 0) {
            while (r <= z) {
                // find k and m
                m = (n - 1) / Math.pow(2, k);

                while (m % 2 == 0) {
                    k++;
                    m = (n - 1) / Math.pow(2, k);
                }

                // calculate b0
                b0 = Math.pow(r, m) % n;

                if (b0 == 1 || b0 - n == -1) {
                    break;
                    //  r++;
                    // continue;
                    //System.out.println(n + " --> is probably a prime");
                } else {
                    while (b0 != 1 && b0 - n != -1.0) {
                        x++;
                        if (x >= k) {
                            break;
                        }
                        res = Math.pow(b0, i);
                        b0 = res % n;
                        // i++;
                    }
                    if (b0 == 1) {
                        prime = false;
                        break;
                        //System.out.println(n + " --> is probably not a prime");
                    }
                    if (b0 == -1) {
                        continue;
                    }
                }
                if (prime == false) {
                    break;
                }
                r++;
            }
        } else {
            System.out.println(n + " --> is not a prime");
        }
        if (prime) {
            System.out.println(n + " --> is probably a prime");
        } else {
            System.out.println(n + " --> is probably not a prime");
        }
    }


    public static void main(String[] args) {
        calculate(2821);
    }
}
