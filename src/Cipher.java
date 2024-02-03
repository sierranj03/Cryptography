public class Cipher {

    public static String caesar(String str, int key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            output.append((char) (str.charAt(i) + key));
        }

        return output.toString();
    }

    public static String vigenereEncrypt(String str, String key) {
        String upperStr = str.toUpperCase();
        String upperKey = key.toUpperCase();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < upperStr.length(); i++) {

            int x = ((int) upperStr.charAt(i) + (int) upperKey.charAt(i % upperKey.length()) - 130) % 26;

            output.append((char) (x + 65));
        }

        return output.toString();
    }

    public static String vigenereDecrypt(String str, String key) {
        String upperStr = str.toUpperCase();
        String upperKey = key.toUpperCase();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < upperStr.length(); i++) {

            int x = ((int) upperStr.charAt(i) - (int) upperKey.charAt(i % upperKey.length()) + 130) % 26;

            output.append((char) (x + 65));
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
