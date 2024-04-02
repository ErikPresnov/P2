import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TeineRek {
    public static boolean kasSaab(int[] raamatud) {
        Arrays.sort(raamatud);
        return kasSaab(raamatud, 0, 0);
    }

    public static boolean kasSaab(int[] raamatud, int indeks, int summa) {
        if (50 <= summa && summa <= 55) return true;
        if (indeks == raamatud.length) return false;
        if (raamatud[indeks] + summa > 55) return false;
        return kasSaab(raamatud, indeks + 1, summa) ||
               kasSaab(raamatud, indeks + 1, summa + raamatud[indeks]);
    }

    public static double tooted100a(double[] hinnad, int indeks, double jooksev) {
        if (jooksev > 100) return 0;
        if (indeks == hinnad.length) return jooksev;
        return Math.max(
                tooted100a(hinnad, indeks + 1, jooksev),
                tooted100a(hinnad, indeks + 1, jooksev + hinnad[indeks])
        );
    }

    public static void jaotusKaheks(int[] kaalud) {
        int[][] parim = leiaJaotus(kaalud, 0, 0, new int[0], new int[0]);
        System.out.printf("Esimene rühm: %s kaaluga %d.%n", Arrays.toString(parim[1]), sum(parim[1], 0));
        System.out.printf("Teine rühm: %s kaaluga %d.%n", Arrays.toString(parim[2]), sum(parim[2], 0));
        System.out.printf("Kaalude erinevus: %d.%n", parim[0][0]);
    }

    public static int sum(int[] kaalud, int i) {
        if (i == kaalud.length) return 0;
        return kaalud[i] + sum(kaalud, i + 1);
    }

    public static int[][] leiaJaotus(int[] kaalud, int indeks, int vahe, int[] vasak, int[] parem) {
        if (indeks == kaalud.length) return new int[][]{{Math.abs(vahe)}, vasak, parem};
        int[][] lisaVasakule = leiaJaotus(kaalud, indeks + 1, vahe - kaalud[indeks], lisaEl(vasak, kaalud[indeks]), parem);
        int[][] lisaParemale = leiaJaotus(kaalud, indeks + 1, vahe + kaalud[indeks], vasak, lisaEl(parem, kaalud[indeks]));
        if (lisaVasakule[0][0] < lisaParemale[0][0]) return lisaVasakule;
        return lisaParemale;
    }

    public static int[] lisaEl(int[] olemas, int uus) {
        int[] tagastus = new int[olemas.length + 1];
        System.arraycopy(olemas, 0, tagastus, 0, olemas.length);
        tagastus[olemas.length] = uus;
        return tagastus;
    }

    public static void main(String[] args) {
        System.out.println(poimesort(8));
    }

    public static int[] juhuarvud(int min, int max, int n) {
        Random r = new Random();
        return IntStream.generate(() -> r.nextInt(min, max)).limit(n).toArray();
    }

    public static void naturaalArvudeLahutus(int n) {
        for (int i = 1; i < n; i++) {
            naturaalArvudeLahutus(n - i, String.valueOf(i), i);
        }
    }

    public static void naturaalArvudeLahutus(int n, String tee, int viimane) {
        if (n < 0) return;
        if (n == 0) System.out.println(tee);
        else {
            naturaalArvudeLahutus(n - viimane - 1, tee + " + " + (viimane + 1), viimane + 1);
            if (viimane > 1) naturaalArvudeLahutus(n - viimane + 1, tee + " + " + (viimane - 1), viimane - 1);
        }
    }

    public static int mituVoimalust(double[] hinnad, int indeks, double summa) {
        if (indeks == hinnad.length) {
            if (Math.abs(100 - summa) <= 0.5) return 1;
            return 0;
        }
        return mituVoimalust(hinnad, indeks + 1, summa) + mituVoimalust(hinnad, indeks + 1, summa + hinnad[indeks]);
    }

    public static int poimesort(int mitu) {
        if (mitu <= 1) return 1;
        int keskmine = mitu / 2;
        return 1 + poimesort(mitu - keskmine) + poimesort(keskmine);
    }
}
