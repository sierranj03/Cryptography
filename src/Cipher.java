public class Cipher {

    public static String caesar(String str, int key) {
        StringBuilder output = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            c += key;
            output.append(c);
        }

        return output.toString();
    }

}
