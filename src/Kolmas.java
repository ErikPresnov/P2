import java.util.Arrays;

public class Kolmas {
    public static void main(String[] args) {
        int[] arvud = {4,5, 1,4, 2,0, 8,9};
        paarikaupaVahetus(arvud, 0);
        System.out.println(Arrays.toString(arvud));
    }

    public static int sum(int[] arvud, int i) {
        if (i == arvud.length) return 0;
        return arvud[i] + sum(arvud, i + 1);
    }

    public static int min(int[] arvud, int i) {
        if (i == arvud.length) return Integer.MAX_VALUE;
        return Math.min(min(arvud, i + 1), arvud[i]);
    }

    public static boolean vahemikusNullYks(double[] arvud, int i) {
        if (i == arvud.length) return false;
        return (0 < arvud[i] && arvud[i] < 1) || vahemikusNullYks(arvud, i + 1);
    }

    public static int summeeriPaaritudTopelt(int[] arvud, int i) {
        if (i == arvud.length) return 0;
        if (arvud[i] % 2 == 0) return arvud[i] + summeeriPaaritudTopelt(arvud, i + 1);
        return 2 * arvud[i] + summeeriPaaritudTopelt(arvud, i + 1);
    }

    public static int korrutaPaarid(int[] arvud, int i) {
        if (arvud.length % 2 == 0 && i == arvud.length/2 - 1) return arvud[i] * arvud[i + 1];
        if (arvud.length % 2 == 1 && i == arvud.length/2) return arvud[i];
        return korrutaPaarid(arvud, i + 1) + arvud[i] * arvud[arvud.length - 1 - i];
    }

    public static int iKorda(int[] arvud, int i) {
        if (i == arvud.length) return 0;
        return arvud[i] * (i + 1) + iKorda(arvud, i + 1);
    }

    public static double nullistErinevKorrutis(double[] arvud, int i) {
        if (i == arvud.length) return 1;
        if (arvud[i] == 0) return nullistErinevKorrutis(arvud, i + 1);
        return arvud[i] * nullistErinevKorrutis(arvud, i + 1);
    }

    public static void paarikaupaVahetus(int[] arvud, int i) {
        if (arvud.length % 2 == 0 && i == arvud.length) return;
        if (arvud.length % 2 == 1 && i == arvud.length - 1) return;
        int ajutine = arvud[i];
        arvud[i] = arvud[i + 1];
        arvud[i + 1] = ajutine;
        paarikaupaVahetus(arvud, i + 2);
    }
}
