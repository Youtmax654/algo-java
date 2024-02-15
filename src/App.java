/**
 * The {@code App} class serves as the entry point for the game application.
 * It contains the main method that calls the {@link Menu#main()} method to
 * start the game.
 */
public class App {

    /**
     * The main method of the application. It throws an exception to handle any
     * potential errors during execution.
     * Calls the {@link Menu#main()} method to initiate the game.
     *
     * @param args Command-line arguments (unused in this application).
     * @throws Exception Any exception that may occur during the execution of the
     *                   program.
     */
    public static void main(String[] args) throws Exception {
        Menu.main(); // Call the menu method to start the game
    }

    /**
     * Method to gracefully exit the game. Clears the console, displays a goodbye
     * message,
     * and then resets the console color to the default.
     */
    public static void leave() {
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("            Goodbye !            ");
        System.out.println("***********************************\u001B[0m");
    }

    /**
     * Converts a given string to binary representation.
     *
     * @param texte The string to be converted.
     * @return The binary representation of the given string.
     */
    /**
     * Converts a given text string to its corresponding binary representation.
     *
     * @param texte The text string to be converted.
     * @return The binary representation of the given text string.
     */
    public static String stringToBinary(String texte) {
        byte[] octets = texte.getBytes(); // Convert the text string to bytes
        StringBuilder binaire = new StringBuilder(); // StringBuilder to store the binary representation

        for (byte octet : octets) { // Iterate through each byte in the text string
            for (int i = 7; i >= 0; i--) { // Iterate through each bit in the byte (from left to right)
                binaire.append((octet >> i) & 1); // Append the binary representation of the bit to the StringBuilder
            }
        }

        return binaire.toString(); // Return the binary representation as a string
    }

    /**
     * Converts a given binary string to its corresponding text representation.
     *
     * @param binaire The binary string to be converted.
     * @return The text representation of the given binary string.
     */
    public static String binaryToString(String binaire) {
        StringBuilder texte = new StringBuilder();

        for (int i = 0; i < binaire.length(); i += 8) {
            String octetBinaire = binaire.substring(i, i + 8); // Extracts 8 bits from the binary string
            int octetDecimal = Integer.parseInt(octetBinaire, 2); // Converts the 8-bit binary string to decimal
            texte.append((char) octetDecimal); // Appends the character representation of the decimal value to the
                                               // StringBuilder
        }

        return texte.toString(); // Returns the text representation as a string
    }
}
