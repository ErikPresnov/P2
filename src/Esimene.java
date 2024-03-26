public class Esimene {

    public static void main(String[] args) {
        eemalda(2, "erik", 0);
    }

    private static void bitid(int i) {
        bitid(4, "0");
    }

    private static void bitid(int i, String tee) {
        if (i == 0) {
            System.out.println(tee);
            return;
        }
        bitid(i - 1, tee + '0');
        if (tee.equals("") || tee.charAt(tee.length() - 1) != '1') bitid(i - 1, tee + '1');
    }

    private static void lahutused(int i) {
        lahutused(i, "");
    }

    private static void lahutused(int i, String tee) {
        if (i == 0) {
            System.out.println(tee.substring(2));
            return;
        }
        if (i < 2) return;
        lahutused(i - 3, tee + ", " + 3);
        lahutused(i - 2, tee + ", " + 2);
    }

    private static int lahutusedSuurem(int i) {
        return lahutusedSuurem(i, "");
    }

    private static int lahutusedSuurem(int i, String tee) {
        if (i == 0) {
            System.out.println(tee.substring(2));
            return 1;
        }
        if (i < 3) return 0;
        return lahutusedSuurem(i - 5, tee + ", " + 5) +
               lahutusedSuurem(i - 4, tee + ", " + 4) +
               lahutusedSuurem(i - 3, tee + ", " + 3);
    }

    private static long summa(int i) {
        return summa(i - 1, 3);
    }

    private static long summa(int i, int jooksev) {
        if (i == 0) return jooksev;
        return summa(i - 1, jooksev * 10 + 3) + summa(i - 1, jooksev * 10 + 7);
    }

    private static void arvud(int i) {
        arvud(i, 0);
    }

    private static void arvud(int i, long jooksev) {
        if (i == 0) {
            System.out.println(jooksev);
            return;
        }
        int esimene;
        if (jooksev == 0) esimene = 9;
        else esimene = (int) (jooksev % 10) - 1;
        for (int j = esimene; j >= i - 1; j--)
            arvud(i - 1, jooksev * 10 + j);
    }

    private static void eemalda(int i, String k, int viimane) {
        if (i == 0) {
            System.out.println(k);
            return;
        }
        for (int indeks = viimane; indeks < k.length(); indeks++)
            eemalda(i - 1, k.substring(0, indeks) + k.substring(indeks + 1), indeks);
    }
}
