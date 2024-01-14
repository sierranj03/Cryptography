import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
        } else if (from != Encoding.TEXT) {
            output.append(text(Encoding.DECIMAL, decimal(from, str)));
        } else {
            return str;
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
        } else if (from != Encoding.BINARY) {
            output.append(binary(Encoding.DECIMAL, decimal(from, str)));
        } else {
            return str;
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
        } else if (from != Encoding.OCTAL) {
            output.append(octal(Encoding.DECIMAL, decimal(from, str)));
        } else {
            return str;
        }

        return output.toString();
    }

    public static String decimal(Encoding from, String str) {
        StringBuilder output = new StringBuilder();

        switch (from) {
            case TEXT -> {
                char[] chars = str.toCharArray();
                for (char c : chars) {
                    output.append(String.format("%d ", (int) c));
                }
            }
            case BINARY -> {
                String[] binaryValues = str.split(" ");
                for (String binaryValue : binaryValues) {
                    int decimalValue = Integer.parseInt(binaryValue, 2);

                    output.append(String.format("%d ", decimalValue));
                }
            }
            case OCTAL -> {
                String[] octalValues = str.split(" ");
                for (String octalValue : octalValues) {
                    int decimalValue = Integer.parseInt(octalValue, 8);

                    output.append(String.format("%d ", decimalValue));
                }
            }
            case HEX -> {
                String[] hexValues = str.split(" ");
                for (String hexValue : hexValues) {
                    int decimalValue = Integer.parseInt(hexValue, 16);

                    output.append(String.format("%d ", decimalValue));
                }
            }
            case BASE64 -> {
                byte[] decimalValues = Base64.getDecoder().decode(str);
                for (byte decimalValue : decimalValues) {
                    output.append(String.format("%d ", decimalValue));
                }
            }
            case URL -> {
                String urlText = URLDecoder.decode(str, StandardCharsets.UTF_8);
                char[] urlChars = urlText.toCharArray();
                for (char c : urlChars) {
                    output.append(String.format("%d ", (int) c));
                }
            }
            default -> {
                return str;
            }
        }

        return output.toString();
    }

    public static String hex(Encoding from, String str) {
        StringBuilder output = new StringBuilder();

        if (from == Encoding.DECIMAL) {
            String[] decimalValues = str.split(" ");

            for (String decimalValue : decimalValues) {
                String hex = Integer.toHexString(Integer.parseInt(decimalValue));

                output.append(String.format("%s ", hex));
            }
        } else if (from != Encoding.HEX) {
            output.append(hex(Encoding.DECIMAL, decimal(from, str)));
        } else {
            return str;
        }

        return output.toString();
    }

    public static String base64(Encoding from, String str) {
        StringBuilder output = new StringBuilder();

        if (from == Encoding.DECIMAL) {
            output.append(Base64.getEncoder().encodeToString(text(Encoding.DECIMAL, str).getBytes()));
        } else if (from != Encoding.BASE64) {
            output.append(base64(Encoding.DECIMAL, decimal(from, str)));
        } else {
            return str;
        }

        return output.toString();
    }

    public static String url(Encoding from, String str) {
        StringBuilder output = new StringBuilder();

        if (from == Encoding.DECIMAL) {
            output.append(URLEncoder.encode(text(Encoding.DECIMAL, str), StandardCharsets.UTF_8));
        } else if (from != Encoding.URL){
            output.append(url(Encoding.DECIMAL, decimal(from, str)));
        } else {
            return str;
        }

        return output.toString();
    }
}
