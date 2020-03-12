public class PrimalityTest {
    // Mit power() verkleinern wir den Exponent, durch modulares Potenzieren, damit wir keinen Overflow bei den Datentypen erhalten
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
        int i = 2;
        int k = 1;
        int r = 2;
        int x = 0;
        int z = 37;
        double m = 0;
        double b = 0;
        boolean prime = true;

        // Festlegung der maximalen Grösse der Basis
        if (n <= 39) {
            z = n - 2;
        }

        if (n % 2 != 0) {
            while (r <= z) {
                x = 0;

                // Bestimmen von k und m
                m = (n - 1) / Math.pow(2, k);

                while (m % 2 == 0) {
                    k++;
                    m = (n - 1) / Math.pow(2, k);
                }

                // Berechnen von b
                b = power(r, (int) m, n);

                /*
                 Wenn die Werte getroffen werden, springen wir zum Anfang der while Schlaufe und iterieren r bis zur
                 maximalen Basis, schlussendlich befinden wir uns im if(prime)
                 */
                if (b == 1 || b - n == -1) {
                    r++;
                    continue;
                } else {
                    // b wird quadriert bis zum Punkt wo "-1" oder "1" getroffen wird
                    while (b != 1 && b - n != -1.0) {
                        x++;
                        if (x >= k) {
                            // Hier wird "-1" nicht getroffen somit kann "n" keine Primzahl sein
                            prime = false;
                            break;
                        }
                        b = power((int) b, i, n);
                    }
                    if (b == 1) {
                        prime = false;
                        break;
                    }
                    if (b == -1) {
                        continue;
                    }
                }
                if (!prime) {
                    break;
                }
                r++;
            }
            if (prime) {
                System.out.println(n + " --> is probably a prime");
            } else {
                System.out.println(n + " --> is probably not a prime");
            }
        } else {
            System.out.println(n + " --> is not a prime");
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
