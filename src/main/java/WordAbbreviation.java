public class WordAbbreviation {

    public static void main(String[] args) {
        System.out.println(wordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(wordAbbreviation("apple", "a2e"));
    }

    private static boolean wordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) != abbr.charAt(j)) return false;

                i++;
                j++;
            } else {
                int k = j;
                while (k < abbr.length() && Character.isDigit(abbr.charAt(k))) k++;

                int num = Integer.parseInt(abbr.substring(j, k));

                i += num;
                j = k;
            }
        }

        return i == word.length() && j == abbr.length();
    }
}
