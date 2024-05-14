import java.util.*;

public class SonedKaks {
    public static void main(String[] args) {
        yksteist(new String[][]{{"Mari", "Jüri"}, {"jookseb", "joob"}, {"kiiresti", "terviseks", "mõnuga"}});
    }

    public static String esimene(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String teine(String s) {
        for (int i = s.length() - 1; i > 1; i--) {
            for (int j = 0; j < s.length() - i; j++) {
                String alam = s.substring(j, j + i);
                if (onPalindroom(alam))
                    return alam;
            }
        }
        return null;
    }

    public static boolean onPalindroom(String s) {
        for (int i = 0; i < s.length()/2; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return true;
    }

    public static String kolmas(String s) {
        int kust = 0, pikkus = 1, i = 0,j = 0;
        Set<Character> olemas = new HashSet<>();

        while (i < s.length()) {
            while (i < s.length() && olemas.add(s.charAt(i))) i++; // lisame kuni "konflikti" ei ole
            if (olemas.size() > pikkus) { // kui uus pikkus siis uuendame alguspunkti
                pikkus = olemas.size();
                kust = j;
            }
            while (j < s.length() && i < s.length() && s.charAt(j) != s.charAt(i)) olemas.remove(s.charAt(j++)); // eemaldame konflikti ees olevad
            olemas.remove(s.charAt(j++)); // ja konflikti tekitanud sümboli
        }

        return s.substring(kust, kust + pikkus);
    }

    public static String neljas(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length();) {
            sb.append(s.charAt(i));
            char praegune = Character.toLowerCase(s.charAt(i));
            while (++i < s.length() && Character.toLowerCase(s.charAt(i)) == praegune);
        }

        return sb.toString();
    }

    public static String viies(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (s.charAt(i) == 's') {
                while (++i < s.length() && (s.charAt(i) == 's' || s.charAt(i) == 'z')) sb.append('s');
                i--;
            } else if (s.charAt(i) == 'z') {
                while (++i < s.length() && (s.charAt(i) == 's' || s.charAt(i) == 'z')) sb.append('z');
                i--;
            }
        }

        return sb.toString();
    }

    public static String kuues(String s) {
        String[] osad = s.split(" ");

        for (int i = 0; i < osad.length; i++) {
            boolean esinebV = false;

            for (int j = 0; j < osad[i].length(); j++)
                if (Character.isLowerCase(osad[i].charAt(j))) {
                    esinebV = true;
                    break;
                }


            if (esinebV) osad[i] = osad[i].toLowerCase();
        }

        return String.join(" ", osad);
    }

    public static String seitsmes(String s) {
        String[] osad = s.split(" ");

        for (int i = 0; i < osad.length; i++) {
            boolean numbrid = false;
            boolean tahed = false;

            for (int j = 0; j < osad[i].length(); j++) {
                if (Character.isLetter(osad[i].charAt(j))) tahed = true;
                if (Character.isDigit(osad[i].charAt(j))) numbrid = true;
            }

            if (numbrid && tahed) osad[i] = osad[i].replaceAll("\\d", "");
        }

        return String.join(" ", osad);
    }

    public static boolean onT(char c) {
        return List.of('a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'ü', 'õ').contains(c);
    }

    public static String kaheksas(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, 2);

        for (int i = 2; i < s.length() - 2; i++) {
            if (!onT(s.charAt(i)) && onT(s.charAt(i + 1))) sb.append("-");
            sb.append(s.charAt(i));
        }

        sb.append(s, s.length() - 2, s.length());
        return sb.toString();
    }

    public static String yheksas(String a, String b) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.min(a.length(), b.length()); i++)
            if (Character.toLowerCase(a.charAt(i)) == Character.toLowerCase(b.charAt(i)))
                sb.append(Character.toLowerCase(a.charAt(i)));

        return sb.toString();
    }

    public static boolean kymnes(String koos, String a, String b) {
        if (koos.isEmpty()) return true;
        boolean tulemus = false;
        if (!a.isEmpty() && koos.charAt(0) == a.charAt(0)) tulemus = kymnes(koos.substring(1), a.substring(1), b);
        if (!tulemus && !b.isEmpty() && koos.charAt(0) == b.charAt(0)) tulemus = kymnes(koos.substring(1), a, b.substring(1));
        return tulemus;
    }

    public static void yksteist(String[][] jarjendid) {
        List<String> tulemus = abi(jarjendid, "", 0);

        tulemus.sort((o1, o2) -> o2.length() - o1.length());

        for (String t : tulemus)
            System.out.println(t);

    }

    private static List<String> abi(String[][] jarjendid, String jooksev, int indeks) {
        List<String> t = new ArrayList<>();
        if (indeks == jarjendid.length) {
            t.add(jooksev);
            return t;
        }

        for (int i = 0; i < jarjendid[indeks].length; i++)
            t.addAll(abi(jarjendid, jooksev + " " + jarjendid[indeks][i], indeks + 1));

        return t;
    }
}
