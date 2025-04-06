package document_tagging;

public class Main {
    public static void main(String[] args) {
        System.out.println("Document Tagging System started!");

        // Run CLI
        CommandLineInterface cli = new CommandLineInterface();
        cli.start();
    }
}
