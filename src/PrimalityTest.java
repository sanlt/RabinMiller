import java.io.*;
import java.math.*;
import java.util.Scanner;

public class PrimalityTest {
    static long power(int x, int y, int p) {
        long x1 = (long) x;
        long res = 1;
        while (y > 0) {
            if (y % 2 != 0) {
                res = (res * x1) % p;
                y = y - 1;
            }
            x1 = (x1 * x1) % p;
            y = y / 2;
        }


        return res;
    }

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
                x = 0;
                // find k and m
                m = (n - 1) / Math.pow(2, k);

                while (m % 2 == 0) {
                    k++;
                    m = (n - 1) / Math.pow(2, k);
                }

                // calculate b0
                b0 = power(r, (int) m, n);

                if (b0 == 1 || b0 - n == -1) {
                    //break;
                    r++;
                    continue;
                    //System.out.println(n + " --> is probably a prime");
                } else {
                    while (b0 != 1 && b0 - n != -1.0) {
                        x++;
                        if (x >= k) {
                            prime = false; //test
                            break;
                        }
                        b0 = power((int) b0, i, n);
                        //res = Math.pow(b0, i);
                        //b0 = res % n;
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
                if (!prime) {
                    break;
                }
                r++;
            }
        } else {
            System.out.println(n + " --> is not a prime");
            System.exit(0);
        }
        if (prime) {
            System.out.println(n + " --> is probably a prime");
        } else {
            System.out.println(n + " --> is probably not a prime");
        }
    }


    public static void main(String[] args) {
        calculate(5);
        calculate(11);
        calculate(999999937);
        calculate(23123143);
        calculate(23123071);
        calculate(2313083);
        calculate(84563131);
        calculate(84563173);
        calculate(1);
        calculate(84563111);
        calculate(84563071);
        calculate(84563103);
        calculate(8456334);
        calculate(8456371);
        calculate(33);
        calculate(13);
        calculate(561);
        calculate(39);
    }
}
