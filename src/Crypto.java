import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("""
        Welcome <3
        ----------
        1: Encode
        2: Cipher
        Enter a number (1 or 2) to choose an option.""");

        int action = s.nextInt();

        if (action == 1) {
            System.out.println("""
            Encoding Options
            ----------------
            1: Plaintext
            2: Binary
            3: Octal
            4: Decimal
            5: Hex
            6: Base64
            7: URL
            ----------------
            Enter a number (1-7) to choose the starting format of the string.""");
            int start = s.nextInt();

            System.out.println("Enter a number (1-7) to choose the end format of the string.");
            int end = s.nextInt();
            s.nextLine();

            System.out.println("Enter the string to encode.");
            String str = s.nextLine();

            switch (end) {
                case 1 -> System.out.printf("The encoded string is: %s", Encoder.text(Encoding.valueOf(start), str));
                case 2 -> System.out.printf("The encoded string is: %s", Encoder.binary(Encoding.valueOf(start), str));
                case 3 -> System.out.printf("The encoded string is: %s", Encoder.octal(Encoding.valueOf(start), str));
                case 4 -> System.out.printf("The encoded string is: %s", Encoder.decimal(Encoding.valueOf(start), str));
                case 5 -> System.out.printf("The encoded string is: %s", Encoder.hex(Encoding.valueOf(start), str));
                case 6 -> System.out.printf("The encoded string is: %s", Encoder.base64(Encoding.valueOf(start), str));
                case 7 -> System.out.printf("The encoded string is: %s", Encoder.url(Encoding.valueOf(start), str));
                default -> System.out.println("Invalid option");
            }
        }

        if (action == 2) {
            System.out.println("""
            Cipher Options
            --------------
            1: Caesar
            2: Vigenere (Encrypt)
            3: Vigenere (Decrypt)
            4: XOR
            --------------
            Enter a number (1-4) to choose a cipher to use.""");

            int option = s.nextInt();
            s.nextLine();

            String str;
            int key;
            String strKey;

            switch(option) {
                case 1:
                    System.out.println("Enter the string to encrypt/decrypt.");
                    str = s.nextLine();

                    System.out.println("Enter a number to shift the string.");
                    key = s.nextInt();

                    System.out.printf("The shifted string is: %s", Cipher.caesar(str, key));
                    break;

                case 2:
                    System.out.println("Enter the string to encrypt.");
                    str = s.nextLine();

                    System.out.println("Enter the to string to use as the key.");
                    strKey = s.nextLine();

                    System.out.printf("The encrypted string is: %s", Cipher.vigenereEncrypt(str, strKey));
                    break;

                case 3:
                    System.out.println("Enter the string to decrypt.");
                    str = s.nextLine();

                    System.out.println("Enter the to string to use as the key.");
                    strKey = s.nextLine();

                    System.out.printf("The decrypted string is: %s", Cipher.vigenereDecrypt(str, strKey));
                    break;

                case 4:
                    System.out.println("Enter the string to encrypt.");
                    str = s.nextLine();

                    System.out.println("Enter the to string to use as the key.");
                    strKey = s.nextLine();

                    System.out.printf("The encrypted string is: %s", Cipher.xor(str, strKey));
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

