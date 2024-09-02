public class StringEncryptor {

    // Static method to encrypt the entire string
    public static String encryptString(String input1, int input2) {
        // Create an instance of CharacterEncryptor
        CharacterEncryptor encryptor = new CharacterEncryptor(input2);

        // Split the input string into words
        String[] words = input1.split(" ");
        StringBuilder encryptedString = new StringBuilder();

        // Encrypt each word
        for (String word : words) {
            encryptedString.append(encryptor.encryptWord(word)).append(" ");
        }

        // Remove the trailing space and return the result
        return encryptedString.toString().trim();
    }

    // Main method to test the encryption
    public static void main(String[] args) {
        String input1 = "Wipro Tech";
        int input2 = 20;

        // Encrypt the string and print the result
        String encrypted = encryptString(input1, input2);
        System.out.println("Encrypted words: " + encrypted);
    }
}

// Helper class to handle character encryption
class CharacterEncryptor {
    private final int keyValue;

    // Constructor to initialize the key value
    public CharacterEncryptor(int keyValue) {
        this.keyValue = keyValue;
    }

    // Method to encrypt a single word
    public String encryptWord(String word) {
        StringBuilder encryptedWord = new StringBuilder();

        for (char ch : word.toCharArray()) {
            encryptedWord.append(encryptCharacter(ch));
        }

        return encryptedWord.toString();
    }

    // Method to encrypt a single character
    private char encryptCharacter(char ch) {
        // Check if the character is a letter
        if (!Character.isLetter(ch)) {
            return ch; // Non-letter characters remain unchanged
        }

        // Determine the base value and case
        int base = Character.isLowerCase(ch) ? 'a' : 'A';
        int charValue = Character.toUpperCase(ch) - 'A'; // Convert to uppercase for uniformity

        // Encrypt the character
        int encryptedValue = (charValue + keyValue) % 26;
        char encryptedChar = (char) (encryptedValue + 'A');

        // Convert case
        if (Character.isLowerCase(ch)) {
            return Character.toLowerCase(encryptedChar);
        } else {
            return Character.toUpperCase(encryptedChar);
        }
    }
}
