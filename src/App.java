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
}
