public class OneEditDistance {

    public static void main(String[] args) {
        System.out.println(oneEditDistance("ab", "acb"));
        System.out.println(oneEditDistance("cab", "ad"));
        System.out.println(oneEditDistance("1203", "1213"));
    }

    private static boolean oneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (1 < Math.abs(n - m)) return false;

        if (n < m) return oneEditDistance(t, s);

        int i = 0;
        while (i < m && s.charAt(i) == t.charAt(i)) i++;

        if (m == n) {
            if (i == m) return false;

            i++;
            while (i < m && s.charAt(i) == t.charAt(i)) i++;

        } else {
            while (i < m && s.charAt(i) == t.charAt(i + 1)) i++;
        }

        return i == m;
    }
}
