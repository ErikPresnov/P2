import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SonedEsimene {

    public static void main(String[] args) {
        System.out.println(onOsa("kurat", "kuk.u.pr-a**t*"));
    }

    public static int kordusi(String s, char c) {
        int mitu = 0;

        for (char c1 : s.toCharArray()) if (c1 == c) mitu++;

        return mitu;
    }

    public static void pikkusega3(String s) {
        for (int i = 0; i < s.length() - 2; i++) System.out.println(s.substring(i, i + 3));
    }

    public static void pikkusega2korduvad(String s) {
        for (int i = 1; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                int pikkus = 2;
                while (i + pikkus - 1 < s.length() && s.charAt(i) == s.charAt(i + pikkus - 1)) pikkus++;
                System.out.println(s.substring(i - 1, i + pikkus - 1));
                i += pikkus - 1;
            }
        }
    }

    public static void onYks(String s) {
        for (char c : s.toCharArray()) if (s.indexOf(c) == s.lastIndexOf(c)) System.out.println(c);
    }

    public static void onYks2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        for (Character c : map.keySet()) if (map.get(c) == 1) System.out.println(c);
    }

    public static void onMolemasYks(String s, String l) {
        for (char c : s.toCharArray())
            if (s.indexOf(c) == s.lastIndexOf(c) && l.contains(String.valueOf(c)) && l.indexOf(c) == l.lastIndexOf(c))
                System.out.println(c);
    }

    public static void kahesedKordused(String s) {
        for (int i = 2; i <= s.length()/2; i++) {
            for (int j = 0; j < s.length() - i; j++) {
                String alam = s.substring(j, j + i);
                //System.out.println("alamsõne on " + alam);
               if (s.lastIndexOf(alam) > j && s.indexOf(alam) == j) System.out.println(alam);
            }
        }
    }

    public static void eemalda(String s) {
        StringBuilder uus = new StringBuilder();

        for (int i = 0; i < s.toCharArray().length; i++) {
            String t = String.valueOf(s.charAt(i));
            if (s.indexOf(t) < i && s.lastIndexOf(t) > i) continue;
            uus.append(t);
        }

        System.out.println(uus);
    }

    public static String sorteeri(String s) {
        char[] massiivina = s.toCharArray();
        Arrays.sort(massiivina);
        return new String(massiivina);
    }

    public static boolean saabYmber(String s, String l) {
        return s.length() == l.length() && sorteeri(s).equals(sorteeri(l));
    }

    public static boolean onOsa(String e, String t) {
        int tIndex = 0;
        e:for (int i = 0; i < e.toCharArray().length; i++) {
            while (tIndex < t.length())
                if (t.charAt(tIndex++) == e.charAt(i)) continue e;
            return false;
        }
        return true;
    }
}
