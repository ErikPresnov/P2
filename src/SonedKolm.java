public class SonedKolm {
    public static void main(String[] args) {
        System.out.println(eemaldaSulgudeSees("abc(de f)g(h)i"));
        System.out.println(eemaldaSulgudeSees("a(b((c)d))e((ab)(cd))"));
        System.out.println();
        System.out.println(eemaldaSulgudeSeesPaaritud("abc(def)g(h)i"));
        System.out.println(eemaldaSulgudeSeesPaaritud("a(b((c)d))e((ab)(cd))"));
        System.out.println(eemaldaSulgudeSeesPaaritud("(abc(de(fg))h)"));
        System.out.println();
        System.out.println(abTasakaal("xyzAopAqBrstB"));
        System.out.println(abTasakaal("AAuvwBxAAyzoBpBBq"));
        System.out.println(abTasakaal("ArsBBtuvwxyAz"));
        System.out.println(abTasakaal("opqArstAuvwB"));
        System.out.println(abTasakaal(""));
        System.out.println();
        System.out.println(topeldaSulgudeSisu("m(a)hä(r)a (läki)"));
        System.out.println(topeldaSulgudeSisu("(a)bc(d(e))"));
    }

    public static String eemaldaSulgudeSees(String s) {
        return abi(s, 0, 0);
    }

    private static String abi(String s, int indeks, int seis) {
        if (indeks == s.length()) return "";
        else if (s.charAt(indeks) == '(') return abi(s, indeks + 1, seis + 1);
        else if (s.charAt(indeks) == ')') return abi(s, indeks + 1, seis - 1);
        if (seis == 0) return s.charAt(indeks) + abi(s, indeks + 1, seis);
        return abi(s, indeks + 1, seis);
    }

    public static String eemaldaSulgudeSeesPaaritud(String s) {
        return abi2(s, 0, 0);
    }

    private static String abi2(String s, int i, int seis) {
        if (i == s.length()) return "";
        int uusS = seis;
        if (s.charAt(i) == '(') uusS++;
        if (s.charAt(i) == ')') uusS--;
        if (seis % 2 == 0) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                return s.charAt(i) + abi2(s, i + 1, uusS);
        }
        return abi2(s, i + 1, uusS);
    }

    public static boolean abTasakaal(String s) {
        return abi3(s, 0, 0);
    }

    // Ade arv + ja Bde arv -
    public static boolean abi3(String s, int i, int tasa) {
        if (i == s.length()) return tasa <= 0;
        if (s.charAt(i) == 'A') return abi3(s, i + 1, tasa + 1);
        else if (s.charAt(i) == 'B') return tasa >= 1 && abi3(s, i + 1, tasa - 1);
        return abi3(s, i + 1, tasa);
    }

    public static String topeldaSulgudeSisu(String s) {
        return abi4(s, 0);
    }

    public static String abi4(String s, int i) {
        if (i >= s.length()) return "";
        if (s.charAt(i) == '(') {
            String sisu = leiaSisu(s, i + 1, -1, i + 1);
            return topeldaSulgudeSisu(sisu).repeat(2) + abi4(s, i + sisu.length() + 2);
        }
        return s.charAt(i) + abi4(s, i + 1);
    }

    private static String leiaSisu(String s, int i, int tasa, int a) {
        if (tasa == 0) return s.substring(a, i - 1);
        if (s.charAt(i) == ')') return leiaSisu(s, i + 1, tasa + 1, a);
        if (s.charAt(i) == '(') return leiaSisu(s, i + 1, tasa - 1, a);
        return leiaSisu(s, i + 1, tasa, a);
    }
}
