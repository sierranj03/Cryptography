public class Cipher {

    public static String caesar(String str, int key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            output.append((char) (str.charAt(i) + key));
        }

        return output.toString();
    }

    public static String xor(String str, String key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            output.append((char) ((int) str.charAt(i) ^ (int) key.charAt(i % key.length())));
        }

        return output.toString();
    }

}
