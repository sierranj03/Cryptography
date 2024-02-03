import java.util.HashMap;

public enum Encoding {
    TEXT(1),
    BINARY(2),
    OCTAL(3),
    DECIMAL(4),
    HEX(5),
    BASE64(6),
    URL(7);

    private int value;
    private static HashMap map = new HashMap<>();

    private Encoding(int value) {
        this.value = value;
    }

    static {
        for (Encoding encoding : Encoding.values()) {
            map.put(encoding.value, encoding);
        }
    }

    public static Encoding valueOf(int value) {
        return (Encoding) map.get(value);
    }
}
