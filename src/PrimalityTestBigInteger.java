import java.math.BigDecimal;
import java.util.Scanner;

public class PrimalityTestBigInteger {

    private static void calculate(BigDecimal n) {
       /* int i = 2;
        int k = 1;
        int r = 2;
        int x = 0;
        int z = 37;
        double m = 0;
        double b0 = 0;
        double res = 0;
        boolean prime = true;
        */

        int k = 1;
        int x = 0;
        int iInt = 2;
        BigDecimal i = new BigDecimal("2");
        BigDecimal r = new BigDecimal("2");
        BigDecimal z = new BigDecimal("37");
        BigDecimal z39 = new BigDecimal("39");
        BigDecimal z0 = new BigDecimal("0");
        BigDecimal z1 = new BigDecimal("1");
        BigDecimal z2 = new BigDecimal("2");
        BigDecimal minus1 = new BigDecimal("-1");
        BigDecimal m;
        BigDecimal b0;
        BigDecimal res;
        boolean prime = true;

        if (n.compareTo(z39) <= 0) {
            z = n.subtract(i);
        }

        if (!n.remainder(i).equals(z0)) {
            while (r.compareTo(z) <= 0) {
                // find k and m
                m = (n.subtract(z1)).divide(i.pow(k));

                while (m.remainder(i).equals(z0)) {
                    k++;
                    m = (n.subtract(z1)).divide(i.pow(k));
                }
                int mm = Integer.parseInt(m.toString());

                // calculate b0
                b0 = r.pow(mm).remainder(n);

                if (b0.equals(z1) || b0.subtract(n).equals(minus1)) {
                    break;
                    //  r++;
                    // continue;
                    //System.out.println(n + " --> is probably a prime");
                } else {
                    while (!b0.equals(z1) && !b0.subtract(n).equals(minus1)) {
                        x++;
                        if (x >= k) {
                            break;
                        }
                        res = b0.pow(iInt);
                        b0 = res.remainder(n);
                        // i++;
                    }
                    if (b0.equals(z1)) {
                        prime = false;
                        break;
                        //System.out.println(n + " --> is probably not a prime");
                    }
                    if (b0.equals(minus1)) {
                        continue;
                    }
                }
                if (prime == false) {
                    break;
                }
                r = r.add(z1);
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
        BigDecimal n = new BigDecimal("2821");
        BigDecimal aa = new BigDecimal("11");
        BigDecimal ab = new BigDecimal("13");
        BigDecimal ac = new BigDecimal("29");
        BigDecimal ad = new BigDecimal("33");
        BigDecimal ae = new BigDecimal("39");
        BigDecimal af = new BigDecimal("41");
        BigDecimal ag = new BigDecimal("23");
        BigDecimal ah = new BigDecimal("39");
        calculate(n);
        calculate(aa);
        calculate(ab);
        calculate(ac);
        calculate(ad);
        calculate(ae);
        calculate(af);
        calculate(ag);
        calculate(ah);
    }
}
