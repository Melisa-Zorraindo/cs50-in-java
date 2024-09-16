import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Caesar caesar = new Caesar();

        String text = caesar.getText(scanner);
        int key = caesar.getKey(scanner);

        System.out.println("Encrypted text: " + caesar.getEncryptedText(text, key));

        scanner.close();
    }
}

