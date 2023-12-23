import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Encoder {

    public static String text(Encoding from, String str) {
        StringBuilder output = new StringBuilder();

        if (from == Encoding.DECIMAL) {
            String[] decimalValues = str.split(" ");

            for (String decimalValue : decimalValues) {
                int ascii = Integer.parseInt(decimalValue);

                output.append((char) ascii);
            }
        }

        return output.toString();
    }

    public static String binary(Encoding from, String str) {
        StringBuilder output = new StringBuilder();

        if (from == Encoding.DECIMAL) {
            String[] decimalValues = str.split(" ");

            for (String decimalValue : decimalValues) {
                String binary = Integer.toBinaryString(Integer.parseInt(decimalValue));

                output.append(String.format("%08d ", Integer.parseInt(binary)));
            }
        }

        return output.toString();
    }

    public static String octal(Encoding from, String str) {
        StringBuilder output = new StringBuilder();

        if (from == Encoding.DECIMAL) {
            String[] decimalValues = str.split(" ");

            for (String decimalValue : decimalValues) {
                String octal = Integer.toOctalString(Integer.parseInt(decimalValue));

                output.append(String.format("%d ", Integer.parseInt(octal)));
            }
        }

        return output.toString();
    }

    public static String decimal(Encoding from, String str) {
        StringBuilder output = new StringBuilder();

        switch (from) {
            case TEXT:
                char[] chars = str.toCharArray();

                for (char c : chars) {
                    output.append(String.format("%d ", (int) c));
                }
                break;

            case BINARY:
                String[] binaryValues = str.split(" ");

                for (String binaryValue : binaryValues) {
                    int decimalValue = Integer.parseInt(binaryValue, 2);

                    output.append(String.format("%d ", decimalValue));
                }
                break;

            case OCTAL:
                String[] octalValues = str.split(" ");

                for (String octalValue : octalValues) {
                    int decimalValue = Integer.parseInt(octalValue, 8);

                    output.append(String.format("%d ", decimalValue));
                }
                break;

            case HEX:
                String[] hexValues = str.split(" ");

                for (String hexValue : hexValues) {
                    int decimalValue = Integer.parseInt(hexValue, 16);

                    output.append(String.format("%d ", decimalValue));
                }
                break;

            case BASE64:
                byte[] decimalValues = Base64.getDecoder().decode(str);

                for (byte decimalValue : decimalValues) {
                    output.append(String.format("%d ", decimalValue));
                }
                break;

            case URL:
                String urlText = URLDecoder.decode(str, StandardCharsets.UTF_8);

                char[] urlChars = urlText.toCharArray();

                for (char c : urlChars) {
                    output.append(String.format("%d ", (int) c));
                }
                break;

            default:
                return str;
        }

        return output.toString();
    }
}
